
class Vehicle{
    String name;
    int noOfSeats;
    int noOfWheels;

    public void printInfo(){
        System.out.println("Vehicle name:"+name+"\nNo. of seats:"+noOfSeats+"\nNo. Of Wheels:"+noOfWheels+"\n");
    }

    // constructor name is same as that of the class name
    // if it is not define by the user then it gets automatically created in java
    Vehicle(){
        System.out.println("Hello, I am a constructor and gets call when the object is created");
    }
}


public class Constructor{
    public static void main(String args[]){

        Vehicle v1=new Vehicle();
        // when the object is created the constructor is call

        v1.name="Swift";
        v1.noOfSeats=4;
        v1.noOfWheels=4;
        v1.printInfo();

        Vehicle v2=new Vehicle();

        v2.name="Shine";
        v2.noOfSeats=2;
        v2.noOfWheels=2;
        v2.printInfo();

    } 
}