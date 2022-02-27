package algos.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowArray {
    static void printMax(int arr[], int n, int k) {
        int insertPos= 0;
        int [] slidingMaxAnswers = new int[arr.length];
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i)
        {
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >=
                    arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }
        for (; i < n; ++i){
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
//            System.out.print(arr[Qi.peek()] + " ");
            slidingMaxAnswers[insertPos++] = Qi.peek();

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <=
                    i - k)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty()) && arr[i] >=
                    arr[Qi.peekLast()])
                Qi.removeLast();
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
        System.out.print(arr[Qi.peek()]);
    }

    public static void main(String[] args)
    {
        int arr[] = { 1,3,-1,-3,5,3,6,7};
        int k = 3;
//        printMax(arr, arr.length, k);   //       int [] r =  SlidingWindowMaximum (arr,  k);
        String s = "pwwkew";

//        System.out.print("lengthOfLongestSubstring >>>  : " + lengthOfLongestSubstring(s));

    }

    public  static  int[] SlidingWindowMaximum(int[] A, int K) {
        int n = A.length;
        if (n * K == 0) return new int[0];
        if (K == 1) return A;

        int [] left = new int[n];
        left[0] = A[0];
        int [] right = new int[n];
        right[n - 1] = A[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % K == 0) left[i] = A[i];
            else left[i] = Math.max(left[i - 1], A[i]);

            int j = n - i - 1;
            if ((j + 1) % K == 0) right[j] = A[j];  // block_end
            else right[j] = Math.max(right[j + 1], A[j]);
        }

        int [] output = new int[n - K + 1];
        for (int i = 0; i < n - K + 1; i++)
            output[i] = Math.max(left[i + K - 1], right[i]);

        return output;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }


    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    private static  boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }

    public static  int maxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }

}




