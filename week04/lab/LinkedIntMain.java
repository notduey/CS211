package week04.lab;

public class LinkedIntMain {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList(1, 2, 3, 4, 5);
        list.set(2, 0);
        System.out.println(list);
        System.out.println(list.toStringShort());

        LinkedIntList list2 = new LinkedIntList(1, 18, 2, 7, 18, 39, 18, 40);
        int lastIndex = list2.lastIndexOf(18);
        System.out.println(lastIndex);

        LinkedIntList list3a = new LinkedIntList(1, 18, 2, 7, 8, 39, 18, 40);
        LinkedIntList list3b = new LinkedIntList(1, 18, 17, 2, 7, 39, 18, 40, 8);
        System.out.println(list3a.hasTwoConsecutive());
        System.out.println(list3b.hasTwoConsecutive());
        
        LinkedIntList list4 = new LinkedIntList(3, 7, 4, 9, 8, 12);
        list4.switchPairs();
        System.out.println(list4);
        System.out.println(list4.toStringShort());

        LinkedIntList list5 = new LinkedIntList(1, 8, 19, 4, 17);
        list5.stutter();
        System.out.println(list5);
        System.out.println(list5.toStringShort());

        LinkedIntList list6 = new LinkedIntList(8, 7, -4, 19, 0, 43, -8, -7, 2);
        list6.split();
        System.out.println(list6);
        System.out.println(list6.toStringShort());

        LinkedIntList list7 = new LinkedIntList(0, 1, 2, 3, 4, 5, 6, 7);
        list7.shift();
        System.out.println(list7);
        System.out.println(list7.toStringShort());

        LinkedIntList list8 = new LinkedIntList(1, 8, 19, 4, 17);
        list8.reverse();
        System.out.println(list8);
        System.out.println(list8.toStringShort());
    }
}
