class Test {
    // Functional Code
    public static int maxSubarray(int[] nums) {
        int n = nums.length; // Length of the input array
        int maximum_product = Integer.MIN_VALUE; // To store the maximum product
        int prefix_product = 1; // Tracks the product from the start
        int suffix_product = 1; // Tracks the product from the end
        
        for (int itr = 0; itr < n; itr++) {
            // If prefix_product becomes 0, reset to 1
            if (prefix_product == 0) prefix_product = 1;
            // If suffix_product becomes 0, reset to 1
            if (suffix_product == 0) suffix_product = 1;

            // Calculate prefix product
            prefix_product *= nums[itr];
            // Calculate suffix product
            suffix_product *= nums[n - itr - 1];

            // Update maximum product by considering both prefix and suffix products
            maximum_product = Math.max(maximum_product, Math.max(prefix_product, suffix_product));
        }
        
        return maximum_product;
    }

    public static void main(String[] args) {
        // Test the function with different cases
        int[] testArray1 = {2, 3, -2, 4}; // Example 1
        int[] testArray2 = {-2, 0, -1};   // Example 2
        int[] testArray3 = {-1, -3, -10, 0, 60}; // Edge case with negative numbers
        int[] testArray4 = {-2, 3, 0, 4, -1, 2}; // Mixed case
        
        System.out.println("Maximum Product Subarray:");
        System.out.println("Test Case 1: " + maxSubarray(testArray1)); // Expected: 6
        System.out.println("Test Case 2: " + maxSubarray(testArray2)); // Expected: 0
        System.out.println("Test Case 3: " + maxSubarray(testArray3)); // Expected: 60
        System.out.println("Test Case 4: " + maxSubarray(testArray4)); // Expected: 6
    }
}
