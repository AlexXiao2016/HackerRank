package datastructure.array;

import java.util.*;

public class BetweenTwoSets {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int count = 0;
        int k = 1;
        int temp = a[n - 1];
        int divider = temp;
        while(divider <= b[0]){
        	boolean flag = true;
            for(int i = 0; i < m; i++){
                if(b[i] % divider != 0){
                	flag = false;
                    break;
                }
            }
            for(int i = 0; i < n; i++){
            	if(divider % a[i] != 0){
                	flag = false;
                    break;
                }
            }
            if(flag){
            	count++;   
            }
            divider = temp * ++k;
        }        
        System.out.println(count);        
    }
}
