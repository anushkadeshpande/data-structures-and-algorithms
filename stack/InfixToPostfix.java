package stack;

import java.util.Stack;

public class InfixToPostfix {

  public static String convertToPostfix(String infix) {
    int i;
    int instack;
    int incoming;

    String post = "";

    Stack<Character> stack = new Stack<>();

    for(i=0; i<infix.length(); i++) {
      char c = infix.charAt(i);

      // if the current character is a letter / digit, add it to the stack
      if(Character.isLetterOrDigit(c)) {
        post += c;
        post += ' ';
      } else {

        // if current char is an opening brace, push it to the stack
        if(c == '(') {
          stack.push(c);
        } else {

          // if it is not a character / opening brace, i.e is an operator and stack is empty, push it to the stack
          if(stack.empty()) {
            stack.push(c);
          } else if(c == ')') {
            // if it is a closing brace, till we don't get the corresponding opening brace, pop it from the stack and add to the postorder expression
            while(stack.peek() != '(') {
              post += stack.pop();
              post += ' ';
            }

            stack.pop();
          } else {
            // if stack is not empty, and the current charater is an operator, check the priority of the operator at the top of the stack and the current character
            instack = getPriority(stack.peek());
            incoming = getPriority(c);
            
            // if the current character has a higher priority, push it on the stack
            // else pop the top, add it to the postorder expression and push the current char on the stack
            if(incoming > instack) {
              stack.push(c);
            } else {
              post += stack.pop();
              post += ' ';
              stack.push(c);
            }
          }
        }
      }
    }

    // pop everything else remaining in the stack and add to the postfix expression
    while(!stack.empty()) {
      post += stack.pop();
      post += ' ';
    }

    return post;
  }
  public static void main(String[] args) {
    System.out.println(convertToPostfix("1*(2+3)*4")); 
  }

  public static int getPriority(char operator) {
    switch(operator) {
      case '^':
        return 3;
      
      case '*':
        return 2;
      
      case '/':
        return 2;

      case '%':
        return 2;

      case '+':
        return 1;

      case '-':
        return 1;

      default:
        return -1;
    }
  }
}
