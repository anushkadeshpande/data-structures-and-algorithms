package java;

import java.util.Stack;

public class InOrderTraversalIterative {

    public static void inOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();

        Node node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if (stack.isEmpty())
                    break;
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
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

        System.out.println("INORDER TRAVERSAL:");
        inOrderTraversal(root);

    }
}
