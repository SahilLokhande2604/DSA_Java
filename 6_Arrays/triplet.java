import java.util.Arrays;
import java.util.Scanner;

public class triplet {

    public static void displaytriplet(int arr[][],int sum){
        boolean flag=true;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<3;j++){
                if((arr[i][j]==0) && (arr[i][j+1]==0) && (arr[i][j+2]==0)){
                    flag=false;
                    break;
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
            if(!flag){
                break;
            }
        }
        System.out.println();
    }


    // brut force approach
    // time complexity O(n^3)
    public static void findTriplet(int arr[],int sum){
        int ans[][]=new int[arr.length][3];
        int x=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if((arr[i]+arr[j]+arr[k])==sum){
                        ans[x][0]=arr[i];
                        ans[x][1]=arr[j];
                        ans[x++][2]=arr[k];
                    }
                }
            }
        }
        displaytriplet(ans,sum);
    }


    // 2 pointer approach with sorted array
    // time complexity O(n^2)
    public static void findTriplet2(int arr[],int sum){
        int ans[][]=new int[arr.length][3];
        int x=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int left=i+1,right=arr.length-1;
            while(left<right){
                int total=arr[i]+arr[left]+arr[right];
                if(total<sum){
                    left++;
                }
                else if(total>sum){
                    right--;
                }
                else{
                    ans[x][0]=arr[i];
                    ans[x][1]=arr[left];
                    ans[x++][2]=arr[right];
                    left++;
                    right--;
                }
            }

        }
        displaytriplet(ans, sum);
       
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
        System.out.println("enter the value of k to find the triplets whose sum is equal to k");
        int k=sc.nextInt();
        findTriplet(arr, k);
        findTriplet2(arr, k);
    }
}
