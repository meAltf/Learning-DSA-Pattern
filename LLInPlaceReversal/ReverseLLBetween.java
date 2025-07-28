package LLInPlaceReversal;

import static LLInPlaceReversal.ReverseLinkedList.createLinkedList;
import static LLInPlaceReversal.ReverseLinkedList.printLinkedList;

public class ReverseLLBetween {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        // 1. create a Dummy node and mark to the head of LL
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // 2. make markers for currNode and the node before reversing
        ListNode leftPrevNode = dummyNode;
        ListNode currNode = head;

        // 3. Reach till start of reversing
        for (int i = 1; i < left; i++) {
            leftPrevNode = leftPrevNode.next;
            currNode = currNode.next;
        }

        // 4. marker to nde where we're starting the reversing
        ListNode subListNode = currNode;

        // 5. reverse as usual
        ListNode prevNode = null;
        for (int i = 1; i <= right - left + 1; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        // 6. join the starting & ending piece of LL
        leftPrevNode.next = prevNode;
        subListNode.next = currNode;

        // 7. return the head means dummy.next
        return dummyNode.next;
    }

    public static void main(String[] args) {

        int[] values = {4, 8, 15, 16, 23, 42};
        ListNode head = createLinkedList(values);
        System.out.println("Before reverse");
        printLinkedList(head);
        ListNode head2 = reverseBetween(head, 3, 5);
        System.out.println("After reverse");
        printLinkedList(head2);
    }

}
