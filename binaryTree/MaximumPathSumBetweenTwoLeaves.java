class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

public class MaximumPathSumBetweenTwoLeaves {
  public static long findMaxSumPath(TreeNode root) {
		// requiredData[0] -- > maxSumPath
		// requiredData[1] -- > number of leaf nodes
		int[] requiredData = new int[] {Integer.MIN_VALUE, 0};

		findMaxSum(root, requiredData);
		if(requiredData[1] < 2)
			return -1;
		return requiredData[0];
	}

	public static int findMaxSum(TreeNode node, int[] requiredData) {
		if(node == null)
			return 0;

		int leftSum = findMaxSum(node.left, requiredData);
		int rightSum = findMaxSum(node.right, requiredData);
		if(leftSum == 0 && rightSum == 0)
			requiredData[1]++;

		int maxSum = Math.max(leftSum, rightSum);

		int ans = Math.max(maxSum, leftSum + rightSum) + node.data;

		requiredData[0] = Math.max(ans, requiredData[0]);

		return maxSum + node.data;
	}

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(5, new TreeNode(6, new TreeNode(4, new TreeNode(9), new TreeNode(7)), new TreeNode(3)), new TreeNode(2));

    System.out.println(findMaxSumPath(tree));
    
  }
}
