package ten1606;

public class uppg3 {
    public static void buildTree(BinarySearchTree<String> b){
        b.add("H");
        b.add("B");
        b.add("A");
        b.add("E");
        b.add("C");
        b.add("F");
        b.add("D");
        b.add("G");
    }
    public static void main(String[] args) {

        BinarySearchTree<String> bst= new BinarySearchTree<String>();
        buildTree(bst);
        System.out.println(bst);
        bst.reverse();
        System.out.println(bst);
    }
}
