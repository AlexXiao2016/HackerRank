package datastructure.linkedlist;

public class ReverseDoubleLinkedlist {
	public static Node Reverse(Node head) {
		Node temp = new Node(1);
	    while(head != null){ 
	        temp = head.prev;    
	        head.prev = head.next;
	        head.next = temp;
	        temp = head;
	        head = head.prev;        
	    }
	    return temp;
	}
	
	public static void main(String args[]){
		Node head = new Node(6);
		Node h1 = new Node(4);
		Node h2 = new Node(2);
		head.prev = null;
		head.next = h1;
		h1.next = h2;
		h1.prev = head;
		h2.next = null;
		h2.prev = h1;
		
		Node temp = Reverse(head);
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}			
	}
}
