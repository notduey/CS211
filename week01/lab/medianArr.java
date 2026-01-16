package week01.lab;

public class medianArr {
    public static void main(String[] args) {
        // assume the array has an uneven number of elements for this program
        int[] arr = {42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27};
        int median = median(arr);
        System.out.println("The median is " + median + ".");
    }

    public static int median(int[] arr) {
        int[] tally = new int[100]; // 0-99

        // for each value in the array, add 1 to the index of that value
        // e.g. if the value is 42, then tally[42] = 1
        for (int values : arr) {
            tally[values]++;
        }

        // median is the middle number in the array
        //arr.length / 2 is the middle number index
        int middleNum = arr.length / 2;
        int count = 0;
        
        // loop through tally and adds tally[i] to count
        //when the count is greate than middleNum, return i (median)
        for (int i = 0; i < tally.length; i++) {
            count += tally[i];

            if (count > middleNum) {
                return i;
            }
        }

        return -1; // unreachable
    }
}
