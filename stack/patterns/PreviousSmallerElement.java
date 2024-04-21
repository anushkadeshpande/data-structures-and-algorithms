import java.util.Stack;

public class PreviousSmallerElement {
/* 
 * Steps:
 * 1. Iterate over array
 * 2. While stack is not empty and top element is greater than current element, pop from stack
 * 3. If stack is empty, push -1 into answer else push top element into answer
 * 4. Push the current element onto the stack 
 */
  private static long[] previousSmallerElement(long[] arr) {
    Stack<Long> stack = new Stack<>();
    long[] answer = new long[arr.length];

    for (int i = 0; i < arr.length; i++) {
      while (!stack.empty() && stack.peek() >= arr[i])
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
    long[] res = previousSmallerElement(arr);
    for (int i = 0; i < arr.length; i++)
      System.out.println(res[i]);
  }
}
