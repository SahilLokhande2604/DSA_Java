import java.util.Scanner;

public class squareRoot {
    public static long findSquareRootUsingBinarySearch(int n){
        long start=0;
        long end=n;
        long mid=start+((end-start)/2);
        long ans=-1;
        while(start<=end){
            long square=mid*mid;
            if(square==n){
                return mid;
            }
            else if(n<square){
                end=mid-1;
            }
            else{
                ans=mid;
                start=mid+1;
            }
            mid=start+((end-start)/2);
        }
        return ans;
    }

    public static double SquareRootWithDecimals(float ans,int n){
        double temp=ans;
        double factor=1;
        for(int i=0;i<3;i++){
            factor=factor/10;
            for(double j=temp;(j*j)<n;j=j+factor){
                temp=j;
            }
        }
        return temp;
    }


    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int n;
            System.out.println("Enter the number to get its square root");
            n=sc.nextInt();
            long ans=findSquareRootUsingBinarySearch(n);
            System.out.println("The square root of "+n+" is "+ans);
            double preciseAns=SquareRootWithDecimals(ans,n);
            System.out.println("The square root of "+n+" is "+preciseAns);
        }
}
