package week08.lab;

public class IntTreeMain {
    public static void main(String[] args) {
        IntTree tree = new IntTree("[3 [5 [1] null ] [2 [4] [6]]]");
        System.out.println(tree);
        System.out.println(tree.size());
        System.out.println(tree.countEmpty());
        System.out.println(tree.depthSum());
        tree.printLeaves();
    }
}
