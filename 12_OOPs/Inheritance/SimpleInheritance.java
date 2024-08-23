
class Animal{
    public int eyes=2;
    int ears=2;
    int legs;
    String food;
    Animal(){
        System.out.println("I am Animal Constructor");
    }
}

// Simple inheritance
// there is single child(derived) class which extends single parent(base) class 
// i.e. parent class=Animal
//      child class=Dog
class Dog extends Animal{
    public void foodType(String food,int legs){
        this.food=food;
        this.legs=legs;
        System.out.println("The Dog eats "+this.food+" food and has "+this.eyes+" no. of eyes and "+this.legs+" no. of legs ans "+this.ears+" no. of ears");
    }

    Dog(){
        System.out.println("I am Dog Constructor");
    }
}


public class SimpleInheritance{
    public static void main(String args[]){

        Dog d1=new Dog();
        d1.foodType("Meat", 4);

    }
}