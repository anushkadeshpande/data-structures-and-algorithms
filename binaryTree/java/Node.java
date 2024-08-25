package java;

class Node {
    int data;

    Node left;
    Node right;

    public Node(int data) {
        this.data = data;

        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);

        System.out.println(root);

    }
}