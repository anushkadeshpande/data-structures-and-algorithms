package java;

public class HeightOfBinaryTree {
    public static int getHeight(Node root) {
        if(root == null)
            return 0;
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));

    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println("ORIGINAL TREE:");
        System.out.println(root);

        System.out.println("HEIGHT OF BINARY TREE:");
        System.out.println(getHeight(root));
    }
}
