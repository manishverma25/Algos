package algos.leetcode.interviewbit.Linkedlist;

import static algos.leetcode.interviewbit.Linkedlist.ReverseList.createList;
import static algos.leetcode.interviewbit.Linkedlist.ReverseList.print;

public class findMiddle {


    public static  void main(String s[]) {

        ListNode head = createList(null, 1);
        createList(head, 2);
        createList(head, 3);
        createList(head, 4);
        createList(head, 5);
        createList(head, 6);

       int r =  solve(head);

//        System.out.print(" "+(t.val)+"--> ");
//        createList(head, 6);
//        createList(head, 7);
//        createList(head, 8);


//        ListNode head = createList(null, 8);
//        createList(head, 11);
//        createList(head, 4);
//        createList(head, 12);
//        createList(head, 0);

        print(head);
    }

    public static  int solve(ListNode A) {
        if (A.next == null)
            return A.val;
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if(fast != null )
            System.out.println(" fast.val "+(fast.val)+"--> ");
            System.out.println("slow val  "+(slow.val)+"--> ");

        }
        System.out.println(" \n  RRRr slow val  "+(slow.val)+"--> ");

        return slow.val;
    }
}
