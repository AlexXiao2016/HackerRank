package algrothim.dp;

import java.util.Scanner;

public class TheMaximumSubarray {

	public static int maxSubArray(int nums[]){
		int max_ending_here = 0;
		int max_so_far = 0;

		for(int x : nums){
			max_ending_here = Math.max(x, max_ending_here + x);
			max_so_far=Math.max(max_so_far, max_ending_here);
		}

		return max_so_far;
	}


	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                int sum = sum(arr, i, j);
                max = sum > max ? sum : max;
            }
        }
        
        System.out.println(max);
	}
	
	public static int sum(int a[][], int i, int j){
        int sum = 0;
        for(int row = i; row < i + 3; row++){
            for(int col = j; col < j + 3; col++){
                sum += a[row][col];
            }
        }
        sum -= a[i + 1][j];
        sum -= a[i + 1][j + 2];
        return sum;
    }
}
