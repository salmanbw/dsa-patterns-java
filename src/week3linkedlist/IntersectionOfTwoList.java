package week3linkedlist;

public class IntersectionOfTwoList {
    public static void main(String[] args) {

        LLNode a = new LLNode(1);
        LLNode b = new LLNode(2);
        LLNode c = new LLNode(3);
        LLNode d = new LLNode(4);
        LLNode e = new LLNode(5);

        LLNode f = new LLNode(3);
        LLNode g = new LLNode(6);
        LLNode h = new LLNode(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        f.next = g;
        g.next = d;

        LinkedListOps ops = new LinkedListOps();
        ops.printLinkedList(a);
        ops.printLinkedList(f);
        System.out.println(intersectionPoint(a,a).data);
    }


    public static LLNode intersectionPoint(LLNode head1, LLNode head2){

        int count1 = 1;
        int count2 = 1;

        LLNode temp1 = head1;
        LLNode temp2 = head2;

        while(temp1.next != null){
            temp1 = temp1.next;
            count1++;
        }

        while(temp2.next != null){
            temp2 = temp2.next;
            count2++;
        }

        System.out.println(count1 + " "+count2 );

        if(count1 > count2){
            for(int i =0;i< count1 - count2;i++)
                head1 = head1.next;
        }else{
            for(int i =0;i< count2 - count1;i++)
                head2 = head2.next;
        }

        System.out.println(head1.data);
        System.out.println(head2.data);

        while(head1 != null && head2 != null){
            if(head1 == head2)
                return head1;
            else{
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        return new LLNode(-1);
    }
}
