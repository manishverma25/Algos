package algos.ds.linkedlist;

import algos.ds.node.Node;

public class ReverseLinkedList {

    public static void main(String[] s) {

        LinkedList llist = new LinkedList();


        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        llist.push(6);

        llist.printList();
        System.out.println("Reversing linked list");
//        reverseLinkedList(llist);
       llist.head =  reverse(llist.head)   ;
        llist.printList();

    }

    public static void reverseLinkedList(LinkedList llist) {

        Node current, next = null, tempHead = null;
        current = llist.head;
        Node second;
        second = current.next;


        while (current != null) {
            if (tempHead == null) {
                tempHead = current;
            }
            if (second != null) {
                next = second.next;
                second.next = current;
            } else {
                llist.head = current;
            }
            current = second;
            second = next;
        }
        if (tempHead != null)
            tempHead.next = null;


    }


   static Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        ;
        return node;
    }

}
