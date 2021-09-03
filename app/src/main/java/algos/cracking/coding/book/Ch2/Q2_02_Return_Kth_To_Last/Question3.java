package algos.cracking.coding.book.Ch2.Q2_02_Return_Kth_To_Last;


import algos.cracking.coding.book.CtCILibrary.AssortedMethods;
import algos.cracking.coding.book.CtCILibrary.LinkedListNode;

public class Question3 {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}

}
