package algrothim.interview;
import java.util.*;

public class CompanyTree {
	private static double avgRes = Double.MIN_VALUE;
	private static Node result;
	
	public static Node getHighAve(Node root){
		if(root == null) return null;
		dfs(root);
		return result;
	}
	
	private static SumCount dfs(Node root){
		if(root == null || root.children.size() == 0){
			return new SumCount(root.val, 1);
		}
		
		int curSum = root.val;
		int curCnt = 1;
		
		for(Node child : root.children){
			SumCount temp = dfs(child);
			
			curSum += temp.sum;
			curCnt += temp.count;			
		}
		
		double curAvg = (double) curSum / curCnt;
		if(avgRes < curAvg){
			avgRes = curAvg;
			result = root;
		}
		
		return new SumCount(curSum,curCnt);
	}
}

class Node { 
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}

class SumCount{
	int sum;
	int count;
	public SumCount(int sum, int count){
		this.sum = sum;
		this.count = count;
	}
}
