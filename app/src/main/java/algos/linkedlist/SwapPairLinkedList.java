package algos.linkedlist;

public class SwapPairLinkedList {

    public static void main(String[] s) {

        LinkedList llist = new LinkedList();


        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
//        llist.push(6);

        llist.printList();
        System.out.println(" \n after swaping pair wise");
        swapPairList(llist);

        llist.printList();


    }


    public static void swapPairList(LinkedList llist) {

        Node tempNewHead = null;
        if (llist.head != null) {
            Node node = llist.head;
            Node previousLeft = null;
            while (node != null && node.next != null) {

                Node t1 = node;
                Node t2 = node.next;
                if (tempNewHead == null) {
                    tempNewHead = t1.next;
                }
                node = t2.next;
                if (t2.next == null) {
                    t1.next = null;
                }
                t2.next = t1;
                if (previousLeft != null) {
                    previousLeft.next = t2;
                }
                previousLeft = t1;
            }

            if (node != null) {
                previousLeft.next = node;
            }
        }
        llist.head = tempNewHead;

    }


}


