package week01.lab;

import java.util.HashMap;

public class ReverseMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(42, "Marty"); // key, value
        map.put(81, "Sue");
        map.put(17, "Ed");
        map.put(31, "Dave");
        map.put(56, "Ed");
        map.put(3, "Marty");
        map.put(29, "Ed");
        
        System.out.println(reverse(map));
    }

    public static HashMap<String, Integer> reverse(HashMap<Integer, String> map) {
        HashMap<String, Integer> reverseMap = new HashMap<>(); // initialize the reverse map
        for (Integer key : map.keySet()) { // for each key in the map
            String value = map.get(key); // initialize "value" with the value of the key
            reverseMap.put(value, key); // put the value as key and the key as value
        }
        return reverseMap;
    }
}
