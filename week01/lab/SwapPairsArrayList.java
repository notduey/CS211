package week01.lab;
import java.util.*;

public class SwapPairsArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
            "four", "score", "and", "seven", "years", "ago"));
        swapPairs(list);
        System.out.println(list);
    }

    public static void swapPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size() -1; i += 2) { // increase i by 2
            String temp  = list.get(i);
            list.set(i, list.get(i + 1)); // list.set(index, value)
            list.set(i + 1, temp);
        }
    }
}
