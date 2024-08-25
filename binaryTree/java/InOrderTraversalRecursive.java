package java;

public class InOrderTraversalRecursive {
    public static void inOrderTraversal(Node root) {
        if(root == null)
            return;
        
        inOrderTraversal(root.left);   
        System.out.println(root.data);
        inOrderTraversal(root.right);
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
