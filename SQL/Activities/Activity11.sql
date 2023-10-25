REM   Script: Activity11
REM   Activity11



SELECT a.salesman_id, name, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, name, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

select customer_id id, customer_name name from customers  
where 1<(select count(*) from orders where customers.customer_id = orders.customer_id) 
union 
select salesman_id, salesman_name from salesman  
where 1<(select count(*) from orders where salesman.salesman_id = orders.salesman_id);

select a.salesman_id, salesman_name, order_no, 'highest on', order_date from salesman a, orders b 
where a.salesman_id = b.salesman_id and 
b.purchase_amount = (select max(purchase_amount) from orders c where c.order_date = b.order_date) 
union 
select a.salesman_id, salesman_name, order_no, 'lowest on', order_date from salesman a, orders b 
where a.salesman_id = b.salesman_id and 
b.purchase_amount = (select min(purchase_amount) from orders c where c.order_date = b.order_date) 
order by order_date;

