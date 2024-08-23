import java.util.*;
public class pair{

    public static void display(int arr[][],int k){
        System.out.println("The pairs with sum equals to "+k+" are ");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Brut-force approach
    // time complexity O(n^2)
    public static void findPair(int arr[],int size,int k){
        int ans[][]=new int[size][2];
        int x=0,y=0;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
              
                if((arr[i]+arr[j])==k){
                    ans[x][y++]=arr[i];
                    ans[x][y]=arr[j];
                    x++;
                    y=0;
                }
            }
        }
        display(ans, k);

    }



    // using 2 pointers on sorted array
    // time complexity O(nlog(n))
    public static void findPairWithPointer(int arr[],int k){
        int ans[][]=new int[arr.length/2][2];
        int x=0,y=0;
        int left=0;
        int right=arr.length-1;
        Arrays.sort(arr);
        while(left<right){
            if((arr[left]+arr[right])==k){
                ans[x][y++]=arr[left];
                ans[x][y]=arr[right];
                x++;
                y=0;
                left++;
                right--;
            }
            else if((arr[left]+arr[right])<k){
                left++;
            }
            else{
                right++;
            }
        }
        display(ans, k);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the array");
        size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the elements to the array");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the value of k to find the pairs whose sum is equal to k");
        int k=sc.nextInt();
        findPair(arr,size,k);
        findPairWithPointer(arr, k);

    }
}