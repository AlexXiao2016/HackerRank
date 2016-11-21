package algrothim.interview;
import java.util.*;

public class InsertIntoCycleLinkedList {
	public ListNode insertLinkedList(ListNode head, int val){
		if(head == null){
			ListNode node = new ListNode(val);
			node.next = node;
			return node;
		}
		
		ListNode cur = head;
		
		do{
			if(cur.val <= val && val <= cur.next.val) break;
			
			if(cur.val > cur.next.val && (val > cur.val || val < cur.next.val)) break;
			
			cur = cur.next;
		}while(cur != head);
		
		ListNode node = new ListNode(val);
		node.next = cur.next;
		cur.next = node;
			
		return head;	
	}
}


class ListNode{
	int val;
	ListNode next;
	ListNode(int v){
		val = v;
	}
}


