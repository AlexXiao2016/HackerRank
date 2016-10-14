package datastructure.linkedlist;

public class InsertNodeintoDoubleLinkedList {
	public static Node SortedInsert(Node head,int data) {
		Node temp = new Node(1);
		temp.data = data;

		if(head == null){
			temp.prev = null;
			temp.next = null;
			head = temp;
			return head;
		}

		Node newHead = new Node(1);
		newHead.next = head;
		head.prev = newHead;
		
		while(head != null){
			if(head.data > data){            
				head.prev.next = temp;
				temp.prev = head.prev;            
				temp.next = head;
				head.prev = temp;
				break;
			}else{
				if(head.next == null){
					head.next = temp;
					temp.next = null;
					temp.prev = head;
					break;
				}
			}    
			head = head.next;
		}
		
		newHead.next.prev = null;
		return newHead.next;
	}
	
	public static void main(String args[]){
		Node head = null;
		head = SortedInsert(head, 2);
		head = SortedInsert(head, 1);
		head = SortedInsert(head, 4);
		head = SortedInsert(head, 3);		
		
	}

}


