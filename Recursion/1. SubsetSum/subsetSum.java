import java.util.*;
 public class subsetSum{
    public static List<Integer> subsetSum(int[] nums){
        List<Integer> ans = new ArrayList<>();
        subsetSumRecursive(nums,0,0,ans);
        Collections.sort(ans);
        return ans;
    }
    // Recursive funtion
    private static void subsetSumRecursive(int[] arr, int index, int sum,List<Integer> ans){
        // Base condition
        if(index==arr.length){
            ans.add(sum);
            return;
        }
        // Include the sum in an array
        subsetSumRecursive(arr, index+1, sum+arr[index], ans);
        // Exclude the sum from the array
        subsetSumRecursive(arr, index+1, sum, ans);
    }
    public static void main(String[] args){
        subsetSum sol = new subsetSum();
        int[] arr = {1, 2, 3};
        ArrayList<Integer> result = (ArrayList<Integer>) subsetSum.subsetSum(arr);
        System.out.println(result); 
    }
 }