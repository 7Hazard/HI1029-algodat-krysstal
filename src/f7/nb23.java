package f7;

public class nb23 {
    public static void main(String[] args) {
        var bst = new BinarySearchTree<Character>();
        bst.add('C');
        bst.add('F');
        bst.add('E');
        bst.add('G');
        bst.add('R');
        bst.add('S');
        bst.add('H');
        bst.add('X');
        bst.add('T');
        bst.add('J');
        bst.add('B');
        bst.add('A');
        System.out.println(bst);
        System.out.println(bst.numberOfLeaves());
        System.out.println(bst.numberOfNodes());
        System.out.println(bst.height());
    }


    public static class BinarySearchTree<E extends Comparable<E>> {

        private Node<E> root;

        public int numberOfLeaves() {
            return numberOfLeaves(root);
        }

        private int numberOfLeaves(Node<E> node) {
            if (node == null)
                return 0;

            if (node.right == null && node.left == null)
                return 1;

            return numberOfLeaves(node.left) + numberOfLeaves(node.right);

        }

        public int height() {
            return height(root);
        }

        private int height(Node<E> node) {
            if (node == null)
                return 0;

            return 1 + Math.max(height(node.left),height(node.right));
        }

        public int numberOfNodes() {
            return numberOfNodes(root);
        }

        private int numberOfNodes(Node<E> node) {
            if (node == null)
                return 0;

            return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
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
