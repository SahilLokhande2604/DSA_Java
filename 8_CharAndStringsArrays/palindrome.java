import java.util.Scanner;

public class palindrome {

    public static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch - 'A' + 'a');
        }
        return ch;
    }

    public static boolean necessary(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }

    public static String removeUnnecessaryCharacters(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (necessary(s.charAt(i))) {
                temp = temp + s.charAt(i);
            }
        }
        return temp;
    }

    public static boolean isPalindrome(String s) {
        String temp = removeUnnecessaryCharacters(s);
        StringBuilder str = new StringBuilder(temp);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                char change = (char) (str.charAt(i) - 'A' + 'a');
                str.setCharAt(i, change);
            }
        }
        System.out.println("String=" + str);
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void display(char ch[]) {
        System.out.print("Your name is ");
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Enter the string to check whether it is palindrome or not by neglecting special characters and while spaces");
        String s = sc.next();
        System.out.println("String=" + s);
        boolean flag = isPalindrome(s);
        System.out.println("The string is palindrome. " + flag);
    }
}
// Apple_is_good5&DoOgSiELPpa