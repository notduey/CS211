package week02.lab;

public class RecursionReverse {
    public static void main(String[] args) {
        System.out.println(isReverse("CSE143", "341esc"));
    }

    public static boolean isReverse(String s1, String s2) {
        if (s1.length() !=  s2.length()) { // if lengths don't match
            return false;
        }
        if (s1.length() <= 1) { // empty or single character
            return true;
        }

        char first = Character.toLowerCase(s1.charAt(0)); // first character of s1 lowercased
        char last = Character.toLowerCase(s2.charAt(s2.length() - 1)); // last character of s2 lowercased
        if (first != last) { // if outer character don't match
            return false;
        }

        return isReverse( // recursive call
            s1.substring(1), // remove first character of s1
            s2.substring(0, s2.length() - 1) // remove last character of s2
        );
    }
}

// trace for isReverse("CSE143", "341esc"):

// isReverse("CSE143", "341esc") - calls isReverse("SE143", "341es")
// -> isReverse("SE143", "341es") - calls isReverse("E143", "341e")
// --> isReverse("E143", "341e") - calls isReverse("143", "341")
// ---> isReverse("143", "341") - calls isReverse("43", "34")
// ----> isReverse("43", "34") - calls isReverse("3", "3")
// ----->is Reverse("3", "3") - base case, return true