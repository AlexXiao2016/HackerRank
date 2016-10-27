package algrothim.dp;

import java.util.*;

public class Candies {
	
	public static long getCandies(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int n = nums.length;
		int candies[] = new int[n];
		for(int i = 0; i < n; i++){
			candies[i] = 1;
		}
		
		for(int i = 1; i < n; i++){
			if(nums[i] > nums[i - 1]){
				candies[i] = candies[i - 1] + 1;
			}
		}
		
		long sum = candies[n - 1];
		for(int i = n - 2; i >= 0; i--){
			if(nums[i] > nums[i + 1]){
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
			sum += (long) candies[i];
		}
				
		return sum;				
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine().toString());
		int nums[] = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = Integer.valueOf(in.nextLine().toString());
		}
		System.out.println(getCandies(nums));
	}
}
