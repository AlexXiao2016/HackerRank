package datastructure.array;

public class MergeSortArray {
	
	public static void mergeSort(int nums[]){
		if(nums.length <= 1){
			return;
		}
		int[] left = new int[nums.length / 2];
		int[] right = new int[nums.length - left.length];
		
		System.arraycopy(nums, 0, left, 0, left.length);
		System.arraycopy(nums, left.length, right, 0, right.length);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left, right, nums);
	}
	
	public static void merge(int[] left, int[] right, int[] result){
		int leftPos = 0;
		int rightPos = 0;
		int resultPos = 0;
		
		while(leftPos < left.length && rightPos < right.length){
			if(left[leftPos] < right[rightPos]){
				result[resultPos] = left[leftPos++];
			}else{
				result[resultPos] = right[rightPos++];
			}
			resultPos++;
		}
		
		System.arraycopy(left, leftPos, result, resultPos, left.length - leftPos);
		System.arraycopy(right, rightPos, result, resultPos, right.length - rightPos);
	}
	
	public static void main(String args[]){
		int nums[] = {12, 6, 3, 5, 13, 1, 8};
		mergeSort(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		
	}

}
