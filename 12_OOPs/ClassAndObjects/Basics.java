
// Defining the class 
// class className{ }
class Student{
    String name; //data members
    int rollNo; //data members

    public void printInfo(){ //data functions
        System.out.println("My name is "+name+ ".\nMy roll no is "+rollNo+".\n");
    }
}


public class Basics{
    public static void main(String args[]){

        // creating the object of the class
        Student s1=new Student();
        s1.name="Sahil";
        s1.rollNo=323040;
        s1.printInfo();

        // we can make multiple objects for same class as the objects are like the products of same type 
        // and the class is like the plan(blueprint) which is use to construct the product
        // i.e. with the same plan we can make products
        Student s2=new Student();
        s2.name="sam";
        s2.rollNo=212345;
        s2.printInfo();
    }
}