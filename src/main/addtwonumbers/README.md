# Add Two Numbers

**Problem:** [Link to the LeetCode problem](https://leetcode.com/problems/add-two-numbers/) 

Given two non-empty linked lists representing two non-negative integers, add the two numbers and return the sum as a linked list. The digits are stored in reverse order, and each of their nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Solution:** This Java solution iterates through both linked lists, adding corresponding digits and managing carry-over values. The result is stored in a new linked list.

**Time Complexity:** O(n), where n is the length of the longer linked list.

**Space Complexity:** O(n), for the output linked list.

**Code:**

```java
package addtwonumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = null;
        ListNode currentNode = null;
        boolean carryOver = false;
        ListNode currentL1Node = l1;
        ListNode currentL2Node = l2;

        do {
            int currentSum = 0;
            if (currentL1Node != null) {
                currentSum += currentL1Node.val;
            }
            if (currentL2Node != null) {
                currentSum += currentL2Node.val;
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
}