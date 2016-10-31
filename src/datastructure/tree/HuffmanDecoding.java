package datastructure.tree;

public class HuffmanDecoding {
	public void decode(String S ,Node root)
	{
		String result = "";
	    Node curr = root;
	    for(int i = 0; i < S.length(); i++){
	        char c = S.charAt(i);
	        curr = c == '1' ? curr.right : curr.left;
	        if(curr.left == null && curr.right == null){
	            result += curr.data;
	            curr = root;
	        }
	    }
	    System.out.println(result);
	}

}
