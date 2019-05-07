package algos;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum3Number {

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String s[]){
        int []arr=  {-2, -3, 4, -1, -2, 1, 5, -3};

        int a[] ={-2,-3,-5};// {-2, -3, 4, -1, -2, 1, 5, -3}; {4,-13,1};
        int max_sum = maxSubArraySum(arr,0,arr.length-1);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
//        System.out.println(" output is "+threeSum(arr));
    }


    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < size; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

     static int maxSubArraySum2(int a[] )
    {  int size = a.length;
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;

       /* Do not compare for all elements. Compare only
          when  max_ending_here > 0 */
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }


    static int maxCrossingSum(int arr[], int l,
                              int m, int h)
    {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--)
        {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++)
        {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        return left_sum + right_sum;
    }

    static int maxSubArraySum(int arr[], int l,
                              int h)
    {
        // Base Case: Only one element
        if (l == h)
            return arr[l];

        // Find middle point
        int m = (l + h)/2;

    /* Return maximum of following three
    possible cases:
    a) Maximum subarray sum in left half
    b) Maximum subarray sum in right half
    c) Maximum subarray sum such that the
    subarray crosses the midpoint */
        return Math.max(Math.max(maxSubArraySum(arr, l, m),
                maxSubArraySum(arr, m+1, h)),
                maxCrossingSum(arr, l, m, h));
    }


}