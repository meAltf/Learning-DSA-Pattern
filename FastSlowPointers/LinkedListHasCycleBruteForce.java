package FastSlowPointers;

import java.util.HashSet;
import java.util.Set;


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class LinkedListHasCycleBruteForce {
    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        Set<ListNode> visited = new HashSet<>();

        while (node != null) {
            if (visited.contains(node)) return true;
            visited.add(node);
            node = node.next;
        }
        return false;
    }
}
