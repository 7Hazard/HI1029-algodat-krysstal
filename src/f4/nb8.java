package f4;

public class nb8 {
    public static void main(String[] args) {
        var queue = new ArrayQueue<Integer>(1);
        queue.offer(1);
        System.out.println(queue);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.capacity());
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue.capacity());
    }

    public static class ArrayQueue<E> {
        private int front, rear, size, capacity;
        private E[] data;

        public ArrayQueue(int initialMaxSize) {
            size = 0;
            front = 0;
            capacity = initialMaxSize;
            rear = capacity - 1;
            data = (E[]) new Object[capacity];
        }

        public boolean offer(E element) {
            if (size == capacity)
                reallocate(capacity * 2);
            rear = (rear + 1) % capacity;
            data[rear] = element;
            size++;
            return true;
        }

        public E peek() {
            if (size == 0) return null;
            return data[front];
        }

        public E poll() {
            if (size == 0) {
                return null;
            } else {
                size--;
                E element = data[front];
                front = (front + 1) % capacity;
                if (size <= capacity / 4)
                    reallocate(capacity / 2);
                return element;
            }
        }

        public int size() {
            return size;
        }

        public int capacity() {
            return capacity;
        }

        private void reallocate(int newMaxSize) {
            E[] newData = (E[]) new Object[newMaxSize];
            int j = front;
            for (int i = 0; i < size; i++) {
                newData[i] = data[j];
                j = (j + 1) % capacity;
            }
            front = 0;
            rear = size - 1;
            capacity = newMaxSize;
            data = newData;
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            sb.append("[");
            var current = front;
            if (size == 1) {
                sb.append(data[current]);
            } else if (size > 1) {
                while (current != rear) {
                    sb.append(data[current]).append(", ");
                    current = (current + 1) % capacity;
                }
                sb.append(data[current]);
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
