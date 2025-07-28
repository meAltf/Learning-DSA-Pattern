package LLInPlaceReversal;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class ReverseLinkedList {

    // Helper method to convert array to linked list
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        // put into stack
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        // remove one by one and move further
        temp = head;
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    // Way-2 | using ListNode directly instead of listNode.val
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // newHead -> firstNode of stack now.
        // currentNode -> to move the node every iteration
        ListNode newHead = stack.peek();
        ListNode current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        // do not forget to mark last node to null
        current.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(values);
        System.out.println("Before reverse");
        printLinkedList(head);
        ListNode head2 = reverseList(head);
        System.out.println("After reverse");
        printLinkedList(head2);
    }
}
