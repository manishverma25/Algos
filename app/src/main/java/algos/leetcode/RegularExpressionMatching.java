package algos.leetcode;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String text = "ab";
        String pattern = "a*b";
        boolean res = isMatch(text,pattern);
        System.out.println("result : "+res);
//        System.out.println(matchRegex("Tushar".toCharArray(),"Tushar".toCharArray()));
//        System.out.println(matchRegex("Tusha".toCharArray(),"Tushar*a*b*".toCharArray()));
//        System.out.println(matchRegex("".toCharArray(),"a*b*".toCharArray()));
//        System.out.println(matchRegex("abbbbccc".toCharArray(),"a*ab*bbbbc*".toCharArray()));
//        System.out.println(matchRegex("abbbbccc".toCharArray(),"aa*bbb*bbbc*".toCharArray()));
//        System.out.println(matchRegex("abbbbccc".toCharArray(),".*bcc".toCharArray()));
//        System.out.println(matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
//        System.out.println(matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
//        System.out.println(matchRegex("aaa".toCharArray(),"ab*a*c*a".toCharArray()));
        System.out.println(matchRegex("ab".toCharArray(), "a.*".toCharArray()));

    }

    /**
     * Dynamic programming technique for regex matching.
     */
    public static boolean matchRegex(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }



    public static  boolean isMatch(String text, String pattern) {
        System.out.println ("text : "+text+",  pattern : "+pattern);
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            System.out.println ("text.substring(1)  : "+(text.substring(1) )+", pattern.substring(2) : "+(pattern.substring(2)));

            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }


    Result[][] memo;



    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }





    public boolean isMatchDP(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }


}
enum Result {
    TRUE, FALSE
}
