package algos;

import java.util.ArrayList;

public class LongestCommonSequence {

    static int max_ref;

    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int num: nums){
            if(list.size()==0 || num>list.get(list.size()-1)){
                list.add(num);
            }else{
                int i=0;
                int j=list.size()-1;

                while(i<j){
                    int mid = (i+j)/2;
                    if(list.get(mid) < num){
                        i=mid+1;
                    }else{
                        j=mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();
    }


//    public static void main(String args[])
//    {
//        int arr[] = {8,9,10,11,15,1,3,2,3,4,1,12,16}; //{ 10, 22, 9, 33, 21, 50, 41, 60 };{8,9,10,11,15,1,3,2,12,13,14};
//        int n = arr.length;
//        System.out.println("Length of lis is "
//                + lengthOfLIS(arr) + "\n");
//    }



    public static void findSubsequence(int[] arrA) {
        int[] LIS = new int[arrA.length];
        for (int i = 0; i < arrA.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                // check if previous elements > current element
                if (arrA[i] > arrA[j]) {
                    // update the max from the previous entries
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            if (max == -1) {
                max = 1;
            }
            LIS[i] = max;
        }
        int result = -1;
        int index = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }
        String path =  arrA[index] + " ";
        int res = result-1;
        for (int i = index-1; i >= 0; i--) {
            if(LIS[i]==res){
                path =  arrA[i] + " " + path;
                res--;
            }
        }
        System.out.println("Longest Increasing subsequence: " + result);
        System.out.println("Actual Elements: " + path);
    }

    public static void main(String[] args) {
        int[] A =    {3,4,1};//{ 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
        findSubsequence(A);
       System.out.println(" find max seq ");
    }



}
