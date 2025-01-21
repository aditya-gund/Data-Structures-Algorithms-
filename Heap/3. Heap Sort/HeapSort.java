import java.util.Arrays;

public class HeapSort {

    // Heapify function to maintain the heap property
    public static void heapify(int[] nums, int n, int i) {
        // Initialize the largest element as root
        int largest_element = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if the left child exists and is larger than the root
        if (left < n && nums[left] > nums[largest_element]) {
            largest_element = left;
        }

        // Check if the right child exists and is larger than the largest so far
        if (right < n && nums[right] > nums[largest_element]) {
            largest_element = right;
        }

        // If the largest is not the root
        if (largest_element != i) {
            swap(nums, i, largest_element); // Swap root with largest
            heapify(nums, n, largest_element); // Recursively heapify the affected subtree
        }
    }

    // Utility function to swap two elements in the array
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Heap Sort
    public static void heapSort(int[] nums) {
        int n = nums.length;

        // Rearrange the array to build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i); // Move the current root (largest element) to the end
            heapify(nums, i, 0); // Call heapify on the reduced heap
        }
    }

    // Utility function to print the array
    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the sorting algorithm
    public static void main(String[] args) {
        int[] nums = {9, 4, 3, 8, 10, 2, 5};
        System.out.println("Before Sorting:");
        printArray(nums);

        heapSort(nums);

        System.out.println("After Sorting:");
        printArray(nums);
    }
}
