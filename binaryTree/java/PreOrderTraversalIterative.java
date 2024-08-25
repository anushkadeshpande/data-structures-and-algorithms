package java;

import java.util.Stack;

public class PreOrderTraversalIterative {
    
    public static void preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        
        stack.push(root);
        while(!stack.isEmpty()) {
            System.out.println(stack.peek().data);

            root = stack.pop();

            if(root.right != null)
                stack.push(root.right);

            if(root.left != null)
                stack.push(root.left);

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

        System.out.println("PREORDER TRAVERSAL:");
        preOrderTraversal(root);

    }
}
