package twosum;

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

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test Case 1: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 1]

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 2]

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3: [" + result3[0] + ", " + result3[1] + "]"); // Output: [0, 1]

        // Test case 4 (Example of an exception)
        try {
            int[] nums4 = null;  // Or an array with only one element
            int target4 = 6;
            int[] result4 = solution.twoSum(nums4, target4);
            System.out.println("Test Case 4: [" + result4[0] + ", " + result4[1] + "]"); // This will not execute
        } catch (IllegalStateException e) {
            System.out.println("Test Case 4: Exception caught: " + e.getMessage()); // Output: Exception caught: nums is null or two small
        }

        // Test case 5 (No solution):
        int[] nums5 = {1, 2, 3};
        int target5 = 7;
        try {
            int[] result5 = solution.twoSum(nums5, target5);
            System.out.println("Test Case 5: [" + result5[0] + ", " + result5[1] + "]"); // This will not execute
        } catch (Exception e) {
            System.out.println("Test Case 5: Exception caught: " + e.getMessage()); // Likely IllegalArgumentException
        }
    }
}