import java.util.*;
public class decimalToBinary{
    public static void binary(int n){
        int k=n;
        int ans=0;
        int i=0;
        if(n<0){
           n=n*(-1);
           while(n!=0){

               int temp=n&1;
               ans=ans+(int)(Math.pow(10,i)*temp);
               i++;
               n=n>>1;
                
            }
            int sum=0;
            i=0;
            System.out.println("The binary ans"+ans);
            while(ans!=0){
                int temp=ans&1;
                if(temp==1){
                
                    
                    sum=sum+(int)(Math.pow(10,i)*temp);
                    System.out.println("The binary of sum after first 1 is is"+sum);
                    ans=ans>>1;
                    i++;
                    while(ans!=0){
                        temp=ans&1;
                        
                        if(temp==0){
                            sum=sum+(int)(Math.pow(10,i)*1);
                            System.out.println("The binary of sum0 is"+sum);
                        }
                        else{
                            sum=sum+(int)(Math.pow(10,i)*0);
                            System.out.println("The binary of sum1 is"+sum);
                        }
                        i++;
                        ans=ans>>1;
                        if(ans==0){
                            System.out.println("SAhil");
                            break;
                        }
                        
             
                    }
                    break;
                }
                sum=sum+(int)(Math.pow(10,i)*temp);
                System.out.println("The binary of sum out is"+sum);
                ans=ans>>1;
                i++;
            }
            ans=sum;
          
        }
        else{
             while(n!=0){
            int temp=n&1;
            ans=(int) ((Math.pow(10,i)*temp)+ans);
            n=n>>1;
            i++;
        }
        }
       
        System.out.println("The binary of "+k+" is "+ans);
    }
    public static void decimal(int n){
        double ans=0;
        int i=0;
        while(n!=0){
            if((n&1)==1){
                ans=ans+ Math.pow(2,i);
                System.out.println("i is "+i+" ans is "+ans);
            }
            i++;
            n=n/10;
        }
        System.out.println("The binary of "+n+" is "+ans);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
                int n;
        System.out.println("Enter the no. to get its binary");
        n=sc.nextInt();
        binary(n);
         System.out.println("Enter the no. to get its decimal");
        n=sc.nextInt();
        decimal(n);
    }
}