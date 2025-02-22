package addtwonumbers;

class JavaSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = null;
        ListNode currentNode = null;
        boolean carryOver = false;
        ListNode currentL1Node = l1;
        ListNode currentL2Node = l2;

        do {
            int currentSum = 0;
            if (currentL1Node != null) {
                currentSum += currentL1Node.value;
            }
            if (currentL2Node != null) {
                currentSum += currentL2Node.value;
            }
            if (carryOver) {
                currentSum++;
            }
            if (currentSum > 9) {
                currentSum -= 10;
                carryOver = true;
            } else {
                carryOver = false;
            }
            if (sumNode == null) {
                sumNode = new ListNode(currentSum);
                currentNode = sumNode;
            } else {
                ListNode node = new ListNode(currentSum);
                currentNode.next = node;
                currentNode = node;
            }
            currentL1Node = (currentL1Node != null) ? currentL1Node.next : null;
            currentL2Node = (currentL2Node != null) ? currentL2Node.next : null;
        } while (currentL1Node != null || currentL2Node != null);
        if (carryOver) {
            ListNode node = new ListNode(1);
            currentNode.next = node;
            currentNode = node;
        }
        return sumNode;
    }

    public static void main(String[] args) {
        JavaSolution solution = new JavaSolution();

        // Test case 1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        System.out.println("Test Case 1: " + result1); // Output: 7 -> 0 -> 8

        // Test case 2
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        ListNode result2 = solution.addTwoNumbers(l1, l2);
        System.out.println("Test Case 2: " + result2); // Output: 0

        // Test case 3
        l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode result3 = solution.addTwoNumbers(l1, l2);
        System.out.println("Test Case 3: " + result3); // Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
    }
}