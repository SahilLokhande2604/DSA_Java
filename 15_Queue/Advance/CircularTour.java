import java.util.*;
public class CircularTour {
    int petrol;
    int distance;
    CircularTour(){

    }
    CircularTour(int petrol,int distance){
        this.petrol=petrol;
        this.distance=distance;
    }

    public int tour(CircularTour arr[]){
        int start=0;
        int deficiency=0;
        int balance=0;

        for(int i=0;i<arr.length;i++){
            balance=balance + arr[i].petrol - arr[i].distance;
            if(balance<0){
                deficiency=deficiency+balance;
                start=i+1;
                balance=0;
            }
        }
        if(deficiency+balance>=0){
            return start;
        }
        return -1;
    }

    public void display(CircularTour[] arr){
        System.out.println("Petrol  Distance");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].petrol+" "+arr[i].distance);
        }
        System.out.println();
    }


    public static void main(String[] args){
        CircularTour ct=new CircularTour();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total no. of petrol pumps");
        int no=sc.nextInt();
        System.out.println("Enter the quantity of petrol at each petrol pump and the distance of next pump from current pump");
        CircularTour[] arr = new CircularTour[no];
        for(int i=0;i<no;i++){
            System.out.println("Petrol:");
            int petrol=sc.nextInt();
            System.out.println("Distance:");
            int distance=sc.nextInt();
            CircularTour c=new CircularTour(petrol,distance);
            arr[i]=c;
        }
        ct.display(arr);
        int flag=ct.tour(arr);
        if(flag>=0){
            System.out.println("Tour is possible from point "+flag);
        }
        else{
            System.err.println("Tour is not possible");
        }





    }
}
