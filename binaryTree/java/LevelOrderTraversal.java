package java;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    
    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root == null)
            return;

        queue.add(root);
        while (!queue.isEmpty()) {
            Node data = queue.remove();
            System.out.println(data.data);
            if(data.left != null)
                queue.add(data.left);

            if(data.right != null)
                queue.add(data.right);
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
        levelOrderTraversal(root);

    }
}
