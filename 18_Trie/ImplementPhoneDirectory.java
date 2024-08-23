import java.util.*;

public class ImplementPhoneDirectory {

    class TrieNode{
        char ch;
        TrieNode[] children;
        boolean isTerminal;

        TrieNode(char ch){
            this.ch=ch;
            this.isTerminal=false;
            this.children=new TrieNode[26];
        }
    }

    private void insert(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminal=true;
            return;
        }

        TrieNode child;

        int index=word.charAt(0) - 'a';

        if(root.children[index]!=null){
            child=root.children[index];
        }
        else{
            child=new TrieNode(word.charAt(0));
            root.children[index]=child;
        }

        insert(child,word.substring(1));
    }

    private void printSuggestion(TrieNode root, List<String>temp, StringBuilder prefix){
        if(root.isTerminal==true){
            temp.add(prefix.toString());
        }

        for(char ch='a' ;ch<='z' ;ch++){
            int index=ch-'a';
            TrieNode child=root.children[index];
            if(child!=null){
                prefix.append(ch);
                printSuggestion(child, temp, prefix);
                prefix.deleteCharAt(prefix.length()-1);
            }
        }
    }

    private List<List<String>> getSuggestion(TrieNode root, String str){
        List<List<String>>output=new ArrayList<>();
        TrieNode prev=root;
        StringBuilder prefix=new StringBuilder();

        for(int i=0;i<str.length();i++){
            char lastChar=str.charAt(i);

            prefix.append(lastChar);

            int index=lastChar - 'a';

            TrieNode curr= prev.children[index];

            if(curr==null){
                break;
            }
            List<String>temp=new ArrayList<>();

            printSuggestion(curr, temp, prefix);
            output.add(new ArrayList<>(temp));
            temp.clear();

            prev=curr;
        }

        return output;
    }
    

    public List<List<String>> phoneDirectory(String[] arr, String key){
        TrieNode root=new TrieNode('\0');
        for(int i=0;i<arr.length;i++){
            insert(root, arr[i]);
        }

        return getSuggestion(root, key);
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        ImplementPhoneDirectory ipd=new ImplementPhoneDirectory();

        String[] arr={"coding", "code" , "codeforce", "codingninjas" , "coder"};

        System.out.println("Enter the word to search in phone directory");
        String key=sc.nextLine();

        System.out.println("The search result for each char of word is ");
        List<List<String>>ans=ipd.phoneDirectory(arr,key);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}
