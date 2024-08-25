package java;

public class PostOrderTraversalRecursive {
    public static void postOrderTraversal(Node root) {
        if(root == null)
            return;
        
        postOrderTraversal(root.left);   
        postOrderTraversal(root.right);
        System.out.println(root.data);
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
