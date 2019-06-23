package algos.linkedlist;

public class LinkedList {
    Node head;
    Node insertionPoint;

    public void push(int new_data)
    {
        Node new_node = new Node(new_data);

        if(head == null){
            head = new_node;
        }else {
            insertionPoint.next  = new_node;
        }
        insertionPoint = new_node;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(">>> end");
    }

    public void pushold(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
}