package algos.ds.linkedlist;

import algos.ds.node.Node;

public class RemoveDuplicateNode {
    public static void main(String[] s) {

        LinkedList llist = new LinkedList();


        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(5);

        llist.printList();
        removeDuplicate(llist.head);
        System.out.println("after remove duplicate linked list");
        llist.printList();

    }


    public static void removeDuplicate(Node head) {
        Node current = head;
        Node nextNode, iterationNode;
        if (current == null)
            return;
        while (current.next != null) {
            nextNode = current.next;
            iterationNode = current;

            while (nextNode != null) {
                while (nextNode != null && nextNode.data == current.data) {
                    nextNode = nextNode.next;
                }
                if (iterationNode.next != nextNode) {
                    iterationNode.next = nextNode;
                }
                iterationNode = nextNode;
                nextNode = nextNode.next;
            }
            current = current.next;
        }

    }
}
