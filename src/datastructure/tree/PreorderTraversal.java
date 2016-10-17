package datastructure.tree;

import java.util.Stack;

public class PreorderTraversal {
	static void preOrderRecursive(Node root) {
		if(root == null){
			return;  
		}else{
			System.out.print(root.data + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}
	
	static void inOrderRecursive(Node root) {
		if(root == null){			
			return;
		}else{								
			inOrderRecursive(root.left);
			System.out.print(root.data + " ");
			inOrderRecursive(root.right);
		}
	}
	
	static void postOrderRecursive(Node root) {
		if(root == null){			
			return;
		}else{								
			postOrderRecursive(root.left);
			postOrderRecursive(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	static void preOrderInteration(Node root){
		if(root == null){
			return;
		}
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()){
			
			Node temp = s.peek();
			System.out.print(temp.data + " ");
			s.pop();
			
			if(temp.right != null){
				s.push(temp.right);
			}
			
			if(temp.left != null){
				s.push(temp.left);
			}			
		}
	}
	
	static void inOrderInteration(Node root){
		if(root == null){
			return;
		}
		Stack<Node> s = new Stack<>();
		Node curr = root;
		while(curr != null){
			s.push(curr);
			curr = curr.left;
		}
		
		while(!s.isEmpty()){
			curr = s.pop();
			System.out.print(curr.data + " ");
			if(curr.right != null){
				curr = curr.right;
				
				while(curr != null){
					s.push(curr);
					curr = curr.left;
				}
			}
		}			
	}

	static void postOrderInteration(Node root){
		if(root == null){
			return;
		}
		Stack<Node> s = new Stack<>();
		Node curr = root;
		s.push(curr);
				
		while(!s.isEmpty()){
			curr = s.peek();
			if(curr.left == null && curr.right == null){
				System.out.print(s.pop().data + " ");
			}else{
				if(curr.right != null){
					s.push(curr.right);
					curr.right = null;
				}
				
				if(curr.left != null){
					s.push(curr.left);
					curr.left = null;
				}
			}
		}	
	}
	public static void main(String args[]){
		Node root = new Node(3);
		Node n1 = new Node(5);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		Node n4 = new Node(4);
		Node n5 = new Node(6);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;

		postOrderInteration(root);
	}
}



class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}