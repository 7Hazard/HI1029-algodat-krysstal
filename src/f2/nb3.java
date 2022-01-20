package f2;

public class nb3 {
    public static void main(String[] args) {
        var node = new Node();
        var head = node;
        node.data = "Gilgamesh";
        node = node.next = new Node();
        node.data = "löper";
        node = node.next = new Node();
        node.data = "på";
        node = node.next = new Node();
        node.data = "stäppen";

        // Ta bort "på"
        node = head;
        node.next.next = node.next.next.next;

        // printa
        node = head;
        do {
            if (node != head) System.out.print(" -> ");
            System.out.print(node.data);
            node = node.next;
        }
        while (node != null);
    }

    public static class Node{
        public String data;
        public Node next;
    }
}
