package algos.dp;
class DiceSumDp {
    // Function to calculate total number of ways to achieve given
    // sum with n throws of dice having k faces
    public static int count(int n, int k, int sum)
    {
        // if desired sum is reached with n dices
        if (n == 0) {
            return (sum == 0) ? 1: 0;
        }

        // desired sum can't be reached with current configuration
        if (sum < 0 || k * n < sum || n > sum) {
            return 0;
        }

        int res = 0;

        // recur for all possible solutions
        for (int i = 1; i <= k; i++) {
            res += count(n - 1, k, sum - i);
        }

        return res;
    }

    public static void main(String[] args)
    {
        int n = 2;	// n throws
        int k = 6;	// values 1 - 6

        int sum = 3;	// desired sum

        System.out.println("Total number of ways are " + count(n, k, sum));
        System.out.println("Total number of ways DP  are " + findWaysDp(n, k, sum));
    }


    /* The main function that returns the number of ways to get sum 'x' with 'n' dice and 'm' with m faces. */

    public static long findWaysDp( int n, int m,int x){

    /* Create a table to store the results of subproblems.
    One extra row and column are used for simplicity
    (Number of dice is directly used as row index and sum is directly used as column index).
    The entries in 0th row and 0th column are never used. */
        long[][] table = new long[n+1][x+1];

        /* Table entries for only one dice */
        for(int j = 1; j <= m && j <= x; j++)
            table[1][j] = 1;

    /* Fill rest of the entries in table using recursive relation
    i: number of dice, j: sum */
        for(int i = 2; i <= n;i ++){
            for(int j = 1; j <= x; j++){
                for(int k = 1; k < j && k <= m; k++)
                    table[i][j] += table[i-1][j-k];
            }
        }
        return table[n][x];
    }
}