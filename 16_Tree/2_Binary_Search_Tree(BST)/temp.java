import java.util.*;

public class temp {

    public String build(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (!stack.isEmpty() && stack.peek() != 'c') {
                if (stack.peek() + 1 == s.charAt(i)) {
                    stack.push(s.charAt(i));
                } else {
                    while (stack.peek() != 'c' && stack.peek() != s.charAt(i)) {
                        stack.push((char) (stack.peek() + 1));
                    }
                }
            } 
            else if (!stack.isEmpty() && stack.peek() + 1 == s.charAt(i)) {
                stack.push(s.charAt(i));
            } 
            else {
                if (s.charAt(i) == 'a') {
                    stack.push('a');
                } else if (s.charAt(i) == 'b') {
                    stack.push('a');
                    stack.push('b');
                } else {
                    stack.push('a');
                    stack.push('b');
                    stack.push('c');
                }
            }

        }
        if (stack.peek() != 'c') {
            while (stack.peek() != 'c') {
                stack.push((char) (stack.peek() + 1));
            }
        }
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    public void display(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        temp t = new temp();
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the string");
            String s = sc.next();
            t.display(s);
            System.out.println("The consecutive sequence of 'abc' after updating string s is ");
            String ans = t.build(s);
            t.display(ans);

            System.out.println("Enter -1 to stop\nto continue enter 1");
            int key = sc.nextInt();
            if (key == -1) {
                flag = false;
            }
        }

    }
}
