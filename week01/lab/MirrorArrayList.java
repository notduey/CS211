package week01.lab;
import java.util.*;

public class MirrorArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
            "a", "b", "c"));
        mirror(list);
        System.out.println(list);
    }

    public static void mirror(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) { // i equal to last index and decrement
            list.add(list.get(i)); // appends the element at index i (last index)
        }
    }
}
