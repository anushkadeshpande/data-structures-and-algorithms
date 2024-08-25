package java;

/*
 * For every node, height(left_subtree) - height(right_subtree) <= 1
 * 
 * Approach:
 * 1. Find height of tree recursively
 * 2. At any point if the difference becomes > 1, return -1, else return the height
 */
public class BalancedBinaryTree {

    public static boolean isBalanced(Node root) {
        return getHeight(root) != -1; 
    }

    public static int getHeight(Node node) {
        if (node == null)
            return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        // BALANCED BINARY TREE
        Node root = new Node(3);

        root.left = new Node(9);
        root.right = new Node(20);

        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println("ORIGINAL TREE:");
        System.out.println(root);

        System.out.println("Is tree balanced?");
        System.out.println(isBalanced(root));       // true



         // IMBALANCED BINARY TREE
        Node root1 = new Node(1);

        root1.left = new Node(2);
        root1.right = new Node(4);

        root1.left.left = new Node(3);
        root1.left.left.left = new Node(9);

        root1.right.left = new Node(5);
        root1.right.right = new Node(6);
        root1.right.right.right = new Node(7);
        root1.right.right.right.right = new Node(8);

        System.out.println("ORIGINAL TREE:");
        System.out.println(root1);

        System.out.println("Is tree balanced?");
        System.out.println(isBalanced(root1));      // false
    }
}
