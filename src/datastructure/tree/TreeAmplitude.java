package datastructure.tree;

public class TreeAmplitude {
	public int getTreeAmplitude(TreeNode root){
		if(root == null) return 0;
		return helper(root, root.val, root.val);
	}
	
	public int helper(TreeNode root, int max, int min){
		if(root == null) return max - min;
		
		if(root.val < min) min = root.val;
		if(root.val > max) max = root.val;
		
		return Math.max(helper(root, max, min),  helper(root, max, min));
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		val = x;
		left = null;
		right = null;
	}
}
