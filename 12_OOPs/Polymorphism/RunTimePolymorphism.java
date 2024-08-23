class Shape{
    String name;

    public void area(){
        System.out.println("The area of shape is ");
    }
}

class Triangle extends Shape{

    public void area(int b,int h){
        System.out.println("The area of " + this.name+" is "+((0.5)*b*h));
    }
}

class Circle extends Shape{
    public void area(){
        System.out.println("The area of " + this.name+" is ");
    }

} 


public class RunTimePolymorphism {
    public static void main(String []args){
        Triangle tri=new Triangle();
        tri.name="Triangle";
        tri.area(10,11);

        Circle cir=new Circle();
        cir.name="Circle";
        // Here Shape(parent class) and Circle(child class) both contains same method 
        // and thus child class overrides the parent class
        cir.area();

    }
}
