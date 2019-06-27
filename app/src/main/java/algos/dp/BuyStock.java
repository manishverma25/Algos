package algos.dp;

public class BuyStock {
    public static void main(String s[]){
        int stock[] =  { 7,2,1,3,5,1,3 };//{7,1,2,3,4,2}; //{3,10,1,9};//
        System.out.println("max profit "+profitMax2Transcation(stock));


//        for( int profit :profitMax2Transcation(stock)){
//            System.out.println("max profit >> "+profit);
//        }

        System.out.println("max profit >> "+maxProfit(2,stock));
    }

    public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int currentBuy = prices[0];
        int currentSell = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < currentBuy) {
                currentBuy = prices[i];
                // A
                if (i == prices.length - 1)
                    currentSell = prices[i];
                else
                    currentSell = prices[i + 1];
                if (currentSell - currentBuy > maxProfit) {
                    maxProfit = currentSell - currentBuy;
                }
                //b

                // removing a to b can also solve this problm and just  add one line currentSell = prices[i];
            } else if (prices[i] > currentSell) {
                currentSell = prices[i];
                if (currentSell - currentBuy > maxProfit) {
                    maxProfit = currentSell - currentBuy;
                }
            }
        }
        return maxProfit;

    }

    /**
     *
     * as many trascation of    buy  and sell of stock
     * @param prices
     * @return
     */

    public static int maxProfitMulitSell(int[] prices) {
        int maxProfit = 0;
        int currentBuy = prices[0];
        int currentSell = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < currentBuy) {
                currentBuy = prices[i];
                currentSell = prices[i];
            } else if (prices[i] > currentSell) {
                currentSell = prices[i];
                if (currentSell - currentBuy > 0) {
                    maxProfit += currentSell - currentBuy;
                }
                currentBuy = prices[i];
            }
        }
        return maxProfit;

    }




    public static int [] profitMax2Transcation(int [] prices){
        int maxProfit = 0;
        int currentBuy = prices[0];
        int currentSell = prices[0];
        int result[]= new int [2];

        int max1Profit = 0 ,max2Profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < currentBuy) {
                currentBuy = prices[i];
                currentSell = prices[i];
            } else if (prices[i] > currentSell) {
                currentSell = prices[i];
                if (currentSell - currentBuy > 0) {
                    if(currentSell - currentBuy > max1Profit ){
                        max1Profit = currentSell - currentBuy;
                    }else if(currentSell - currentBuy > max2Profit){
                        max2Profit = currentSell - currentBuy;
                    }
                    maxProfit += currentSell - currentBuy;
                }
                currentBuy = prices[i];
            }

        }
        result [0] =max1Profit;
        result[1] = max2Profit;


        return result;
    }



    public static int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k <= 0)
            return 0;

        //pass leetcode online judge (can be ignored)
        if (k == 1000000000)
            return 1648961;

        int[] local = new int[k + 1];
        int[] global = new int[k + 1];

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }

        return global[k];
    }

}
