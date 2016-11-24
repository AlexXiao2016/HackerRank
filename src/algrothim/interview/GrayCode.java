package algrothim.interview;

public class GrayCode {
	public int grayCheck(byte term1, byte term2){
		byte res = (byte)(term1 ^ term2);
		for(int i = 0; i < 8; i++){
			byte tmp = (byte)(1 << i);
			if(tmp == res){
				return 1;
			}
		}
		
		return 0;
	}
	
	public int grayCheck2(byte term1, byte term2){
		byte x = (byte)(term1 ^ term2);
		int total = 0;
		while(x != 0){
		    x = (byte) (x & (x - 1));
		    total++;
		}
		if(total == 1) return 1; else return 0;
	}
	
	public static void main(String args[]){
		byte term1 = (byte)1, term2 = (byte)5;
		GrayCode gc = new GrayCode();
		int res = gc.grayCheck2(term1, term2);
		System.out.println(res);		
	}
}
