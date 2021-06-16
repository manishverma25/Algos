package algos.cracking.coding.book.Ch2.Q2_01_Remove_Dups;
import algos.cracking.coding.book.CtCILibrary.LinkedListNode;

public class QuestionB {
	public static void deleteDups(LinkedListNode head) {
		LinkedListNode current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current;
			while (runner.next != null) { 
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}	
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(1, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		int data []= new int [] {1,2,1,1,2,5,1,7};
		for (int i = 1; i < 8; i++) {
//			second = new LinkedListNode(i % 2, null, null);
			second = new LinkedListNode(data[i], null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
//		deleteDups(head);

		deleteDupsNew(head);
		System.out.println(head.printForward());
	}

	public static void deleteDupsNew(LinkedListNode head) {
		LinkedListNode current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current.next;
			while (runner != null) {
				if (runner.data == current.data) {
					LinkedListNode temp= runner.next;
					runner.prev.next = temp;
					if(temp != null){
						temp.prev = runner.prev;
					}

				}
				runner = runner.next;
			}
			current = current.next;
		}
	}
}
