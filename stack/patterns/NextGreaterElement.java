import java.util.Stack;

public class NextGreaterElement {
    /* 
     * Steps:
     * 1. Traverse the array from last to first
     * 2. If stack is not empty, and while stack.top() < arr[i], pop from the stack
     * 3. Now, if stack is empty, put -1 in result array, else whatever is at the top is the next greatest element
     * 4. Push the current element in the stack
     */
  public static long[] nextLargerElement(long[] arr)
    { 
        Stack<Long> stack = new Stack<>();
        long[] answer = new long[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
                while(!stack.empty() && stack.peek() <= arr[i])
                    stack.pop();
                    
                if(stack.empty())
                    answer[i] = -1;
                else
                    answer[i] = stack.peek();
                stack.push(arr[i]);
            
        }
        
        return answer;
    } 
    
    public static void main (String[] args) {
          long[] arr = {1, 3, 2, 4};
          long[] res = nextLargerElement(arr);
          for(int i=0; i<arr.length; i++)
            System.out.println(res[i]);
    }
}
