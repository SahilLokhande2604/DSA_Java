import java.util.*;
public class Intro{
    class TrieNode{
        char ch;
        TrieNode[] children=new TrieNode[26];
        boolean isTerminal;

        TrieNode(char ch){
            this.ch=ch;
            this.isTerminal=false;
        }
    }

    class Trie{

        public void insert(TrieNode root, String word){
            // base case if string becomes empty then return ans mark the last node as terminal node
            if(word.length()==0){
                root.isTerminal=true;
                return;
            }

            TrieNode child;
            // get the index of current character
            int index=word.charAt(0) - 'a';

            // if current character is present then it will be child TrieNode
            if(root.children[index]!=null){
                child=root.children[index];
            }
            // if character is absent insert it into trie and make it child
            else{
                child=new TrieNode(word.charAt(0));
                root.children[index]=child;
            }
            // recursively check/build trie for rest of word
            insert(child,word.substring(1));
        }


        public boolean search(TrieNode root, String word){
            if(word.length()==0){
                return root.isTerminal;
            }

            int index=word.charAt(0) - 'a';
            TrieNode child;
            if(root.children[index]!=null){
                child=root.children[index];
            }
            else{
                return false;
            }
            return search(child,word.substring(1));
        }

        public void delete(TrieNode root, String word){
            if(word.length()==0){
                root.isTerminal=false;
                return;
            }

            int index=word.charAt(0) - 'a';
            TrieNode child;
            if(root.children[index]!=null){
                child=root.children[index];
            }
            else{
                System.out.println("Word does not exist in Trie");
                return;
            }
            delete(child,word.substring(1));
        }


    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        Intro it=new Intro();

        Trie trie=it.new Trie();
        TrieNode root=it.new TrieNode('\0');
        System.out.println("Enter the word into trie");
        String word=sc.nextLine();
        trie.insert(root, word);

        System.out.println("Enter the word into trie");
        word=sc.nextLine();
        trie.insert(root, word);

        System.out.println("Enter the word into trie");
        word=sc.nextLine();
        trie.insert(root, word);

        System.out.println("Enter the word to search in Trie");
        String key=sc.nextLine();
        System.out.println(trie.search(root, key));

        System.out.println("Enter the word into trie");
        word=sc.nextLine();
        trie.insert(root, word);

        System.out.println("Enter the word to delete from trie");
        word=sc.nextLine();
        trie.delete(root, word);

        System.out.println("Enter the word to search in Trie");
        key=sc.nextLine();
        System.out.println(trie.search(root, key));



    }
}