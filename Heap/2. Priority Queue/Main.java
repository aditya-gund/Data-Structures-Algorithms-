import java.util.PriorityQueue;

public class Main {
 public static void main(String[] args){
    PriorityQueue<Integer> q = new PriorityQueue<>();
    // Add elements in the Queue
    q.add(10);
    q.add(20);
    q.add(30);
    q.add(40);
    q.poll();
    System.out.println("Head of Queue: " + q.peek());
 }
}