import java.util.*;
public class quickSort {

    public static void quick_Sort(int arr[],int start,int end){
        if(start>=end){
            return;
        }

        int pivot=partiationPivotAsStart(arr,start,end);
        quick_Sort(arr, start, pivot-1);
        // display(arr, start, end);
        quick_Sort(arr, pivot+1, end);
        // display(arr, start, end);
    }

    public static int partiationPivotAsStart(int arr[],int start,int end){
        int pivot=arr[start]; 
        int minCount=0;
        for(int i=start+1;i<=end;i++){
            if(arr[i]<=pivot){
                minCount++;
            }
        }
        int pivotIndex=start+minCount;
        int temp=arr[start];
        arr[start]=arr[pivotIndex];
        arr[pivotIndex]=temp;

        int i=start,j=end;
        while(i<pivotIndex && j>pivotIndex){
            
            while(arr[i]<=arr[pivotIndex]){
                i++;
            }

            while(arr[j]>arr[pivotIndex]){
                j--;
            }

            if(i<pivotIndex && j>pivotIndex){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        


        return pivotIndex;
    }

    public static void quick_Sort2(int arr[],int start,int end){
        if(start>=end){
            return;
        }

        int pivot=partiationPivotAsEnd(arr,start,end);
        quick_Sort(arr, start, pivot-1);
        quick_Sort(arr, pivot+1, end);
    }

    public static int partiationPivotAsEnd(int arr[],int start,int end){
        int pivot=arr[end];
        int minCount=0;

        for(int i=start;i<end;i++){
            if(arr[i]<=pivot){
                minCount++;
            }
        }

        int pivotIndex=start+minCount;
        int temp=arr[end];
        arr[end]=arr[pivotIndex];
        arr[pivotIndex]=temp;

        int i=start,j=end;
        while(i<pivotIndex && j>pivotIndex){
            
            while(arr[i]<=arr[pivotIndex]){
                i++;
            }

            while(arr[j]>arr[pivotIndex]){
                j--;
            }

            if(i<pivotIndex && j>pivotIndex){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }

        return pivotIndex;
    }

    public static void quick_Sort3(int arr[],int start,int end){
        if(start>=end){
            return;
        }

        int pivot=partiationPivotAsMid(arr,start,end);
        quick_Sort(arr, start, pivot-1);
        quick_Sort(arr, pivot+1, end);
    }


    public static int partiationPivotAsMid(int arr[],int start,int end){
        int mid=start+((end-start)/2);
        int pivot=arr[mid];
        int minCount=0;
        for(int i=start;i<=end;i++){
            if(arr[i]<=pivot && i!=mid){
                minCount++;
            }
        }

        int pivotIndex=start+minCount;
        int temp=arr[mid];
        arr[mid]=arr[pivotIndex];
        arr[pivotIndex]=temp;

        int i=start,j=end;
        while(i<pivotIndex && j>pivotIndex){
            
            while(arr[i]<=arr[pivotIndex]){
                i++;
            }

            while(arr[j]>arr[pivotIndex]){
                j--;
            }

            if(i<pivotIndex && j>pivotIndex){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }

        return pivotIndex;
    }


    public static void display(int arr[],int start,int end){
        for(int i=0;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
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
        System.out.println("Quicksort with pivot as start index");
        display(arr,0,arr.length-1);
        long start=System.currentTimeMillis();
        quick_Sort(arr, 0,arr.length-1);
        long end=System.currentTimeMillis();
        display(arr,0,arr.length-1);
        System.out.println("Time require for sorting is "+(end-start));



        System.out.println("Enter the array size");
        int size2=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr2[]=new int[size];
        for(int i=0;i<size2;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println("Quicksort with pivot as end index");
        display(arr2,0,arr2.length-1);
        start=System.currentTimeMillis();
        quick_Sort2(arr2, 0,arr2.length-1);
        end=System.currentTimeMillis();
        display(arr2,0,arr2.length-1);
        System.out.println("Time require for sorting is "+(end-start));




        System.out.println("Enter the array size");
        int size3=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int arr3[]=new int[size3];
        for(int i=0;i<size3;i++){
            arr3[i]=sc.nextInt();
        }
        System.out.println("Quicksort with pivot as mid index");
        display(arr3,0,arr3.length-1);
        start=System.currentTimeMillis();
        quick_Sort3(arr3, 0,arr3.length-1);
        end=System.currentTimeMillis();
        display(arr3,0,arr3.length-1);
        System.out.println("Time require for sorting is "+(end-start));



    }
}



// 4 12 3 1 16 20 19