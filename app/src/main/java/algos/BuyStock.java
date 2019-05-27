package algos;

public class BuyStock {
    public static void main(String s[]){
        int stock[] = {7,1,2,3,4,2}; //{3,10,1,9};//
        System.out.println("max profit "+maxProfit2(stock));
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

                // removing a to b can also solve this problm
            } else if (prices[i] > currentSell) {
                currentSell = prices[i];
                if (currentSell - currentBuy > maxProfit) {
                    maxProfit = currentSell - currentBuy;
                }
            }
        }
        return maxProfit;

    }
}
