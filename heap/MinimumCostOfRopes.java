import java.util.PriorityQueue;

public class MinimumCostOfRopes {

  public static long minCost(long[] arr) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        
        for(long num: arr)
            heap.add(num);
            
        long res = 0;
        while(heap.size() != 1) {
            long sum = heap.poll() + heap.poll();
            res += sum;
            
            heap.add(sum);
        }
        
        return res;
    }

    public static void main(String[] args) {
      System.out.println(minCost(new long[]{4, 2, 7, 6, 9}));
    }
}