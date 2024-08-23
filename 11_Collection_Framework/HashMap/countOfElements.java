import java.util.*;
public class countOfElements {
    public static void countOccurance(int[] arr){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        display(map);
    }

    public static void display(HashMap<Integer,Integer>map){
        for(int key:map.keySet()){
            System.out.println("The element "+key+" occurs "+map.get(key)+" times");
        }
    }

    public static void main(String []args){
        int[] arr={1,2,3,4,1,5,6,2,6,8,2,8,2,9,0,6,2,8,5,2,1};
        countOccurance(arr);
        
    }
    
}
