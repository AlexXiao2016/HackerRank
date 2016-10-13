package array;

import java.util.Scanner;

public class LeftRotation {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        k = n - k % n;
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }         
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
        
        for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " "); 
        }
        in.close();
	}
	
	public static void reverseArray(int[] array, int start, int end){
		int temp;
		while(start < end){
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}

