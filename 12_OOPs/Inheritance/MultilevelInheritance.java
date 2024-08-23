class Animal{
    int eyes=2;
    int legs;
    String food;

    Animal(){
        System.out.println("The Animal constructor is call\n");
    }
}

class Dog extends Animal{

    String smell;
    int age;
    int height;
    String food="meat";



    public void info(){
        System.out.println("Dog has "+this.legs+" legs and eats "+this.food);
        System.out.println("Dog has "+this.eyes+" eyes\n");
    }

    Dog(int legs,String food){
        this.legs=legs;
        this.food=food;
        System.out.println("The Dog constructor is call\n");
    }

    Dog(){
        System.out.println("The Dog non-parametrized constructor is call\n");
    }
}

class BullDog extends Dog{

    BullDog(int height,int age,String smell){
        this.height=height;
        this.age=age;
        this.smell=smell;
    }
    
    public void quality(){
       
       System.out.println("Bull Dog is of "+this.height+" height and lives for "+this.age+" approx. years");
       System.out.println("its smelling ability is "+this.smell+" as compare to other dogs");
    }
}


public class MultilevelInheritance {
    public static void main(String args[]){

        Dog d1=new Dog();
        Dog d2=new Dog(4,"Meat");

        d1.info();
        d2.info();

        BullDog bd1=new BullDog(10, 18, "strong");
        bd1.info();  //method of its parent class
        System.out.println("BullDog has "+bd1.eyes+" eyes");  //data member of its parent's parent is use
        bd1.quality();
        

    }
}
