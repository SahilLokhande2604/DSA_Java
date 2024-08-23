import java.util.Scanner;

public class sumOfArray {

    public static int sum(int arr[],int size,int index){
        if(size==0){
            return 0;
        }
        if(index==size-1){
            return arr[index];
        }
        int ans=arr[index];
        ans=ans+sum(arr,size,++index);
        
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size");
        int size=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int ans=sum(arr, size, 0);
        System.out.println("Sum is "+ans);

    }
}
