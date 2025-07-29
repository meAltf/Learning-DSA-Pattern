package LLInPlaceReversal;

import static LLInPlaceReversal.ReverseLinkedList.createLinkedList;
import static LLInPlaceReversal.ReverseLinkedList.printLinkedList;

public class SwapNodesInPairs {

    private static ListNode swapNodes(ListNode head) {

        // 1. create a dummy node and make it's node to head
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // take a point to keep an eye for swap
        ListNode point = dummyNode;

        // 2. ensure the nodes we're swapping are not null
        while (point.next != null && point.next.next != null) {

            // 3. Identify nodes to swap
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            // 4. Actually swap here
            swap1.next = swap2.next;
            swap2.next = swap1;

            // 5. prepare for next swap
            // still point node pointing to swap1 so needs to join it with swap2
            point.next = swap2;
            point = swap1;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {

        int[] values = {1, 2, 3, 4, 5, 7};
        ListNode head = createLinkedList(values);
        System.out.println("Before reverse");
        printLinkedList(head);
        ListNode head2 = swapNodes(head);
        System.out.println("After reverse");
        printLinkedList(head2);

    }
}
