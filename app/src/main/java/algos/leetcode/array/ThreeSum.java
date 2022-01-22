package algos.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public static void main(String []s){
        int [] nums = {-7,-1,0,1,1};//  {-1,0,1,1,1};//{-1,0,1,2,-1,-4};
        int k = 3;
        System.out.println("maxSubArrayLen "+threeSum(nums));
    }

    public  static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    static  void  twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }


    static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        HashSet seen = new HashSet<Integer>();
        for (int j = i + 1;  j < nums.length; ++j /*, System.out.println("  in foorlooop  >>>> i :"+i+" , j :"+j)*/) {

            System.out.println("  FFFirst libe i :"+i+" , j :"+j);
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]){
                    ++j;
//                    System.out.println("  whihlle >>>> i :"+i+" , j :"+j);
                }

            }
//            System.out.println("i :"+i+" , j :"+j);
            seen.add(nums[j]);
        }
    }
}
