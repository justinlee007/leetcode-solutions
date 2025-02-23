package reverseinteger;

public class JavaSolution {
    public int reverse(int x) {
        StringBuilder builder = new StringBuilder();
        String value = String.valueOf(x);
        if (value.charAt(0) == '-') {
            builder.append('-');
        }
        for (int i = value.length() - 1; i >= 0; i--) {
            char ch = value.charAt(i);
            if (ch != '-') {
                builder.append(ch);
            }
        }
        int reversed;
        try {
            reversed = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            reversed = 0;
        }
        return reversed;
    }

    public static void main(String[] args) {
        JavaSolution solution = new JavaSolution();

        // Test case 1: Positive number
        int num1 = 123;
        int reversed1 = solution.reverse(num1);
        System.out.println("Test Case 1: Original = " + num1 + ", Reversed = " + reversed1); // Output: 321

        // Test case 2: Negative number
        int num2 = -123;
        int reversed2 = solution.reverse(num2);
        System.out.println("Test Case 2: Original = " + num2 + ", Reversed = " + reversed2); // Output: -321

        // Test case 3: Number ending with zero
        int num3 = 120;
        int reversed3 = solution.reverse(num3);
        System.out.println("Test Case 3: Original = " + num3 + ", Reversed = " + reversed3); // Output: 21

        // Test case 4: Zero
        int num4 = 0;
        int reversed4 = solution.reverse(num4);
        System.out.println("Test Case 4: Original = " + num4 + ", Reversed = " + reversed4); // Output: 0

        // Test case 5: Large number that might cause overflow
        int num5 = 1534236469;
        int reversed5 = solution.reverse(num5);
        System.out.println("Test Case 5: Original = " + num5 + ", Reversed = " + reversed5); // Output: 0 (due to overflow)
    }
}
