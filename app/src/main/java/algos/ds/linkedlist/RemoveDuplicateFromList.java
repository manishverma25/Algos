package algos.ds.linkedlist;

import algos.ds.node.Node;

public class RemoveDuplicateFromList {

    public static void main(String[] s) {

        LinkedList llist = new LinkedList();

        llist.push(1);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(3);
        llist.push(4);
        llist.push(4);
        llist.push(5);
//        llist.push(6);

        llist.printList();
        System.out.println(" \n after swaping pair wise");
        removeDuplicateNodes(llist);
        llist.printList();


    }


    // my approach
    private static void removeDuplicateNodes(LinkedList llist) {

        Node current = llist.head,
                nextNode = null,
                prevNode = null;
        Node startingNodeOfDuplicacy = null, endNodeOfDuplicacy;

        boolean isfoundduplicate = false;

        while (current != null) {

            nextNode = current.next;


            if (nextNode != null) {
                if (current.data == nextNode.data) {

                    while (current.data == nextNode.data) {

                        current = current.next;
                        nextNode = nextNode.next;
                        isfoundduplicate = true;
                    }
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    } else {
                        //todo check it
                        llist.head = nextNode;
                    }

                }
            }

            if (isfoundduplicate) {
                isfoundduplicate = false;
            } else {
                prevNode = current;
            }
            current = nextNode;

        }

    }



    // standard approach

    public Node deleteDuplicates(Node head) {
        if (head == null)
            return null;
        Node FakeHead = new Node(0);
        FakeHead.next = head;
        Node pre = FakeHead;
        Node cur = head;
        while (cur != null) {
            while (cur.next != null
                    && cur.data == cur.next.data) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return FakeHead.next;
    }
}
