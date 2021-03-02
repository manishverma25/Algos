package algos.ds.linkedlist;

import android.widget.LinearLayout;

import algos.ds.node.Node;

public class SumUsingLinked {

    public static void main(String[] s) {

        LinkedList llist = new LinkedList();
        llist.push(7);
        llist.push(1);
//        llist.push(6);

        llist.printList();

        LinkedList list2 = new LinkedList();
        list2.push(5);
        list2.push(9);
        list2.push(2);

        list2.printList();

        System.out.println("after sum  linked list");

        LinkedList sumList = sum(llist,list2);
        sumList.printList();

    }


    public static LinkedList sum(LinkedList l1, LinkedList l2){

        LinkedList sumList = new LinkedList();

        Node n1= l1.head;
        Node n2= l2.head;
        int carry = 0;
        int result =0;
        int d1 = 0,d2 = 0;;
        while(n1 != null  || n2 != null ){  // &&  n1.next != null    && n2.next != null
            if (n1 != null) {
                d1 = n1.data;
            }else{
                d1=  0;
            }
            if (n2 != null) {
                d2 = n2.data;
            }else{
                d2 = 0;
            }

            result = (d1+d2+carry);
            if( result >= 10){
                carry = result/10;
                result = result % 10;
            }else{
                carry = 0;

            }

            if (n1 != null) {
                n1 = n1.next;
            }

            if (n2 != null) {
                n2 = n2.next;
            }

            sumList.push(result);
        }

        return sumList;

    }
}
