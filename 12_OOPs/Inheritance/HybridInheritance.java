class Animals{
    int eyes=2;
    String food;

    Animals(){
        System.out.println("You are creating an animal");
    }

    public void info(){
        System.out.println("Its an animal");
    }
}

// class Herbivore{
//     String food="Plannts";
//     Herbivore(){
//         System.out.printl("You are creating a herbivore");
//     }
// }

class Cows extends Animals{
    int legs=4;
    Cows(){
        System.out.println("You are creating a cow");
    }

    public void info(){
        System.out.println("Its a cow who has "+this.legs+" legs");
    }

}

class Calf extends Cows{
    Calf(){
        System.out.println("You are creating a calf of cow");
    }
    public void info(){
        System.out.println("Its a calf who has "+this.legs+" legs");
    }

}

class Chicken extends Animals{
    int legs=2;
    Chicken(){
        System.out.println("You are creating a chicken");
    }

    public void info(){
        System.out.println("Its a chicken who has "+this.legs+" legs");
    }
}



public class HybridInheritance {
        public static void main(String args[]){
            Chicken chick=new Chicken();
            chick.info();

            Calf c1=new Calf();
            c1.info();
        }
}
