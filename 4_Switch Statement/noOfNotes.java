
// import java.util.*;
// public class noOfNotes {
//     public static void main(String args[]){
//         int num;
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the amount ");
//         num=sc.nextInt();
//         sc.close();
//         int note100=0,note50=0,note20=0,note10=0,note1=0;
//         switch(num/100){
//             case 0:
//               break;
//             default:
//               note100=num/100;
//               num=num%100;
//         }
//         switch(num/50){
//             case 0:
//              break;
//             default:
//              note50=num/50;
//              num=num%50;
//         }
//         switch(num/20){
//             case 0:
//              break;
//             default:
//              note20=num/20;
//              num=num%20;
//         }
//         switch(num/10){
//             case 0:
//              break;
//             default:
//              note10=num/10;
//              num=num%10;
//         }
//         switch(num/1){
//             case 0:
//              break;
//             default:
//              note1=num/1;
//              num=num%1;
//         }
//         System.out.println("Total 100 rs notes requires are "+note100);
//         System.out.println("Total 50 rs notes requires are "+note50);
//         System.out.println("Total 20 rs notes requires are "+note20);
//         System.out.println("Total 10 rs notes requires are "+note10);
//         System.out.println("Total 1 rs notes requires are "+note1);
        
       
        

            
        
//     } 
// }

import java.util.*;

public class noOfNotes{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount");
        int n=sc.nextInt();
        sc.close();
        switch(1){

            case 1:
            int noOfNotes=(n/100);
            n=n-(noOfNotes*100);
            System.out.println("100 Rs notes="+noOfNotes);

            case 2:
            noOfNotes=(n/50);
            n=n-(noOfNotes*50);
            System.out.println("50 Rs notes="+noOfNotes);

            case 3:
            noOfNotes=(n/20);
            n=n-(noOfNotes*20);
            System.out.println("20 Rs notes="+noOfNotes);

            case 4:
            noOfNotes=(n/10);
            n=n-(noOfNotes*10);
            System.out.println("10 Rs notes="+noOfNotes);

            case 5:
            noOfNotes=(n/5);
            n=n-(noOfNotes*5);
            System.out.println("5 Rs notes/coins="+noOfNotes);

            case 6:
            noOfNotes=(n/2);
            n=n-(noOfNotes*2);
            System.out.println("2 Rs coins="+noOfNotes);

            case 7:
            noOfNotes=(n/1);
            n=n-(noOfNotes*1);
            System.out.println("1 Rs coins="+noOfNotes);

        }

    }
}
