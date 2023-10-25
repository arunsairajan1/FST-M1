REM   Script: Activity9
REM   Activity9



select customer_name, salesman.salesman_name from customers inner join salesman on customers.salesman_id = salesman.salesman_id;

select customer_name, grade, salesman.salesman_name from customers inner join salesman on customers.salesman_id = salesman.salesman_id 
where grade<300 order by customer_name;

select customer_name, salesman_name, commission from customers inner join salesman on customers.salesman_id = salesman.salesman_id where commission>12 
order by customer_name;

select order_no, purchase_amount, order_date, customer_name, salesman_name, commission from orders 
inner join customers on orders.customer_id = customers.customer_id 
inner join salesman on orders.salesman_id = salesman.salesman_id 
order by order_no;

