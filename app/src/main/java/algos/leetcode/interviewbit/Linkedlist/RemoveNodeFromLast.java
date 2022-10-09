package algos.leetcode.interviewbit.Linkedlist;

import static algos.leetcode.interviewbit.Linkedlist.ReverseList.createList;
import static algos.leetcode.interviewbit.Linkedlist.ReverseList.print;
import static algos.leetcode.interviewbit.Linkedlist.ReverseList.reverseBetween;

public class RemoveNodeFromLast {
    public static  void main(String s[]){

        ListNode head = createList(null, 1);
        createList(head, 2);
        createList(head, 3);
        createList(head, 4);
        createList(head, 5);
//        createList(head, 6);
//        createList(head, 7);
//        createList(head, 8);
        print(head);
        int b = 3;
//        head =  reverseList(head,b);
//        head =  reverseList(head,2,4);
        head =  reverseBetween(head,1,5);
        System.out.println (" \n after reverse  ");
        print(head);

    }
}
