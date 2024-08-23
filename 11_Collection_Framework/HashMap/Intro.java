import java.util.*;
public class Intro{
    public static void main(String[] a){
        Map<String,Integer>map=new HashMap<>();

        map.put("Sahil", 2);
        map.put("Swapnil", 1);
        map.put("Bhairav", 3);
        map.put("Yash", 4);

        System.out.println(map);

        // printing all keys 
        System.out.println(map.keySet());

        // for loop in map using keySet()

        for(String key: map.keySet()){
            System.out.println(key +" "+ map.get(key));
        }
    }
}