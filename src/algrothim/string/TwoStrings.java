package algrothim.string;

import java.util.Scanner;

public class TwoStrings {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String s[] = new String[2 * n];
		for(int i = 0; i < 2 * n; i += 2){
			s[i] = in.nextLine();
			s[i + 1] = in.nextLine();
		}

		String str = "abcdefghijklmnopqrstuvwxyz";		
		for(int i = 0; i < 2 * n; i += 2){
			boolean flag = false;
			for(char c : str.toCharArray()){
				if(s[i].indexOf(c) > -1 && s[i + 1].indexOf(c) > -1){
					flag = true;
					break;
				}
			}
			if(flag){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		in.close();
	}
}
