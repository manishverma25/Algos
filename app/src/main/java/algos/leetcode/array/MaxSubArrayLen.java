package algos.leetcode.array;

import java.util.HashMap;

public class MaxSubArrayLen {


    public static void main(String []s){
       int [] nums = {1,-1,5,-2,3};
        int k = 3;
        System.out.println("maxSubArrayLen "+maxSubArrayLen(nums,k));
        System.out.println("maxSubArrayLen "+minOperations(nums,k));
    }

        public static int maxSubArrayLen(int[] nums, int k) {
            int prefixSum = 0;
            int longestSubarray = 0;
            HashMap<Integer, Integer> indices = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];

                // Check if all of the numbers seen so far sum to k.
                if (prefixSum == k) {
                    longestSubarray = i + 1;
                }

                // If any subarray seen so far sums to k, then
                // update the length of the longest_subarray.
                if (indices.containsKey(prefixSum - k)) {
                    longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
                }

                // Only add the current prefix_sum index pair to the
                // map if the prefix_sum is not already in the map.
                if (!indices.containsKey(prefixSum)) {
                    indices.put(prefixSum, i);
                }
            }

            return longestSubarray;
        }


        public static int minOperations(int[] nums, int x) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }
            int n = nums.length;
            int maxi = -1;
            int left = 0;
            int current = 0;

            for (int right = 0; right < n; right++) {
                // sum([left ,..., right]) = total - x
                current += nums[right];
                // if larger, move `left` to left
                while (current > total - x && left <= right) {
                    current -= nums[left];
                    left += 1;
                }
                // check if equal
                if (current == total - x) {
                    maxi = Math.max(maxi, right - left + 1);
                }
            }
            return maxi != -1 ? n - maxi : -1;
        }


}
