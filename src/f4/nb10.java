package f4;

public class nb10 {
    public static void main(String[] args) {
        var queue = new Dequeue<Integer>();
        queue.offerLast(4);
        queue.offerFirst(3);
        queue.offerFirst(2);
        queue.offerFirst(1);
        queue.offerLast(5);
        System.out.println(queue);
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollLast());
        System.out.println(queue.pollLast());
        System.out.println(queue.pollFirst());
    }

    static class Dequeue<E> {
        int size = 0;
        Node front, back;

        void offerFirst(E value) {
            if (front == null)
                front = back = new Node(value, null, null);
            else
                front.before = front = new Node(value, null, front);
            size++;
        }

        void offerLast(E value) {
            if (front == null)
                front = back = new Node(value, null, null);
            else
                back.after = back = new Node(value, back, null);
            size++;
        }

        E pollFirst() {
            if (size == 0)
                throw new Error("Queue empty");
            E value = front.value;
            front = front.after;
            if (front == null)
                back = null;
            else
                front.before = null;
            size--;
            return value;
        }

        E pollLast() {
            if (size == 0)
                throw new Error("Queue empty");
            E value = back.value;
            back = back.before;
            if (back == null)
                front = null;
            else
                back.after = null;
            size--;
            return value;
        }

        int size() {
            return size;
        }

        boolean empty() {
            return size == 0;
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            sb.append("[");
            var current = front;
            while (current != null) {
                sb.append(current.value);
                current = current.after;
                if (current != null) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }

        class Node {
            E value;
            Node before;
            Node after;

            Node(E value, Node before, Node after) {
                this.value = value;
                this.before = before;
                this.after = after;
            }
        }
    }
}
