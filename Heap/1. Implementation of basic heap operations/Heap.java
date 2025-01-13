import java.util.*;
class Heap{
    //Stores array elements in heap
    private int[] heapArray;
    //Maximum size of the Heap
    private int capacity;
    //Current number of elements in Heap
    private int curr_size;

    //Constructor
    public Heap(int n){
        capacity=n;
        heapArray = new int[capacity];
        curr_size=0;
    }
    // Swapping the heapArray Elements
    private void swap(int[]nums, int array_element1, int array_element2){
        int temp=nums[array_element1];
        nums[array_element1]=nums[array_element2];
        nums[array_element2]=temp;
    }
    // To find the parent index of the given index
    private int parent(int key){
        return (key-1)/2;
    }
    //To find the left child of the given index
    private int leftChild(int key){
        return 2*key+1;
    }
    private int rightChild(int key){
        return 2*key+2;
    }
    //Insert new elements
    public boolean insertKey(int key){
        if(curr_size==capacity){
            //Heap has not a space
            return false;
        }
        // To insert new key at the end
        int index=curr_size;
        heapArray[index]=key;
        curr_size++;
        // Fix the minHeap property if it is not satifying the condition of the minHeap Property
        while (index!=0 && heapArray[index]< heapArray[parent(index)]) {
            swap(heapArray, index, parent(index));
            index=parent(index);
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("Hello World!");
    }
}