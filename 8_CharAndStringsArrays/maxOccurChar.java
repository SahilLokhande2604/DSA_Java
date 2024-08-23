import java.util.Scanner;

public class maxOccurChar {

    public static void maxOccurance(String s){
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
            count[s.charAt(i) - 'a']++;
            }
            else{
                count[s.charAt(i) - 'A']++;
            }
        }
        int maxCount=count[0];
        int index=0;
        for(int i=1;i<count.length;i++){
            if(count[i]>maxCount){
                maxCount=count[i];
                index=i;
            }
        }

        System.out.println("The max. occuring character is "+(char)('a'+index)+ " with count="+maxCount);
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
        System.out.println("Enter the string");
        String s = sc.next();
        System.out.println("String is " + s);
        maxOccurance(s);

    }
}
