package algos.leetcode;

import java.util.Stack;

public class LongestValidParenthesis {

    public static void main(String s[]){
        String st = "(())(())";
        int r =-1;
//        r = longestValidParentheses3(st);
        System.out.println(" res : "+r);


        r = longestValidParenthesesDP(st);
        System.out.println(" res : "+r);

    }

    public static  boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public static int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public static int longestValidParenthesesDP(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    int col1 =  i - dp[i - 1] - 2; /** eg (())(())  */
                    int temp2 = (i - dp[i - 1]) >= 2 ? dp[col1] : 0;
                    System.out.println(" i : "+  i+ ", (i - dp[i - 1] - 1) : "+ ((i - dp[i - 1] - 1)) + ", col1 : "+col1 +" , temp2 :"+temp2);
                    System.out.println("  dp[i - 1]: "+  ( dp[i - 1])+ ", (temp2+ 2) : "+(temp2+ 2));
                    dp[i] = dp[i - 1] + temp2+ 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static int longestValidParentheses3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
