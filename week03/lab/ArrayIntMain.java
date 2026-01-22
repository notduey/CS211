package week03.lab;

public class ArrayIntMain {
    public static void main(String[] args) {
        // 1.
        ArrayIntList list1 = new ArrayIntList();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(4);
        list1.add(7);
        list1.add(15);
        list1.add(20);
        list1.add(7);
        System.out.println(list1.runningTotal());

        // 2.
        ArrayIntList list2 = new ArrayIntList();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(2);
        list2.add(9);
        list2.add(7);
        list2.add(-3);
        list2.add(0);
        list2.add(42);
        list2.add(308);
        list2.add(17);
        System.out.println(list2.longestSortedSequence());

        // 3.
        ArrayIntList list3 = new ArrayIntList();
        list3.add(8);
        list3.add(17);
        list3.add(9);
        list3.add(24);
        list3.add(42);
        list3.add(3);
        list3.add(8);
        list3.removeFront(4);
        System.out.println(list3);

        // 4.
        ArrayIntList list4 = new ArrayIntList();
        list4.add(1);
        list4.add(3);
        list4.add(2);
        list4.add(7);
        list4.mirror();
        System.out.println(list4);

        // 5.
        ArrayIntList list5 = new ArrayIntList();
        list5.add(5);
        list5.add(2);
        list5.add(2);
        list5.add(-5);
        list5.add(4);
        list5.add(3);
        list5.add(2);
        list5.add(4);
        list5.add(1);
        list5.add(1);
        list5.add(1);
        list5.add(0);
        list5.add(2);
        list5.add(17);
        System.out.println(list5.fromCounts());
    }
}
