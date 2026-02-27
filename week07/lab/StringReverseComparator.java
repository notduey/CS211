package week07.lab;

import java.util.Comparator;

public class StringReverseComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // i and j start at last character of each string
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        // compare characters from the right, stop when we reach first character
        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) != s2.charAt(j)) { // if characters are different
                return s1.charAt(i) - s2.charAt(j); // return difference
                // subtracting chars works because they are ASCII
                // negative difference means s1 comes before s2, and vice versa
            }
            // characters are equal, decrement i and j (move left one character)
            i--;
            j--;
        }

        return s1.length() - s2.length(); // if loop ends, shorter string comes first
    }
}
