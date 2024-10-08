import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
  
  public static int getKthSmallestElement(int[] arr, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for(int num: arr) {
      maxHeap.add(num);

      if(maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    return maxHeap.peek();
  }
  public static void main(String[] args) {
    System.out.println(getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 3));
  }  
}
