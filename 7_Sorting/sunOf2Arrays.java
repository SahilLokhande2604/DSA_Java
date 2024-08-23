import java.util.Scanner;

public class sunOf2Arrays {

    public static int[] sum(int arr1[],int n,int arr2[],int m){
        int size=m+1;
        if(n>m){
            size=n+1;
        }
        int ans[]=new int[size];
        int i=n-1,j=m-1,k=size-1;
        while(i>=0 && j>=0){
            ans[k]=ans[k]+arr1[i]+arr2[j];
            if(ans[k]>9){
                ans[k-1]=ans[k]/10;
                ans[k]=ans[k]%10;
            }
            i--;
            j--;
            k--;
        }
        while(i>=0){
            ans[k]=ans[k]+arr1[i];
            if(ans[k]>9){
                ans[k-1]=ans[k]/10;
                ans[k]=ans[k]%10;
            }
            i--;
            k--;
        }
        while(j>=0){
            ans[k]=ans[k]+arr2[j];
            if(ans[k]>9){
                ans[k-1]=ans[k]/10;
                ans[k]=ans[k]%10;
            }
            j--;
            k--;
        }
        return ans;
    }


    public static void display(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of 1st array");
        int n=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr1[]=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }

        System.out.println("Enter the size of 2nd array");
        int m=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr2[]=new int[m];
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println("The arrays are ");
        display(arr1, n);
        display(arr2, m);

        
        int ans[]=sum(arr1, n, arr2, m);
        display(ans, ans.length);

}
}
