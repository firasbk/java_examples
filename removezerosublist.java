  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap();
        
        int sum = 0;
        for(ListNode pointer = head; pointer != null;  pointer = pointer.next){
            sum+= pointer.val;
            map.put(sum, pointer);
        }
        
        sum = 0;
        for(ListNode pointer = head; pointer != null;  pointer = pointer.next){
            sum+= pointer.val;
            ListNode node = map.get(sum);
            if(sum == 0) head = node.next;
            if(node != pointer) pointer.next = node.next ;
        }
        return head;
    }
	  public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while(cur != null) {
            sum += cur.val;
            if(map.containsKey(sum)) {
                cur = map.get(sum).next;
                int key = sum + cur.val;
                while(key != sum) {
                    map.remove(key);
                    cur = cur.next;
                    key += cur.val;
                }
                map.get(sum).next = cur.next;
            }
            else {
                map.put(sum, cur);   
            }
            cur = cur.next;
        }
        return dummy.next;
    }
	   public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int sum = 0;
        while(cur != null) {
            if(cur.val + sum == 0) dummy.next = cur.next;
            sum += cur.val;
            cur = cur.next;
        }
        if(dummy.next != null) dummy.next.next = removeZeroSumSublists(dummy.next.next);   
        return dummy.next;
    }