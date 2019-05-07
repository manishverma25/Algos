package algos;

public class MinimumCoinProblm {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int amount = 20;
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
                + amount + " are: " + minimumCoin(amount, coins));
    }

    public static int minimumCoin(int sum ,int[] coins){

        int [][]minCoins  =new int[coins.length+1][sum+1];
        int reault = -1;
        for(int i =0 ; i <= sum;i++){
            minCoins[0][i]=Integer.MAX_VALUE;
        }
        for(int i =0 ; i <= coins.length;i++){
            minCoins[i][0]=0;
        }
        for(int row =1 ; row <= coins.length ;row++){
            for(int col =1 ; col <= sum;col++){
                if(col - coins[row-1] >= 0 ) {
                    minCoins[row][col] = Math.min( minCoins[row][col  - coins[row-1] ] + 1,(minCoins[row-1][col]) );
                }else{
                    minCoins[row][col] = minCoins[row-1][col];
                }
            }
        }

        return minCoins[coins.length][sum];
    }
}
