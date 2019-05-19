package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubset {


    public static void main(String s[]){
        char arr[] = {'a','b','c'};

      System.out.println(  subsets(arr));

    }

        public static List<List<String>> subsets(char[] nums) {
            List<List<String>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<String>(), nums, 0);
            return list;
        }

        private static void backtrack(List<List<String>> list , List<String> tempList, char [] nums, int start){
            list.add(new ArrayList<>(tempList));
            for(int i = start; i < nums.length; i++){
                tempList.add(""+ nums[i]);
                backtrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }


}
