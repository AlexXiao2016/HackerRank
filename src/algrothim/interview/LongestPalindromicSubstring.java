package algrothim.interview;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)  return s;
        
        String max = "";
        for(int i = 0; i < s.length(); i++){
            String temp = getLongest(s, i, i);
            if(temp.length() > max.length()){
                max = temp;
            }
            
            temp = getLongest(s, i, i + 1);
            if(temp.length() > max.length()){
                max = temp;
            }
        }
        
        return max;
    }
    
    private String getLongest(String s, int start, int end){
        while(start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
    
    public static void main(String args[]){
    	LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
    	System.out.println(lps.longestPalindrome("bb"));
    }
}
