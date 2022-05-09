package algos.leetcode;

public class LongestPalindrome {


    public static void main(String [] s){

        String data = "abcbaqp";

//       String r=  longestPalindrome(data);
       String r=  longestPalidromeStringDP(data);
       System.out.print(">>>>ln longestPalindrome "+r);

    }

    public static String longestPalidromeStringDP(String s){
        int [][] dpLPS = new int [s.length()][s.length()];
        int solutionRow  = 0;
        int solutionCol  = 0;
        String longestPalidromeStr = "";

       int i =0;int j = 0;
        for(int c = 0; c < dpLPS.length  ;i++,j++, c++){ // a
            dpLPS[i][j] = 1;
        } //
        for(int c = 1; c < dpLPS.length  ; c++){ // a
            int row =0;
            for(int col = c; col < dpLPS.length  ; col++,row++){ // a
                System.out.println(" row : "+row+ " (s.charAt(row) : "+ (s.charAt(row))+    " col : "+col +"  (s.charAt(col))  : "+ (s.charAt(col)));
               char left =  s.charAt(row);
                char rght =  s.charAt(col);
                int subRow  = row +1;
                int subcol = col -1;
                System.out.println(" left : "+left+ " rght: "+ rght);
                if(left == rght ){ // 1
                    if( (subRow <= subcol )  && dpLPS[row+1][col-1] > 0){
                        dpLPS[row][col]   =  dpLPS[row+1][col-1] +2;
                        System.out.println(" inside   dpLPS[row+1][col-1]  : "+dpLPS[row+1][col-1]  +" row "+row+ "col :"+col + "  longestPalidromeStr :"+longestPalidromeStr);
                        if( col - row +1 > longestPalidromeStr.length()){
                            longestPalidromeStr = s.substring(row,col+1);
                            solutionRow = row;
                            solutionCol = col;
                            System.out.println(" updating longestPalidromeStr  : "+longestPalidromeStr  +" row "+row+ "col :"+col);
                        }
                    }
                }// 1
            }
        } //a
        System.out.println(" final  longestPalidromeStr  : "+longestPalidromeStr  +" solutionRow "+solutionRow+ " solutionCol  :"+solutionCol);
        return longestPalidromeStr;
    }













    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }








}

