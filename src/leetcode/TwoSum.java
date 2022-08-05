package leetcode;


import java.util.*;

public class TwoSum {
    //brute force method: time complexity O(n^2),  space complexity n^2
    public static ArrayList<int[]> bruteForce(int[] nums, int target) {
        if(nums == null && nums.length < 2) return null;

        ArrayList<int[]> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if (nums[j] == target - nums[i]){
                    res.add(new int[]{i,j});
                }
            }
        }
        if (res.size() == 0) return null;
        else return res;
    }
    //----------------------------------------------------------------------
    //hash map method: time complexity worst case is O(n^2), average is O(n), space complexity
    public static Set<HashSet<Integer>> getTwoSum(int[] numbers, int targetSum) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])){
                map.get(numbers[i]).add(i);
            } else {
                map.put(numbers[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }

        HashSet<HashSet<Integer>> myresult = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            int c = targetSum - numbers[i];
            if (map.containsKey(c)) {
                for (int j = 0; j < map.get(c).size(); j++) {
                    HashSet<Integer> tempSet = new HashSet<>(Arrays.asList(i, map.get(c).get(j)));
                    if (tempSet.size() == 2){
                        myresult.add(tempSet);
                    }
                }
            }
        }
        return myresult;
    }

    public static void main(String[] args) {
        System.out.println("The solution using brute force method: ");
        for (int[] arr: bruteForce(new int[] {1,1,2,3}, 4)){
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("The solution using hashmap method: ");
        for (Set<Integer> solution : getTwoSum(new int[] {1,1,2,3}, 4)){
            System.out.println(Arrays.toString(solution.toArray()));
            }
        }
}
