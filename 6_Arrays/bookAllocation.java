// Given an array 'arr' of integer numbers. where 'arr[i]' represents the number of pages in the 'i- th' book. There are 'm' number of students and the task is to allocate all the books to their students. Allocate books in such a way that:
// 1. Each student gets at least one book.
// 2. Each book should be allocated to a student.
// 3. Book allocation should be in a contiguous manner.
// You have to allocate the book to 'm' students such that the maximum number of pages assigned to a student is minimum.
// example arr=[10,20,30,40]
// possible combination to allocate books in 2 students
// stud1=10, stude2=20,30,40  -> max. pages=90
// stud1=10,20, stude2=30,40  -> max. pages=70
// stud1=10,20,30 stude2=40   -> max. pages=60
// Given maximun no. of pages assign to a student should minimum
// i.e. we have to choose a combination where the max. pages value is minimum from remaining combinations 
// so the ans will be 60

import java.util.Scanner;

public class bookAllocation {

    public static boolean isPossibleSolution(int arr[],int noOfBooks,int noOfStudents,int mid){
        int sum=0;
        int countOfStudent=1;
        for(int i=0;i<noOfBooks;i++){
            if((sum+arr[i])<=mid){
                sum=sum+arr[i];
            }
            else{
                countOfStudent++;
                if(countOfStudent>noOfStudents || arr[i]>mid){
                    return false;
                }
                sum=arr[i];
            }
        }
        return true;
    }

    public static int allocateBooks(int arr[], int noOfBooks, int noOfStudents) {
        int start = 0;
        int sum = 0;
        for (int i = 0; i < noOfBooks; i++) {
            sum = sum + arr[i];
        }
        int end = sum;
        int mid = start + ((end - start) / 2);
        int ans=-1;
        while (start <= end) {
            if (isPossibleSolution(arr, noOfBooks, noOfStudents, mid)) {
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            mid = start + ((end - start) / 2);
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int noOfBooks;
        System.out.println("Enter total no. of books");
        noOfBooks = sc.nextInt();
        int arr[] = new int[noOfBooks];
        System.out.println("Enter the page size of each book");
        for (int i = 0; i < noOfBooks; i++) {
            arr[i] = sc.nextInt();
        }
        int noOfStudents;
        System.out.println("Enter the no. of students to allocate books");
        noOfStudents = sc.nextInt();

        int ans = allocateBooks(arr, noOfBooks, noOfStudents);
        System.out.println("The ans is "+ans);

    }
}
