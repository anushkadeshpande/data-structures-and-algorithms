import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NearlySorted {
  public static List<Integer> nearlySorted(int arr[], int k)
  {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    List<Integer> sortedArray = new ArrayList<>();
    
    for(int n: arr) {
      minHeap.add(n);
      
      if(minHeap.size() > k) {
        sortedArray.add(minHeap.poll());
      }
    }
    
    while(minHeap.size() > 0)
      sortedArray.add(minHeap.poll());
      
    return sortedArray;
  }

  public static void main(String[] args) {
    List<Integer> sortedArr = nearlySorted(new int[] {6,5,3,2,8,10,9}, 3);

    sortedArr.stream().forEach(System.out::println);
  }
}
