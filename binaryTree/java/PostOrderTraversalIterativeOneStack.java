package java;

import java.util.Stack;

public class PostOrderTraversalIterativeOneStack {
        
    public static void postOrderTraversal(Node root) {
        if(root == null)
            return;
        
        Stack<Node> stack = new Stack<>();
    
        // first go to extreme left, pushing all elements into the stack
        // once all left nodes are visited, go to the right, and then go to extreme right
        // once all right nodes are visited, start popping them and print them

        // stack.push(root);
        Node current = root;
        Node temp = null;
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                temp = stack.peek().right;
                
                // if the right node is null
                if(temp == null) {
                    // pop an element from stack
                    temp = stack.pop();

                    // print the popped node
                    System.out.println(temp.data);

                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        
                        System.out.println(temp.data);
                    }
                }
                else
                    current = temp;
            }
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println("ORIGINAL TREE:");
        System.out.println(root);

        System.out.println("POSTORDER TRAVERSAL:");
        postOrderTraversal(root);

    }
}
