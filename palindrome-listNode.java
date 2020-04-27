    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode reverse = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode current = slow;
            slow = slow.next;
            
            current.next = reverse;
            reverse = current;
        }
        
        if (fast != null) {
            slow = slow.next;
        }
        
        while (slow != null && reverse != null) {
            if (slow.val != reverse.val) {
                return false;
            }
            
            slow = slow.next;
            reverse = reverse.next;
        }
        
        return slow == null && reverse == null;
    }
	/*
	public boolean isPalindrome(ListNode head) {
	ListNode slow=head,fast=head;
	while(fast !=null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
	}
	slow = reverseLinkedList(slow);
	while(slow != null) {
		if(slow.val != head.val) return false;
		slow = slow.next;
		head = head.next;
	}
	return true;
}

public ListNode reverseLinkedList(ListNode node){
	ListNode previous = null, current=node, next=null;
	while(current != null) {
		next = current.next;
		current.next = previous;
		previous = current;
		current = next;
	}
	return previous;
}
*/