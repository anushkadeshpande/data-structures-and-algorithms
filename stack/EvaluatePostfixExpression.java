package stack;

import java.util.Stack;

public class EvaluatePostfixExpression {

  public static int evaluate(String postfixExpression) {
    Stack<Integer> stack = new Stack<>();
    int a, b, x;

    for (int i = 0; i < postfixExpression.length(); i++) {
      char c = postfixExpression.charAt(i);
      if (c != ' ') {

        if (Character.isDigit(c)) {
          stack.push(c - '0');
        } else {
          a = stack.pop();
          b = stack.pop();

          x = calculate(a, b, c);

          stack.push(x);
        }
      }

    }
    return stack.pop();
  }

  public static int calculate(int a, int b, char operator) {
    switch (operator) {
      case '^':
        return b ^ a;
      case '*':
        return b * a;
      case '/':
        return b / a;
      case '%':
        return b % a;
      case '+':
        return b + a;
      case '-':
        return b - a;
      default:
        return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(evaluate("1 2 3 + * 4 *"));
    // 1*(2+3)*4 --> 20
  }
}
