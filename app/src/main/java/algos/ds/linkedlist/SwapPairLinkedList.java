package algos.ds.linkedlist;

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
            Node previousIterationLeftNode = null;
            while (node != null && node.next != null) {

                Node firstNode = node;
                Node secondNode = node.next;
                if (tempNewHead == null) {
                    tempNewHead = firstNode.next;
                }
                node = secondNode.next;
                if (secondNode.next == null) {
                    firstNode.next = null;
                }
                secondNode.next = firstNode;
                if (previousIterationLeftNode != null) {
                    previousIterationLeftNode.next = secondNode;
                }
                previousIterationLeftNode = firstNode;
            }

            if (node != null) {
                previousIterationLeftNode.next = node;
            }
        }
        llist.head = tempNewHead;

    }


}


