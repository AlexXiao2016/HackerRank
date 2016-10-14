package datastructure.linkedlist;



public class MergeTwoSortedLinkedLists {
	public static Node MergeLists(Node headA, Node headB) {		
		Node newHead = new Node(1);
		Node curr = newHead;
		
		while(headA != null && headB != null){
			if(headA.data <= headB.data){
				curr.next = headA;
				headA = headA.next;
			}else{
				curr.next = headB;
				headB = headB.next;
			}
			curr = curr.next;
		}
		
		if(headA != null){
			curr.next = headA;
		}else{
			curr.next = headB;
		}
		
		return newHead.next;		
	}
	
	public static void main(String args[]){
		Node a1 = new Node(1);
		Node a2 = new Node(3);
		Node a3 = new Node(5);
		Node a4 = new Node(6);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		
		
		Node b1 = new Node(2);
		Node b2 = new Node(4);
		Node b3 = new Node(7);
		
		b1.next = b2; 
		b2.next = b3;
		
		MergeLists(a1, b1);
	}
}

class Node{
	int data;
	Node next;
	Node prev;
	Node(int data){
		this.data = data;
		next = null;
	}
}
