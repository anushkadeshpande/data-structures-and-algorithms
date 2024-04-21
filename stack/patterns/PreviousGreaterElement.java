import java.util.Stack;

public class PreviousGreaterElement {
  /* 
   * Steps:
   * 1. If stack is not empty and top is <= arr[i], pop until top > arr[i] or until stack becomes empty
   * 2. If stack is empty, push -1 into results array
   * 3. else, stack's top is the the previous greater element
   * 4. Push the current element on the stack 
   */
  private static long[] previousLargerElement(long[] arr) {
    Stack<Long> stack = new Stack<>();
    long[] answer = new long[arr.length];

    for (int i = 0; i < arr.length; i++) {
      while (!stack.empty() && stack.peek() <= arr[i])
        stack.pop();

      if (stack.empty())
        answer[i] = -1;
      else
        answer[i] = stack.peek();
      stack.push(arr[i]);
    }

    return answer;
  }

  public static void main(String[] args) {
    long[] arr = { 1, 3, 2, 4 };
    long[] res = previousLargerElement(arr);
    for (int i = 0; i < arr.length; i++)
      System.out.println(res[i]);
  }
}
