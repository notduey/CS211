/* ============================================================
 * CSE 143 — Sorting & Searching
 * Topic: Searching techniques, Comparators, and Sorting algorithms
 *
 * Big idea:
 * - Searching and sorting are fundamental operations
 * - Multiple algorithms exist with different tradeoffs
 * ============================================================
 */


/* ============================================================
 * SEARCHING
 * ============================================================
 */


/* ------------------------------------------------------------
 * SEQUENTIAL (LINEAR) SEARCH
 * ------------------------------------------------------------
 *
 * Idea:
 * - Examine each element from start to finish
 * - Stop when target is found or list ends
 *
 * Works on:
 * - Any list (sorted or unsorted)
 *
 * Runtime:
 * - Best case: O(1)
 * - Worst case: O(n)
 */

for (int i = 0; i < array.length; i++) {
    if (array[i] == target) {
        return i;
    }
}
return -1;


/* ------------------------------------------------------------
 * BINARY SEARCH
 * ------------------------------------------------------------
 *
 * Idea:
 * - Only works on SORTED data
 * - Repeatedly eliminate half the search space
 *
 * Strategy:
 * - Check middle element
 * - If target < middle → search left half
 * - If target > middle → search right half
 *
 * Runtime:
 * - O(log n)
 */

int low = 0;
int high = array.length - 1;

while (low <= high) {
    int mid = (low + high) / 2;

    if (array[mid] == target) {
        return mid;
    } else if (array[mid] < target) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}
return -1;


/* ============================================================
 * COMPARATORS
 * ============================================================
 *
 * Problem:
 * - Default ordering is not always what we want
 *
 * Example:
 * - String sorting is case-sensitive by default
 * - Uppercase letters come before lowercase
 */


/* ------------------------------------------------------------
 * Comparator Interface
 * ------------------------------------------------------------
 *
 * Comparator<Type> defines a custom ordering.
 *
 * compare(o1, o2) returns:
 * - negative → o1 comes before o2
 * - zero     → equivalent
 * - positive → o1 comes after o2
 */

public interface Comparator<Type> {
    int compare(Type o1, Type o2);
}


/* ------------------------------------------------------------
 * Case-Insensitive String Comparator
 * ------------------------------------------------------------
 */

public class CaseInsensitiveComparator
        implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareToIgnoreCase(s2);
    }
}


/* ------------------------------------------------------------
 * Using a Comparator with Arrays.sort
 * ------------------------------------------------------------
 */

String[] strings = {
    "Foxtrot", "alpha", "echo", "golf",
    "bravo", "hotel", "Charlie", "DELTA"
};

Arrays.sort(strings); // default ordering
Arrays.sort(strings, new CaseInsensitiveComparator());


/* ------------------------------------------------------------
 * Descending Order Comparator
 * ------------------------------------------------------------
 */

public class DescendingComparator
        implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s2.compareTo(s1); // reverse order
    }
}


/* ------------------------------------------------------------
 * Reverse-String Comparator
 * ------------------------------------------------------------
 */

public class StringReverseComparator
        implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        String r1 = new StringBuilder(s1).reverse().toString();
        String r2 = new StringBuilder(s2).reverse().toString();
        return r1.compareTo(r2);
    }
}


/* ============================================================
 * SWAPPING FUNCTION
 * ============================================================
 *
 * Used by most sorting algorithms
 */

private static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}


/* ============================================================
 * SORTING ALGORITHMS — OVERVIEW
 * ============================================================
 *
 * Considerations:
 * - Time complexity
 * - Space complexity
 * - Iterative vs Recursive
 */


/* ============================================================
 * BUBBLE SORT
 * ============================================================
 *
 * Idea:
 * - Repeatedly compare adjacent elements
 * - Swap if out of order
 * - Largest values "bubble" to the end
 *
 * Observations:
 * - After each pass, the largest unsorted element
 *   is placed at the end
 *
 * Runtime:
 * - Worst: O(n^2)
 * - Best (already sorted + flag): O(n)
 */

for (int i = 0; i < array.length - 1; i++) {
    for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
            swap(array, j, j + 1);
        }
    }
}


/* ============================================================
 * SELECTION SORT
 * ============================================================
 *
 * Idea:
 * - Find the minimum value in the unsorted portion
 * - Swap it into the correct position
 *
 * Observations:
 * - Makes fewer swaps than bubble sort
 * - Still compares every element
 *
 * Runtime:
 * - Always O(n^2)
 */

for (int i = 0; i < array.length - 1; i++) {
    int minIndex = i;

    for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
            minIndex = j;
        }
    }

    swap(array, i, minIndex);
}


/* ============================================================
 * INSERTION SORT
 * ============================================================
 *
 * Idea:
 * - Maintain a sorted region on the left
 * - Insert each new element into correct position
 *
 * Observations:
 * - Very fast on nearly-sorted data
 *
 * Runtime:
 * - Worst: O(n^2)
 * - Best (sorted): O(n)
 */

for (int i = 1; i < array.length; i++) {
    int value = array[i];
    int j = i - 1;

    while (j >= 0 && array[j] > value) {
        array[j + 1] = array[j];
        j--;
    }

    array[j + 1] = value;
}


/* ============================================================
 * QUICK SORT
 * ============================================================
 *
 * Idea:
 * - Choose a pivot
 * - Partition array into:
 *   - values < pivot
 *   - values > pivot
 * - Recursively sort partitions
 *
 * Observations:
 * - Very fast in practice
 * - Poor pivot choice leads to worst case
 *
 * Runtime:
 * - Average: O(n log n)
 * - Worst: O(n^2)
 */

private static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int sep = low - 1;

    for (int i = low; i < high; i++) {
        if (array[i] < pivot) {
            sep++;
            swap(array, sep, i);
        }
    }

    swap(array, sep + 1, high);
    return sep + 1;
}


/* ============================================================
 * MERGE SORT
 * ============================================================
 *
 * Idea:
 * - Divide array into halves
 * - Recursively sort each half
 * - Merge sorted halves
 *
 * Observations:
 * - Stable
 * - Predictable runtime
 * - Uses extra memory
 *
 * Runtime:
 * - Always O(n log n)
 */

private static void merge(
        int[] array, int[] temp,
        int low, int mid, int high) {

    for (int i = low; i <= high; i++) {
        temp[i] = array[i];
    }

    int i = low, j = mid + 1, k = low;

    while (i <= mid && j <= high) {
        if (temp[i] <= temp[j]) {
            array[k++] = temp[i++];
        } else {
            array[k++] = temp[j++];
        }
    }

    while (i <= mid) {
        array[k++] = temp[i++];
    }

    while (j <= high) {
        array[k++] = temp[j++];
    }
}


/* ============================================================
 * SORTING ALGORITHM COMPLEXITY SUMMARY
 * ============================================================
 *
 * Bubble Sort     → O(n^2)
 * Selection Sort  → O(n^2)
 * Insertion Sort  → O(n^2) (best O(n))
 * Quick Sort      → O(n log n) avg
 * Merge Sort      → O(n log n)
 *
 * Key takeaway:
 * - n log n is the practical lower bound
 * - simple sorts are useful for small or nearly-sorted data
 */
