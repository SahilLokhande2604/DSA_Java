import java.util.*;

public class intersection {
    public static void display(int arr[], int size) {

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();

    }

    public static int[] intersect(int arr1[], int arr2[], int size1, int size2) {
        int ans[] = new int[10];
        int i = 0, j = 0;
        int x = 0;
        while (i < size1 && j < size2) {
            // if elements are present i.e. intersecting elements
            if (arr1[i] == arr2[j]) {
                ans[x++] = arr1[i];
                i++;
                j++;
            }
            // as arrays are sorted so if 2nd array current index element is > 1st array
            // current index which means that in 2nd array all the further elements are >
            // current element in 1st array so we need to update the index of 1st array and
            // needs to keep index of 2nd array as it is
            else if (arr2[j] > arr1[i]) {
                i++;
            }
             // as arrays are sorted so if 1nd array current index element is > 2st array
            // current index which means that in 1nd array all the further elements are >
            // current element in 2st array so we need to update the index of 2st array and
            // needs to keep index of 1nd array as it is
            else{
                j++;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size1 = sc.nextInt();
        System.out.println("Enter the elements of an array in sorted manner");
        int arr1[] = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }
        display(arr1, size1);

        System.out.println("Enter the size of an array");
        int size2 = sc.nextInt();
        System.out.println("Enter the elements of an array in sorted manner");
        int arr2[] = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println("Array is ");
        display(arr2, size2);

        System.out.println("The intersecting elements are \n");
        int ans[] = intersect(arr1, arr2, size1, size2);
        display(ans, ans.length);

    }

}
