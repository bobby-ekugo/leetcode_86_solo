import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode();
        ListNode afterDummy = new ListNode();
        ListNode beforeTail = beforeDummy;
        ListNode afterTail = afterDummy;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                beforeTail.next = current;
                beforeTail = current;
            } else {
                afterTail.next = current;
                afterTail = current;
            }
            current = current.next;
        }

        afterTail.next = null;
        beforeTail.next = afterDummy.next;
        return beforeDummy.next;
    }
}

public class Main {
    static void runPartition(int[] values, int x) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        ListNode result = new PartitionList().partition(dummy.next, x);

        StringBuilder output = new StringBuilder();
        for (ListNode current = result; current != null; current = current.next) {
            output.append(current.val).append(' ');
        }
        System.out.println(Arrays.toString(values) + " x=" + x + " -> " + output);
    }

    public static void main(String[] args) {
        runPartition(new int[]{1, 4, 3, 2, 5, 2}, 3);
        runPartition(new int[]{2, 1}, 2);
    }
}