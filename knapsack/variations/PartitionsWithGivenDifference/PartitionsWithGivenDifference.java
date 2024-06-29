public class PartitionsWithGivenDifference {
    
    public static int getArrSum(int[] arr, int n, int target) {
        if(target == 0 && n == 0)
            return 1;
            
        if(n <= 0)
            return 0;
            
        if(arr[n - 1] <= target)
            return getArrSum(arr, n-1, target - arr[n-1]) + getArrSum(arr, n-1, target);
        else            
            return getArrSum(arr, n-1, target);
            
    }
    
    public static int countPartitions(int n, int d, int[] arr) {
        // s1 - s2 = d
        // s1 + s2 = s
        
        // hence, 2s1 = d - s
        // s1 = (d + s) / 2
        
        // we need to find s1
        // count of subsets with sum s1
        
        int sum = 0;
        
        for(int i=0; i<n; i++)
            sum += arr[i];
            
        if((d + sum) % 2 != 0)
            return 0;
        
        int target = (d + sum) / 2;
 
        return getArrSum(arr, n, target);
    }

    public static void main(String[] args) {
      System.out.println(countPartitions(4, 3, new int[]{5, 2, 6, 4}));
    }
}
