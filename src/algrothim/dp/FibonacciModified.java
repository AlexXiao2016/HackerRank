package algrothim.dp;

import java.math.BigInteger;

public class FibonacciModified {
	public static BigInteger getModifiedFibonacci(int n){
		BigInteger t1 = BigInteger.valueOf(0);
		BigInteger t2 = BigInteger.valueOf(1);;
		
		BigInteger result = BigInteger.valueOf(0);
		for(int i = 3; i <= n; i++){
			result = t1.add(t2.multiply(t2)) ;
			t1 = t2;
			t2 = result;
		}
		
		return result;
	}
	
	public static void main(String args[]){
		System.out.println(getModifiedFibonacci(5));
	}
}
