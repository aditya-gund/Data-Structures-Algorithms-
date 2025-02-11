import java.util.*;


/*   Given n activities from 1 to N find out maximum activities you can attend.
 *  Activities: [(1,3),(2,5),(3,9),(6,8),(5,7),(8,9)]
 * Max Output: 3
 *  Selected Activities: [(1,3),(5,7),(8,9)]
 */
public class ActivitySelection{
    public static int maxActivities(int[] start, int[] end){
        int n=start.length;
        int[][] activities = new int[n][2];
        //Step1: Store actvities in 2D array
        for(int i=0;i<n;i++){
            activities[i][0]=start[i];
            activities[i][1]=end[i];
        }
        // Step 2: Sort activities based on there end time
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 3: select activities
        int count=1; // First activity is always selected
        int lastEndTime = activities[0][1]; // track the last activity end time
        for(int i=1;i<n;i++){
            if(activities[i][0]>=lastEndTime){ // Non overlapping condition
                count++;
                lastEndTime=activities[i][1]; // Update last end time

            }
        }
        return count;
        
    }
    public static void main(String[] args) {
        int[] start = {1, 2, 3, 6, 5, 8}; 
        int[] end   = {3, 5, 9, 8, 7, 9};  // This matches the problem statement
    
        System.out.println("Maximum activities that can be performed: " + maxActivities(start, end));
    }
}