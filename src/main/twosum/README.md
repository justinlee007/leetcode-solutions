# Two Sum

**Problem:** [Link to the LeetCode problem](https://leetcode.com/problems/two-sum/)

**Solution:**

This Java solution uses a pointer to iterate through the array.

**Time Complexity:** O(n^2)

**Space Complexity:** O(1)

**Code:**

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalStateException("nums is null or two small");
        }
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int pointer = (i + 1);
            int firstValue = nums[i];
            for (int j = pointer; j < nums.length; j++) {
                int secondValue = nums[j];
                if ((firstValue + secondValue) == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}