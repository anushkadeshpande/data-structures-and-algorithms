import java.util.PriorityQueue;

public class SumOfElementsBetweenK1SmallestAndK2Smallest {
  public static long sumBetweenTwoKth(long arr[], long k1, long k2) {
    PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

    // add k2 smallest elements in heap
    for (int i = 0; i < arr.length; i++) {
      maxHeap.add(arr[i]);

      if (maxHeap.size() > k2) {
        maxHeap.poll();
      }
    }

    // remove k2th element
    maxHeap.poll();

    long sum = 0;

    // add up numbers till k1+1
    while (maxHeap.size() > k1) {
      sum += maxHeap.poll();
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(sumBetweenTwoKth(new long[] { 20, 8, 22, 4, 12, 10, 14 }, 3, 6));
  }
}
