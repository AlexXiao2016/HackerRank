package algrothim.interview;

public class MaximumMinimumPath {
	public int helper(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		int res[] = new int[n];
		res[0] = matrix[0][0];
		for(int i = 1; i < n; i++){
			res[i] = Math.min(res[i - 1], matrix[0][i]);
		}
		
		for(int i = 1; i < m; i++){
			res[0] = Math.min(res[0], matrix[i][0]);
			for(int j = 1; j < n; j++){
				res[j] = (res[j] < matrix[i][j] && res[i - 1] < matrix[i][j]) ? Math.max(res[j], res[j - 1]) : matrix[i][j];
			}
		}
		
		return res[n - 1];
	}
	
	public int maxMinPath(int matrix[][]){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		int max[] = new int[1];
		int min = Integer.MAX_VALUE;
		max[0] = Integer.MIN_VALUE;
		
		dfs(matrix, max, min, 0, 0);
		return max[0];
	}
	
	public void dfs(int[][] matrix, int[] max, int min, int i, int j){
		if(i >= matrix.length || j >= matrix[0].length) return;

		min = Math.min(min, matrix[i][j]);
		if(i == matrix.length - 1 && j == matrix[0].length - 1){
			max[0] = Math.max(max[0], min);
			return;
		}
		dfs(matrix, max, min, i + 1, j);
		dfs(matrix, max, min, i, j + 1);		
	}
	
	public static void main(String args[]){
		int[][] matrix={{8,4,7},{6,6,9}};
		
		MaximumMinimumPath mmp = new MaximumMinimumPath();
		int res = mmp.maxMinPath(matrix);
		System.out.println(res);
	}
}
