package f7;

public class nb23_1 {
    public static void main(String[] args) {
        var bst = new BinarySearchTree<Integer>();
        bst.add(4);
        bst.add(6);
        bst.add(12);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        System.out.println(bst);
        System.out.println(bst.maxRec());
        System.out.println(bst.maxIt());
    }

    public static class BinarySearchTree<E extends Comparable<E>> {
        private Node<E> root;

        public E maxRec() {
            return maxRec(root);
        }

        private E maxRec(Node<E> node) {
            if (node.right == null)
                return node.data;
            return maxRec(node.right);
        }

        public E maxIt() {
            return maxIt(root);
        }

        private E maxIt(Node<E> node) {
            E max = null;
            while (node.right != null) {
                node = node.right;
                max = node.data;
            }
            return max;
        }

        private boolean add(E data, Node<E> node) {
            if (data.compareTo(node.data) == 0) {
                return false;
            } else if (data.compareTo(node.data) < 0) {
                if (node.left == null) {
                    node.left = new Node<E>(data);
                    return true;
                } else {
                    return add(data, node.left);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node<>(data);
                    return true;
                } else {
                    return add(data, node.right);
                }
            }
        }

        public boolean add(E data) {
            if (root == null) {
                root = new Node<>(data);
                return true;
            } else {
                return add(data, root);
            }
        }

        private class Node<E> {
            private E data;
            private Node<E> left, right;


            private Node(E d) {
                this.data = d;
                left = right = null;
            }

            @Override
            public String toString() {
                return data.toString();
            }
        }

        private void inOrder(Node<E> node, StringBuilder sb) { // traverseringsordningen som sorterar i storleksording (rekursiv)
            if (node != null) {
                inOrder(node.left, sb);
                sb.append(":" + node.toString());
                inOrder(node.right, sb);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            inOrder(root, sb);
            return sb.toString();
        }
    }

}
