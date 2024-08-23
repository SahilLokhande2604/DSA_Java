import java.util.*;

public class starPatternsAll {
    // *
    // * *
    // * * *
    // if n=3;
    public static void pattern1(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println("------------------------------------------");

    }

    // 1
    // 2 2
    // 3 3 3
    // 4 4 4 4
    // if n=4;
    public static void pattern2(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print(i + " ");
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println("------------------------------------------");

    }

    // 4
    // 3 3
    // 2 2 2
    // 1 1 1 1
    // if n=4;
    public static void pattern3(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print((n - i + 1) + " ");
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println("------------------------------------------");

    }

    // 1
    // 2 3
    // 4 5 6
    // 7 8 9 10
    // if n=4;
    public static void pattern4(int n) {
        int count = 1;
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print(count + " ");
                j++;
                count++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // 1
    // 2 3
    // 3 4 5
    // 4 5 6 7
    // for n=4;
    public static void pattern5(int n) {
        int i = 1;
        while (i <= n) {
            int j = 0;
            while (j < i) {
                System.out.print((i + j) + " ");
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println("------------------------------------------");
    }

    // for n=4;
    // 1
    // 2 1
    // 3 2 1
    // 4 3 2 1
    public static void pattern6(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print((i - j + 1) + " ");
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");

    }

    // A A A
    // B B B
    // C C C
    public static void pattern7(int n) {
        int i = 1;
        char ch = 'A';
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(ch + " ");
                j++;
            }
            i++;
            ch++;
            System.out.println();
        }
        System.out.println("------------------------------------------");

    }

    // A B C
    // A B C
    // A B C
    public static void pattern8(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            char ch = 'A';
            while (j <= n) {
                System.out.print(ch + " ");
                j++;
                ch++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");

    }

    // A B C
    // D E F
    // G H I
    public static void pattern9(int n) {
        int i = 1;
        char ch = 'A';
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(ch + " ");
                ch++;
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");

    }

    // A B C
    // B C D
    // C D E
    public static void pattern10(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                char ch = (char) ('A' + i + j - 2); // similar to //1 2 3
                                                    // 2 3 4
                                                    // 3 4 5
                                                    // thus for 1,2,3 formula was (i+j-1)
                                                    // but here we want 'A' included
                                                    // thus add 'A' on LHS and RHS of above formula
                                                    // i.e. 'A'+(i+j-1)=1+'A';
                                                    // bring 1 to LHS
                                                    // 'A'+(i+j-1-1)='A';
                                                    // 'A'+(i+j-2) is the require formula
                System.out.print(ch + " ");
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // A
    // B B
    // C C C
    public static void pattern11(int n) {
        int i = 1;
        char ch = 'A';
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print(ch + " ");
                j++;
            }
            i++;
            ch++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // A
    // B C
    // D E F
    // G H I J
    public static void pattern12(int n) {
        int i = 1;
        char ch = 'A';
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print(ch + " ");
                j++;
                ch++;
            }
            i++;
            System.out.println();

        }
        System.out.println("------------------------------------------");
    }

    // A
    // B C
    // C D E
    // D E F G
    public static void pattern13(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                char ch = (char) ('A' + i + j - 2);
                System.out.print(ch + " ");
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // D
    // C D
    // B C D
    // A B C D
    public static void pattern14(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                char ch = (char) ('A' + n - (i - j) - 1);
                System.out.print(ch + " ");
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // *
    // * *
    // * * *
    // for n=3;
    public static void pattern15(int n) {
        int i = 1;
        while (i <= n) {
            int space = n - i;
            while (space >= 1) {
                System.out.print("  ");
                space--;
            }
            int j = 1;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
        int a = 1;
        while (a <= n) {
            int b = 1;
            while (b <= n) {
                if (b <= (n - a)) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
                b++;
            }
            a++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // * * * *
    // * * *
    // * *
    // *
    // n=4;
    public static void pattern16(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                if (j <= (n - i + 1)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // * * * *
    // * * *
    // * *
    // *
    public static void pattern17(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                if (j >= i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    // 1 1 1 1
    // 2 2 2
    // 3 3
    // 4
    // n=4;
    public static void pattern18(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                if (j <= (n + 1 - i)) {
                    System.out.print(i + " ");

                } else {
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();

        }
        System.out.println("------------------------------------------");
    }

    // 1 1 1 1
    // 2 2 2
    // 3 3
    // 4
    public static void pattern19(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                if (j >= i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");

    }
    //    1
    //   22
    //  333
    // 4444
    public static void pattern20(int n){
        int i=1;
        while(i<=n){
            int j=1;
            while(j<=n){
                if(j>=(n-i+1)){
                    System.out.print(i+" ");
                }
                else{
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }
    //1 2 3 4
    //  2 3 4
    //    3 4
    //      4
    public static void pattern21(int n){
        int i=1;
        while(i<=n){
            int j=1;
            while(j<=n){
                if(j>=i){
                    System.out.print(j+" ");
                }
                else{
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
         System.out.println("------------------------------------------");
    }
    //         1
    //      2  3
    //   4  5  6
    //7  8  9  10
    public static void pattern22(int n){
        int i=1;
        int count=1;
        while(i<=n){
            int j=1;
            while(j<=n){
                if(j>=(n-i+1)){
                    System.out.print(count+" ");
                    count++;
                }
                else{
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
         System.out.println("------------------------------------------");
    }
    //        1
    //      1 2 1
    //    1 2 3 2 1
    //  1 2 3 4 3 2 1
    public static void pattern23(int n){
        int i=1;
        while(i<=n){
            int space=n-i;
            while(space>0){                 //printing the space
                System.out.print("  ");
                space--;
            }
            int j=1;
            while(j<=i){                    //printing the middle pattern
                System.out.print(j+" ");
                j++;
            }
            int x=i-1;
            while(x>0){                     //printing the last pattern
                System.out.print(x+" ");
                x--;
            }
            i++;
            System.out.println();
        }
         System.out.println("------------------------------------------");
    }
    public static void pattern24(int n){
        int i=1;
        while(i<=n){
            int j=1;
            while(j<=(n-i+1)){
                System.out.print(j+" ");
                j++;
            }
            int star=i-1;
            while(star>0){
                System.out.print("* ");
                star--;
            }
            star=i-1;
            while(star>0){
                System.out.print("* ");
                star--;
            }
            int k=n-i+1;
            while(k>0){
                System.out.print(k+" ");
                k--;
            }
            i++;
            System.out.println();


        }
        System.out.println("------------------------------------------");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the total no. of rows");
        n = sc.nextInt();
        pattern1(n);
        pattern2(n);
        pattern3(n);
        pattern4(n);
        pattern5(n);
        pattern6(n);
        pattern7(n);
        pattern8(n);
        pattern9(n);
        pattern10(n);
        pattern11(n);
        pattern12(n);
        pattern13(n);
        pattern14(n);
        pattern15(n);
        pattern16(n);
        pattern17(n);
        pattern18(n);
        pattern19(n);
        pattern20(n);
        pattern21(n);
        pattern22(n);
        pattern23(n);
        pattern24(n);
       }
}
