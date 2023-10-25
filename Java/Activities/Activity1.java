package Activity;


public class Activity1 {
    public static void main(String args[]) {
        Car TUV = new Car();
        TUV.make = 2014;
        TUV.color = "Black";
        TUV.transmission = "Manual";
        TUV.displayCharacterstics();
        TUV.accelerate();
        TUV.brake();
    }
}
