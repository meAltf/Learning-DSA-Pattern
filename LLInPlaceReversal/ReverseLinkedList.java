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
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        // remove one by one and move further
        temp = head;
        while(temp != null){
           temp.val = stack.pop();
           temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(values);
        ListNode head2 = reverseList(head);
        printLinkedList(head2);
    }
}
