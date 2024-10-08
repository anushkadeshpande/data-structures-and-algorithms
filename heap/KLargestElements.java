import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {
  public static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] kLargestElements = new int[k];
        
        for(int num: arr) {
            minHeap.add(num);
            
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        for(int i=k-1; i>=0; i--) {
            kLargestElements[i] = minHeap.poll();
        }
        
        return kLargestElements;
    }
  
  public static void main(String[] args) {
    int[] kLargestElements = kLargest(new int[]{12, 5, 787, 1, 23}, 2);
    Arrays.stream(kLargestElements).forEach(System.out::println);
  }
}
