package f6;

public class nb17 {
    public static void main(String[] args) {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList();
        singleLinkedList.add("A");
        singleLinkedList.add("B");
        singleLinkedList.add("C");
        singleLinkedList.add("D");
        singleLinkedList.add("E");
        System.out.println(singleLinkedList);
        System.out.println("The letter: " + singleLinkedList.getNode(1).data);
        System.out.println("The size is: " + singleLinkedList.size());
    }

    public static class SingleLinkedList<E> {

        public static class Node<E> {
            public final E data;
            public Node<E> next;

            public Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }

        private Node<E> head;
        private Node<E> tail;
        private int size;

        public SingleLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        private Node<E> getNode(int index, Node<E> currentNode) {
            if (index == 0) {
                return currentNode;
            } else return getNode(index - 1, currentNode.next);
        }

        public Node<E> getNode(int index) {
            if (index == 0) {
                return head;
            } else return getNode(index, head);
        }

        public void addFirst(E item) {
            head = new Node<>(item, head);
            if (size == 0)
                tail = head;

            size++;
        }

        public void addAfter(E item) {
            var newNode = new Node<>(item, null);

            if (size == 0) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        }

        private int size(Node<E> head) {
            if (head == null)
                return 0;
            else return 1 + size(head.next);
        }

        public int size() {
            return size(head);
        }

        public void add(int index, E item) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException(Integer.toString(index));

            else if (index == 0) {
                addFirst(item);

            } else if (index == size) {
                addAfter(item);
            } else {
                Node<E> node = getNode(index - 1);
                node.next = new Node<>(item, node.next);
                size++;
            }
        }

        public boolean add(E item) {
            add(size, item);
            return true;
        }

        public E get(int index) {
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException(Integer.toString(index));

            Node<E> node = getNode(index);

            return node.data;
        }

        @Override
        public String toString() {
            if (head == null) {
                return "[The list is empty]";
            }
            StringBuilder sb = new StringBuilder("[");
            Node<E> p = head;
            if (p != null) {
                while (p.next != null) {
                    sb.append(p.data.toString());
                    sb.append(" --> ");
                    p = p.next;
                }
                sb.append(p.data.toString());
            }
            sb.append("]");
            sb.append(" size = ").append(size);
            sb.append("\n");
            sb.append("Head pointing at data = ").append(head.data);
            sb.append("\n");
            sb.append("Tail pointing at data = ").append(tail.data);

            return sb.toString();
        }
    }
}
