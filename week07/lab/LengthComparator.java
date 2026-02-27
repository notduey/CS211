package week07.lab;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() != s2.length()) { // if strings aren't same length
            return s1.length() - s2.length(); // return difference
            // negative difference means shorter string comes first, and vice versa
        }
        // strings are same length
        return s1.compareTo(s2); // compares strings lexicographically
    }
}
