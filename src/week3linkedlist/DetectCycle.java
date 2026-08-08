package week3linkedlist;

public class DetectCycle {
    public static void main(String[] args) {

        System.out.println("LinkedList Ops");
        LLNode a = new LLNode(1);
        LLNode b = new LLNode(2);
        LLNode c = new LLNode(3);
        LLNode d = new LLNode(4);
        LLNode e = new LLNode(5);

        a.next = a;
        b.next = a;
        c.next = d;
        d.next = e;

        LinkedListOps ops = new LinkedListOps();
        //ops.printLinkedList(a);
        System.out.println();
        System.out.println(detectCycle(a));
        System.out.println(startingPointCycle(a).data);

    }

    public static boolean detectCycle(LLNode node){

        if(node == null || node.next == null)
            return false;

        LLNode slow = node;
        LLNode fast = node;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    public static LLNode startingPointCycle(LLNode head) {

        if (head == null || head.next == null)
            return null;

        LLNode fast = head;
        LLNode slow = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                LLNode meet = head;

                while (slow != meet) {
                    slow = slow.next;
                    meet = meet.next;
                }

                return meet;
            }
        }
        return null;
    }
}
