package f4;

import java.util.Arrays;

public class nb8_1 {
    public static void main(String[] args) {
        {
            new ArrayQueue(0);
            new ArrayQueue(1);
            new ArrayQueue(2);
        }

        {
            var queue = new ArrayQueue<Integer>(1);
            System.out.println(queue);
            queue.offer(76);
            System.out.println(queue);
        }

        {
            var queue = new ArrayQueue<Integer>(1);
            queue.offer(1);
            System.out.println(queue);
            queue.offer(2);
            queue.offer(3);
            queue.offer(4);
            queue.poll();
            queue.poll();
            queue.poll();
            System.out.println(queue);
            queue.poll();
            System.out.println(queue);
        }
    }

    public static class ArrayQueue<E> {
        private int front, rear, size, maxSize;
        private E[] data;

        public ArrayQueue(int initialSize) {
            size = 0;
            front = 0;
            maxSize = initialSize;
            rear = 0;
            data = (E[]) new Object[maxSize];
        }

        public boolean offer(E element) {
            if (size == maxSize)
                reallocate();

            // fel
//            data[rear] = element;
//            rear = rear + 1 % maxSize;
            // rätt
            rear = (rear + 1) % maxSize;
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

                // fel
//                front = front + 1 % maxSize;
                // rätt
                front = (front + 1) % maxSize;

                return element;
            }
        }

        private void reallocate() {
            // fel (slarvigt)
//            maxSize *= 2;
//            data = Arrays.copyOf(data, maxSize);
            // rätt
            var newMaxSize = maxSize*2;
            E[] newData = (E[]) new Object[newMaxSize];
            int j = front;
            for (int i = 0; i < size; i++) {
                newData[i] = data[j];
                j = (j + 1) % maxSize;
            }
            front = 0;
            rear = size - 1;
            maxSize = newMaxSize;
            data = newData;
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            sb.append("[");
            var current = front;
            if(size == 1) {
                sb.append(data[current]);
            } else if(size > 1) {
                while (current != rear) {
                    sb.append(data[current]).append(", ");
                    current = (current+1)%maxSize;
                }
                sb.append(data[current]);
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
