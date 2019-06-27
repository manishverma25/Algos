package algos.dp;

public class MinimumCoinProblm {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 20;
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
                + amount + " are: " + minimumCoin(amount, coins));
    }

    public static int minimumCoin(int sum, int[] coins) {

        int[][] minCoins = new int[coins.length + 1][sum + 1];
        int reault = -1;
        for (int i = 0; i <= sum; i++) {
            minCoins[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= coins.length; i++) {
            minCoins[i][0] = 0;
        }
        for (int row = 1; row <= coins.length; row++) {
            for (int col = 1; col <= sum; col++) {
                if (col - coins[row - 1] >= 0) {
                    minCoins[row][col] = Math.min(minCoins[row][col - coins[row - 1]] + 1, (minCoins[row - 1][col]));
                } else {
                    minCoins[row][col] = minCoins[row - 1][col];
                }
            }
        }

        return minCoins[coins.length][sum];
    }


    public int minCoinDynamic(int amount, int[] coins) {
        // this will store the optimal solution
        // for all the values -- from 0 to given amount.
        int[] coinReq = new int[amount + 1];

        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {
            coinReq[amt] = Integer.MAX_VALUE;
            // Now try taking every coin one at a time and pick the minimum
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to solution of (amount-coin value)
                    coinReq[amt] = Math.min(coinReq[amt - coins[j]] + 1, coinReq[amt]);
                }
            }
        }
        //return the optimal solution for amount
        return coinReq[amount];


    }
}
