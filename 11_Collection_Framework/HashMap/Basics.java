import java.util.*;
public class Basics{
    public static void main(String args[]){
        HashMap<Integer,Integer>map=new HashMap<>();
        // Adding key value pair in map 
        // i.e. map.put(key,value);
        map.put(1,2);
        map.put(2,4);
        map.put(8,1);
        map.put(5,10);
        // Printing the map
        System.out.println(map);
        // Map stores unique keys i.e. duplicates are not allowed 
        // thus by adding new key,value pair into map with existing key name then it will simply update its value with new value
        map.put(8,10); //here in this case initially value for key 8 was 1 but now it becomes 10
        System.out.println(map);
        map.put(11,10);
        System.out.println(map);



        // How to find whether the key is present in the map or not 
        // use map.containsKey(key) method
        if(map.containsKey(11)){
            System.out.println("The key 11 is present in map");
        }
        else{
            System.out.println("The key 11 is absent in map");
        }

        if(map.containsKey(111)){
            System.out.println("The key 111 is present in map");
        }
        else{
            System.out.println("The key 111 is absent in map");
        }


        // To get value of particular key
        // int value=map.get(11);
        // The above approach is correct but it will give error when the key does not exist in map 
        // i.e. for such case it returns null and null is not integer datatype so use below approach
        System.out.println("The value of key 11 is "+map.get(11));
        
        System.out.println("The value of key 111 is "+map.get(111));


        // loops in hashmap
        for(int key:map.keySet()){
            System.out.println(key+"-"+map.get(key));
        }

        // modify
        // when the key is already present then it simply updates its value
        map.put(11,1111);
        for(int key:map.keySet()){
            System.out.println(key+"-"+map.get(key)+", ");
        }


        // delete
        System.out.println("The deleted key is 11 with value "+ map.remove(11));



    }
}