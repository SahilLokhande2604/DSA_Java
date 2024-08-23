import java.util.*;
public class LongestCommonPrefix {
   

    class TrieNode{
        char ch;
        TrieNode[] children=new TrieNode[26];
        int childCount;
        boolean isTerminal;

        TrieNode(char ch){
            this.ch=ch;
            this.isTerminal=false;
            childCount=0;
        }
    }

    private void insert(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminal=true;
            return;
        }

        int index=word.charAt(0) - 'a';
        TrieNode child;

        if(root.children[index]!=null){
            child=root.children[index];
        }
        else{
            child=new TrieNode(word.charAt(0));
            root.childCount=root.childCount + 1;
            root.children[index]=child;
        }

        insert(child,word.substring(1));
    }

    private void findLCS(TrieNode root, String word, StringBuilder ans){
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int index=ch-'a';
            if(root.childCount>1 || root.children[index]==null){
                return;
            }
            ans=ans.append(ch);
            root=root.children[index];
        }

    }


    public String findLongestCommonPrefix(String[] arr){
        // Step 1: Create a trie
        TrieNode root=new TrieNode('\0');
        for(int i=0;i<arr.length;i++){
            insert(root, arr[i]);
        }

        // Step 2: traverse the trie till either word gets finish or any node gets more than 1 children
        StringBuilder ans=new StringBuilder();
        findLCS(root, arr[0], ans);

        return ans.toString();

    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array of strings");
        int size=sc.nextInt();
        sc.nextLine(); 
        String[] arr=new String[size];
        System.out.println("Enter strings into arr");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextLine();
           
        }

        LongestCommonPrefix lcp=new LongestCommonPrefix();

        String ans=lcp.findLongestCommonPrefix(arr);
        System.out.println(ans);
    }
}
