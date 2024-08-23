import java.util.*;

public class FirstNonRepeatingCharacterInStream {

    public String FirstNonRepeating(String s){
        if(s.length()==0){
            return "";
        }
        String ans="";
        Queue<Character>queue=new LinkedList<>();
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            queue.add(s.charAt(i));
            if(!queue.isEmpty() && count[queue.peek()-'a']==1){
                ans=ans+queue.peek();
            }
            else if(count[queue.peek()-'a']>1){
                while(!queue.isEmpty() && count[queue.peek()-'a']>1){
                    queue.poll();
                }
                if(queue.isEmpty()){
                    ans=ans+"#";
                }
                else{
                    ans=ans+queue.peek();
                }
            }   
        }
        return ans;
    }

    public void display(String s){
        for(int i=0;i<s.length();i++){
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        FirstNonRepeatingCharacterInStream string = new FirstNonRepeatingCharacterInStream();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String s=sc.nextLine();
        string.display(s);
        System.out.println("First Non-repeating characters in stream are as follow");
        string.display(string.FirstNonRepeating(s));
       


    }
}
