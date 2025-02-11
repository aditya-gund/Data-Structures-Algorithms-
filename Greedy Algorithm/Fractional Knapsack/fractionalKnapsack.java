import java.util.*;


public class fractionalKnapsack{
    public static double getMaxValue(Item[] items, int capacity){
        // Step 1: Sort items based on value/weight ratio in decending order
        Arrays.sort(items, (a,b)-> Double.compare((double) b.value/b.weight,( double)a.value/a.weight));
        double maxValue=0.0;
        int remCapacity=capacity;
        // Step 2: Select Capacity
        for(Item item: items){
            if(remCapacity==0) break;
            if(item.weight<=remCapacity){
                // Take the whole item
                maxValue+=item.value;
                remCapacity-=item.weight;
            }else{
                // Take fractional part
                maxValue += (double) item.value*remCapacity/item.weight;
                remCapacity=0; // Knapsack is full
            }
        }
        return maxValue;
    }
    public static void main(String[] args) {
        // Sample input
        Item[] items = {
            new Item(10, 60), 
            new Item(20, 100), 
            new Item(30, 120)
        };
        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}
