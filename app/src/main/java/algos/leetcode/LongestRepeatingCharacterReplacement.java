package algos.leetcode;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args)
    {
        int arr[] = { 1,3,-1,-3,5,3,6,7};
        int k = 3;
//        printMax(arr, arr.length, k);   //       int [] r =  SlidingWindowMaximum (arr,  k);
        String s = "pwwkew";

//        System.out.print("lengthOfLongestSubstring >>>  : " + lengthOfLongestSubstring(s));
        String A = "AAABBAAAA"; // "AABCBA";//"ABBABBB";
        System.out.print(".......  characterReplacement(A,2) >>>  : " +   characterReplacement2(A,1));

    }


    public static int characterReplacement2(String s, int k) {
        int ans = 0;
        int maxCount = 0;
        int[] count = new int[128];

        for (int left = 0, right = 0; right < s.length(); ++right) {
            char ch = s.charAt(right);
            int tempCount = ++count[ch];
            maxCount = Math.max(maxCount, tempCount);

            int Len = right - left + 1;
            while (maxCount + k < Len) {
                char leftChar = s.charAt(left++);
                count[leftChar] = count[leftChar] - 1;
                Len = right - left + 1;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }



    public static int characterReplacement(String A, int k) {
        int maxlen = 1;
        int n = A.length();
        for (int i = 0; i < 26; ++i) {
            maxlen = Math.max(maxlen, findLen(A, n, k, (char) (i+'A')));
//            maxlen = Math.max(maxlen, findLen(A, n, k, (char) (i+'a')));
        }
        return maxlen;
    }

    static int findLen(String A, int n, int k, char ch)
    {
        int maxlen = 1;
        int misMatchCharCount = 0;
        int left = 0, right = 0;

        while (right < n) {
            /* if character is not same as ch
               increase count */
            if (A.charAt(right) != ch)
                ++misMatchCharCount;

            /* While  count > k  traverse the string
               again until count becomes less than k
               and decrease the count when characters
               are not same */
            while (misMatchCharCount > k) {
                if (A.charAt(left) != ch)
                    --misMatchCharCount;
                ++left;
            }

            /* length of substring will be rightIndex -
               leftIndex + 1. Compare this with the maximum
               length and return maximum length */
            maxlen = Math.max(maxlen, right - left + 1);
            ++right;
        }
        return maxlen;
    }

}
