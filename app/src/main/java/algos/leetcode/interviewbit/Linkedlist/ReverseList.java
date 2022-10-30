package algos.leetcode.interviewbit.Linkedlist;


import java.util.ArrayList;

public class ReverseList {
//    A : [ 8 -> 11 -> 4 -> 12 -> 0 ]
//    B : 1
    public static  void main(String s[]){

        ListNode head = createList(null, 1);
//         createList(head, 2);
//        createList(head, 3);
//        createList(head, 4);
//        createList(head, 5);
//        createList(head, 6);
//        createList(head, 7);
//        createList(head, 8);
        print(head);
        int b = 3;
//        head =  reverseList(head,b);
//        head =  reverseList(head,2,4);
//        head =  reverseBetween(head,1,5);
        head =  reverseList(head);
        System.out.println (" \n after reverse  ");
        print(head);

    }

    public static  ListNode reverseList(ListNode A) {
        ListNode currentNode = A;
        ListNode prevNode = null;
        ListNode nextNode = null;

        if(A == null)
            return A;
      while(currentNode != null){

          nextNode = currentNode.next;
          currentNode.next = prevNode;
          prevNode = currentNode;
          currentNode = nextNode;
      }

      A = prevNode;


        return A;
    }





    public static ListNode reverseBetween(ListNode A, int B,int C) {
        ListNode currentNode = A;
        ListNode prevNode = null;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode nextNode = null;
        if(A== null)
            return A;

        int counter = 1;
        while (counter <= B   && currentNode != null){

            if(counter == B){
                p1 = prevNode;
                p2 = currentNode;
            }
            prevNode = currentNode;
            currentNode =    currentNode.next ;
            counter++;
            if(counter == B){
                p1 = prevNode;
                p2 = currentNode;
            }

        }
        while (counter <= C   && currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            counter++;
        }
        if(p1 != null){
            p1.next =  prevNode;
        }else{
            A= prevNode;
        }

        if(p2 != null){
            p2.next =  currentNode;
        }

        return A;
    }

    public static ListNode reverseList(ListNode A, int B) {
        ListNode currentNode = A;
        ListNode prevNode = null;
        ListNode nextNode = null;

        int counter = 0;

        while (counter < B   && currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            counter++;
        }

        if(A != null){
            A.next = reverseList(nextNode ,B);
        }

        return prevNode;
    }



    public static  void   print(ListNode A) {
        ListNode t = A;
        while(t !=null){
            System.out.print(" "+(t.val)+"--> ");
            t =t.next;
        }

    }

    public static  ListNode createList(ListNode A, int B) {
        if(A==null){
            A = new ListNode(B);
        }else{
              ListNode t = A;
              while(t.next !=null){
                  t =t.next;
              }
            t.next = new ListNode(B);
        }
        return A;
    }








}




