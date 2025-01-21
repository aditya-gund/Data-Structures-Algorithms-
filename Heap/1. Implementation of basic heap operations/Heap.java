import java.util.*;

class Heap {
    private int[] heapArray;
    private int capacity;
    private int curr_size;

    public Heap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        curr_size = 0;
    }

    private void swap(int[] nums, int array_element1, int array_element2) {
        int temp = nums[array_element1];
        nums[array_element1] = nums[array_element2];
        nums[array_element2] = temp;
    }

    private int parent(int key) {
        return (key - 1) / 2;
    }

    private int leftChild(int key) {
        return 2 * key + 1;
    }

    private int rightChild(int key) {
        return 2 * key + 2;
    }

    public boolean insertKey(int key) {
        if (curr_size == capacity) {
            return false;
        }
        int index = curr_size;
        heapArray[index] = key;
        curr_size++;

        while (index != 0 && heapArray[index] < heapArray[parent(index)]) {
            swap(heapArray, index, parent(index));
            index = parent(index);
        }
        return true;
    }

    public void decreaseKey(int key, int new_val) {
        if (key < 0 || key >= curr_size) {
            throw new IllegalArgumentException("Invalid key index");
        }

        heapArray[key] = new_val;
        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }

    public int getMin() {
        if (curr_size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heapArray[0];
    }

    public int extractMin() {
        if (curr_size <= 0) {
            return Integer.MAX_VALUE;
        }
        if (curr_size == 1) {
            curr_size--;
            return heapArray[0];
        }

        int root = heapArray[0];
        heapArray[0] = heapArray[curr_size - 1];
        curr_size--;
        minHeapify(0);
        return root;
    }

    public void deleteKey(int key) {
        if (key < 0 || key >= curr_size) {
            throw new IllegalArgumentException("Invalid key index");
        }

        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    private void minHeapify(int key) {
        int left = leftChild(key);
        int right = rightChild(key);
        int smallest = key;

        if (left < curr_size && heapArray[left] < heapArray[smallest]) {
            smallest = left;
        }
        if (right < curr_size && heapArray[right] < heapArray[smallest]) {
            smallest = right;
        }
        if (smallest != key) {
            swap(heapArray, key, smallest);
            minHeapify(smallest);
        }
    }

    public void increaseKey(int key, int new_val) {
        if (key < 0 || key >= curr_size) {
            throw new IllegalArgumentException("Invalid key index");
        }

        heapArray[key] = new_val;

        // Ensure downward heap property
        minHeapify(key);
    }

    public void changeValueOnKey(int key, int new_val) {
        if (key < 0 || key >= curr_size) {
            throw new IllegalArgumentException("Invalid key index");
        }

        if (heapArray[key] == new_val) {
            return;
        }
        if (heapArray[key] < new_val) {
            increaseKey(key, new_val);
        } else {
            decreaseKey(key, new_val);
        }
    }

    public static void main(String[] args) {
        Heap minHeap = new Heap(10);
        minHeap.insertKey(3);
        minHeap.insertKey(2);
        minHeap.deleteKey(1);
        minHeap.insertKey(15);
        minHeap.insertKey(5);
        minHeap.insertKey(4);
        minHeap.insertKey(45);
        System.out.println("Extract Min: " + minHeap.extractMin());
        System.out.println("Get Min: " + minHeap.getMin());
        minHeap.decreaseKey(2, 1);
        System.out.println("Get Min after decreasing key: " + minHeap.getMin());
    }
}
