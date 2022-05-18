package algos.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sum4 {

    public static void main (String s[]){
        int []arr =  {-2,-1,-1,1,1,2,2}; //{1,2,3,4,5,5,5};    /[[-2,-1,1,2],[-1,-1,1,1]]
        int target = 0;
        System.out.println("fourSum  "+fourSum(arr,target));

    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        System.out.println(" >>>> target : "+target +", start  :  "+start +" ,k : "+k);
        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }
        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        int average_value = target / k;
        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                System.out.println("called for target :  "+(target - nums[i])+ " nums[i] : "+nums[i]+    "  , start : "+(i + 1)   + ", k : "+(k - 1));
                List<List<Integer>> subProblemList =     kSum(nums, target - nums[i], i + 1, k - 1);
                if(subProblemList.size() > 0){
                    System.out.println("FOURSUM SIZE >>>>0  "+subProblemList + " nums[i] : "+nums[i]+ " ,Details target : "+target +  ",i :"+i +", start  :  "+start +" ,k : "+k );
                    for (List<Integer> subset : subProblemList) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i])));
                        res.get(res.size() - 1).addAll(subset);
                    }
                }else {
                    System.out.println("FOURSUM NOT  ...  "+subProblemList+ " nums[i] : "+nums[i]+ " ,Details target : "+target +  ",i :"+i +", start  :  "+start +" ,k : "+k );
                }

            }
        }

        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target ) { //|| (lo > start && nums[lo] == nums[lo - 1])
                ++lo;
            } else if (currSum > target  || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])  ) { //   || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])   find it
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }



}
