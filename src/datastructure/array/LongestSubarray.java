package datastructure.array;

public class LongestSubarray {
	public static int maxLength(int[] a, int k) {
		if(a == null || a.length == 0 || k <= 0){
			return 0;
		}

		int n = a.length;
		int[] maxLength = new int[n];
		int sum = 0, count = 0;

		for(int j = 0, i = 0; j < n; j++){
			sum += a[j];
			if(sum <= k){
				count++;
				maxLength[j] = Math.max(count, maxLength[j]);
			}else{				
				j = i++;
				sum = 0; 
				count = 0;
			}
			if(j > 0){
				maxLength[j] = Math.max(maxLength[j - 1], maxLength[j]);
			}
		}


		return maxLength[n - 1];

	}

	public static void main(String args[]){
		int[] nums = {3,2,1,9,8,7,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int nums2[] = {74,659,931,273,545,879,924,710,441,166,493,43,988,504,328,730,841,613,304,170,710,158,561,934,100,279,817,336,98,827,513,268,811,634,980,
				150,580,822,968,673,394,337,486,746,229,92,195,358,2,154,709,945,669,491,125,197,531,904,723,667,550};
		//22337
		System.out.println(maxLength(nums, 30));

	}
}
