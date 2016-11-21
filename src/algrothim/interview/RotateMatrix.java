package algrothim.interview;

public class RotateMatrix {
	public int[][] rotatematrix(int[][] matrix, int flag){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return new int[0][0];
		}
		
		int[][] res = transpose(matrix);
		if(flag == 1){
			for(int i = 0; i < res.length; i++){
				for(int j = 0; j < res[0].length / 2; j++){
					int temp = res[i][j];
					res[i][j] = res[i][res[0].length - j - 1];
					res[i][res[0].length - j - 1] = temp;
				}
			}
		}else{
			for(int i = 0; i < res.length / 2; i++){
				for(int j = 0; j < res[0].length; j++){
					int temp = res[i][j];
					res[i][j] = res[res.length - i - 1][j];
					res[res.length - i - 1][j] = temp;
				}
			}
		}
		
		return res;
	}
	
	public int[][] transpose(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] res = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				res[i][j] = matrix[j][i];
			}
		}
		
		return res;
	}
	
	public static void main(String args[]){
		int matrix[][] = {{1,2,3,4,5},{6,7,8,9,10}};
		RotateMatrix rm = new RotateMatrix();
		int res[][] = rm.rotatematrix(matrix, 0);
		for(int i = 0; i < res.length; i++){
			for(int j = 0; j < res[0].length; j++){
				System.out.print(res[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
