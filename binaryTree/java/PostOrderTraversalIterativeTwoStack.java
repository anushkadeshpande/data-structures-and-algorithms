package java;

import java.util.Stack;

public class PostOrderTraversalIterativeTwoStack {
    public static void postOrderTraversal(Node root) {
        if(root == null)
            return;
        
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if(node.left != null) 
                stack1.push(node.left);

            if(node.right != null)
                stack1.push(node.right);
        }

        while(!stack2.isEmpty())
            System.out.println(stack2.pop().data);
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