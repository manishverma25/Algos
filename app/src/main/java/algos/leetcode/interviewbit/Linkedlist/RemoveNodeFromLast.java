package algos.leetcode.interviewbit.Linkedlist;

import static algos.leetcode.interviewbit.Linkedlist.ReverseList.createList;
import static algos.leetcode.interviewbit.Linkedlist.ReverseList.print;
import static algos.leetcode.interviewbit.Linkedlist.ReverseList.reverseBetween;

public class RemoveNodeFromLast {
    public static  void main(String s[]){

        ListNode head = createList(null, 43);
//        createList(head, 2);
//        createList(head, 3);
//        createList(head, 4);
//        createList(head, 5);
//        createList(head, 6);
//        createList(head, 7);

//
//        createList(head, 1);
//        createList(head, 1);
//        createList(head, 2);
//        createList(head, 3);
//        createList(head, 3);
//        createList(head, 3);
//        createList(head, 3);
//        createList(head, 5);

        print(head);
        int b = 3;
        head =  solve(head);
//        head =  deleteDuplicates(head);
        System.out.println (" \n after deleteDuplicates  ");
        print(head);

    }


    public static ListNode solve(ListNode A) {

        ListNode current = A;
        ListNode prev = null;
        if (A== null || A.next == null)
            return  null;

        int element = middleElement(A);

        while (current != null && current.val != element)
        {
            prev =current;
            current = current.next;
        }

        prev.next = current.next;
        return  A;
    }

    public  static int middleElement(ListNode A) {
        if (A.next == null)
            return A.val;
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }



    public static ListNode deleteDuplicates(ListNode A) {
        if(A==null)
            return A;
        ListNode current = A;
        ListNode checkDuplicateIteratipon ;
        ListNode prev = null;
        boolean foundRepeated =false;

        while(current!=null  ){
            checkDuplicateIteratipon = current;

            while( checkDuplicateIteratipon.next != null && checkDuplicateIteratipon.val == checkDuplicateIteratipon.next.val ){
                // remove duplicate
                foundRepeated = true;
                checkDuplicateIteratipon = checkDuplicateIteratipon.next;

            }//  2
            if(foundRepeated){
                foundRepeated =false;
                current.next = checkDuplicateIteratipon.next;
            }
            prev = current;
            current =    current.next;
        }


        return A;
    }


    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null)
            return A;
        ListNode current = A;
        ListNode prev = null;
        int counter = 0;

        while(current!=null  ){
            counter++;
            current =    current.next;
        }
        int posFormFront = counter -B+1;
        current = A;
        counter = 1;

        while(current!=null && counter < posFormFront){
            prev = current;
            current =    current.next;
            counter++;
        }

        if(prev == null){
            A=  current.next;
        }else{
            prev.next = current.next;
        }

        return A;
    }
}
