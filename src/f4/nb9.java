package f4;

public class nb9 {
    public static void main(String[] args) {
        var queue = new LinkedQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    static class LinkedQueue<E> {
        class Node {
            E value;
            Node behind;

            Node(E value, Node behind) {
                this.value = value;
                this.behind = behind;
            }
        }

        int size = 0;
        Node front, back;

        void enqueue(E value) {
            if (front == null)
                front = back = new Node(value, null);
            else
                back.behind = back = new Node(value, null);
            size++;
        }

        E dequeue() {
            if (size == 0)
                throw new Error("Queue empty");
            E value = front.value;
            front = front.behind;
            if (front == null) back = null;
            size--;
            return value;
        }

        int size() {
            return size;
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            sb.append("[");
            var current = front;
            while (current != null) {
                sb.append(current.value);
                current = current.behind;
                if (current != null) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
