class Animal{
    int eyes=2;
    int legs;
    String name;
    String food;

    Animal(){
        System.out.println("You are about to creat an animal");
    }

    public void info(){
        System.out.println("Hello, I am "+this.name+" and i have "+this.legs+" legs and i eats "+this.food);
    }

}

class Cow extends Animal{
    Cow(String name,String food,int legs){
        this.legs=legs;
        this.name=name;
        this.food=food;
    }

    // public void info(){
       
    // }
}

class Human extends Animal{
    Human(){
        System.out.println("You are creating a human");
    }

    public void info(String name,String food,int legs){
        this.name=name;
        this.food=food;
        this.legs=legs;

        System.out.println("Hi, I am "+this.name+" and i have "+this.legs+" legs and i eats "+this.food);
    }
}

// Hierarchical Inheritance as both the Cow and Human classes has same Base class
public class HierarchicalInheritance {
    public static void main(String args[]){
        Cow c1=new Cow("Cow","Grass",4);
        c1.info();

        Human h1=new Human();
        h1.info();
        h1.info("Human", "Meat or Plants", 2);
        h1.info();
    }
}
