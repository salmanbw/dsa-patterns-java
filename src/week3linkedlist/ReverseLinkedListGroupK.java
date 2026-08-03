package week3linkedlist;

public class ReverseLinkedListGroupK {

    public static void main(String[] args) {

        LLNode a = new LLNode(1);
        LLNode b = new LLNode(2);
        LLNode c = new LLNode(3);
        LLNode d = new LLNode(4);
        LLNode e = new LLNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        LinkedListOps listOps = new LinkedListOps();
        listOps.printLinkedList(a);
        listOps.printLinkedList(listOps.reverseLinkedList(a));

    }

    public static LLNode reverseK(LLNode node, int k){

        LinkedListOps listOps = new LinkedListOps();
        LLNode kPrev = null;
        LLNode kTemp = null;
        LLNode curr = node;
        LLNode slow = node;
        LLNode fast = node;


        while(curr != null || fast != null){
            for(int i=1;i<=k-1;i++){
                fast = fast.next;
                kTemp = fast.next;
                fast.next = null;
            }

            while(slow != fast){
                slow = listOps.reverseLinkedList(slow);

            }

        }
        return slow;
    }
}
