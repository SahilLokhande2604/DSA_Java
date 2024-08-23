
class Vehicle {
    String name;
    String fuel;
    int seats;

    // Non-parameterized constructor
    // The constructor which does not take any arguments
    Vehicle() {
        System.out.println("Hello, I am Non-parameterized constructor");
    }

    // Parameterized constructor
    // The constructor which takes arguments
    Vehicle(String nameOfVehicle, String fuelType, int noOfSeats) {
        this.name = nameOfVehicle;
        this.fuel = fuelType;
        this.seats = noOfSeats;
        System.out.println("Hello, I am Parameterized constructor");

    }

    // Copy constructor
    // The constructor which takes arguments as an object and create new object same as that of the object which is taken as argument
    // It is user-define and does not get created automatically in java but in C++
    Vehicle(Vehicle car){
        this.name=car.name;
        this.fuel=car.fuel;
        this.seats=car.seats;
        System.out.println("Hello, I am copy constructor");
    }

    public void printInfo() {
        System.out.println("Vehicle name:" + name + "\nNo. of seats:" + seats + "\nFuel:" + fuel + "\n");
    }
}

public class Types {
    public static void main(String args[]) {

        Vehicle car = new Vehicle();
        
        
        car.name = "Swift";
        car.seats = 4;
        car.fuel = "Petrol";
        car.printInfo();

        Vehicle car2 = new Vehicle("Ertiga", "Diesel", 7);
        car2.printInfo();

        Vehicle car3=new Vehicle(car);

        car3.printInfo();

    }
}
