package algrothim.interview;

public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null) return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode secondHalf = slow.next;
		ListNode newHead = null;
		slow.next = null;
		while(secondHalf != null){
			ListNode temp = secondHalf.next;
			secondHalf.next = newHead;
			newHead = secondHalf;
			secondHalf = temp;
		}
		
		slow.next = newHead;
		return head;
	} 
	
	public static ListNode reverseSecondHalfList(ListNode head) {
	    if (head == null || head.next == null)      return head;
	    ListNode fast = head;
	    ListNode slow = head;
	    while (fast.next != null && fast.next.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    ListNode pre = slow.next;
	    ListNode cur = pre.next;
	    while (cur != null) {
	        pre.next = cur.next;
	        cur.next = slow.next;
	        slow.next = cur;
	        cur = pre.next;
	    }
	    return head;
	}
	
	
	public static ListNode reverseList1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null || head.next == null) {
            return head;
        }

        // find the middle node
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second half of linked list
        ListNode pre = null;
        ListNode temp;
        head = slow.next;
        while(head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        slow.next = pre;
        return dummy.next;

    }
	
	public static void main(String args[]){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
//		node4.next = node5;
		
		ListNode head = reverseList(node1);
		
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
