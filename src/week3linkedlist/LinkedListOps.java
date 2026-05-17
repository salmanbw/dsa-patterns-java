package week3linkedlist;

public class LinkedListOps {

    public static void main(String[] args) {
        System.out.println("LinkedList Ops");
        LLNode a = new LLNode(1);
        LLNode b = new LLNode(2);
        LLNode c = new LLNode(3);
        LLNode d = new LLNode(4);
        LLNode e = new LLNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        printLinkedList(a);
        System.out.println();
        System.out.println(findMiddleLinkedList(a));
        //Node nthNode = removeNthNodeFromEnd(a,5);
        //printLinkedList(nthNode);
        System.out.println();
        printLinkedList(reverseLinkedList(a));

    }

    public static void printLinkedList(LLNode node){
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static LLNode reverseLinkedList(LLNode node){

        LLNode prev = null;
        LLNode curr = node;
        LLNode temp = null;

        if(node == null || node.next == null)
            return node;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    public static int findMiddleLinkedList(LLNode node){

        LLNode fast = node;
        LLNode slow = node;

        while(fast.next !=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static LLNode removeNthNodeFromEnd(LLNode node, int n){

        LLNode fast = node;
        LLNode slow = node;

        for (int i = 0;i<n;i++) {

            if(fast == null)
                return node;

            fast = fast.next;
        }

        if(fast == null)
            return slow.next;

        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return node;

    }

}
