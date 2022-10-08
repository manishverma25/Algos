package algos.leetcode.interviewbit.Hashmap;

import java.util.Arrays;

public class Solution {

    public static  void main(String s[]){
        String  A = "abcd";
        String  b = "aab";
//        System.out.println(" res1 "+A+" " +solve(A));
        System.out.println(" res1 "+b+" " +solve(b));
    }


    public static boolean check(String s) {
        boolean ok = true;
        for (int i = 0; i + 1 < s.length(); ++i)
            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
        return ok;
    }
    public static int solve(String A) {
        String odd = "", even = "";
        for (int i = 0; i < A.length(); ++i) {
            char c = A.charAt(i);
            if (c % 2 == 0)
                odd += c;
            else
                even += c;
        }
        char[] ar = odd.toCharArray();
        Arrays.sort(ar);
        odd = String.valueOf(ar);
        ar = even.toCharArray();
        Arrays.sort(ar);
        even = String.valueOf(ar);
        if (check(odd + even))
            return 1;
        else if (check(even + odd))
            return 1;
        return 0;
    }
}
