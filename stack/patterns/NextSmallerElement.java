import java.util.Stack;

public class NextSmallerElement {
  /*
   * 1. Iterate over the array from the end
   * 2. If stack is not empty, keep popping elements while the top element is
   * greater than the current element or stack bevomes empty
   * 3. If stack is empty, push -1 into results, else push the top element
   * 4. Push the current element on the stack
   */
  private static long[] nextSmallerElement(long[] arr) {
    Stack<Long> stack = new Stack<>();
    long[] answer = new long[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!stack.empty() && stack.peek() > arr[i])
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
    long[] arr = { 1, 5, 2, 4, 3 };
    long[] res = nextSmallerElement(arr);
    for (int i = 0; i < arr.length; i++)
      System.out.println(res[i]);
  }
}
