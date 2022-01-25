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
}
