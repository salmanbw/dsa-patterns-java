package week3linkedlist;

public class ReverseLinkedList {

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

        printLinkedList(reverseLinkedList(a));
    }

    public static void printLinkedList(LLNode node){
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
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
}
