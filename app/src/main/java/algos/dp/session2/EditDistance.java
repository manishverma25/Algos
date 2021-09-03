package algos.dp.session2;

class EditDistance {
    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    static int editDistDP(String str1, String str2, int m,
                          int n)
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is
                // to insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is
                    // to remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last
                    // char and recur for remaining string
                else if (str1.charAt(i - 1)
                        == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different,
                    // consider all possibilities and find the
                    // minimum
                else
                    dp[i][j] = 1
                            + min(dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1]
                                    [j - 1]); // Replace
            }
        }

        return dp[m][n];
    }

    // Driver Code
    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistDP(
                str1, str2, str1.length(), str2.length()));
    }
}

class GFG
{

    static void EditDistDP(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();

        // Create a DP array to memoize result
        // of previous computations
        int [][]DP = new int[2][len1 + 1];


        // Base condition when second String
        // is empty then we remove all characters
        for (int i = 0; i <= len1; i++)
            DP[0][i] = i;

        // Start filling the DP
        // This loop run for every
        // character in second String
        for (int i = 1; i <= len2; i++)
        {

            // This loop compares the char from
            // second String with first String
            // characters
            for (int j = 0; j <= len1; j++)
            {

                // if first String is empty then
                // we have to perform add character
                // operation to get second String
                if (j == 0)
                    DP[i % 2][j] = i;

                    // if character from both String
                    // is same then we do not perform any
                    // operation . here i % 2 is for bound
                    // the row number.
                else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
                }

                // if character from both String is
                // not same then we take the minimum
                // from three specified operation
                else {
                    DP[i % 2][j] = 1 + Math.min(DP[(i - 1) % 2][j],
                            Math.min(DP[i % 2][j - 1],
                                    DP[(i - 1) % 2][j - 1]));
                }
            }
        }

        // after complete fill the DP array
        // if the len2 is even then we end
        // up in the 0th row else we end up
        // in the 1th row so we take len2 % 2
        // to get row
        System.out.print(DP[len2 % 2][len1] +"\n");
    }

    // Driver program
    public static void main(String[] args)
    {
        String str1 = "food";
        String str2 = "money";
        EditDistDP(str1, str2);
    }
}
