package algos.dp;

public class TrapingWatertank {

    public static void main(String[] s) {

//        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int arr[] = {3,3,5,3,4,0,1};
        int[] towerHeight =   {3,2,1};

        System.out.println("total  : " + trap(arr));
//        int[] towerHeight =   {7,5,2,3}; //{1, 5, 2, 3, 1, 7, 2, 4};
        System.out.println("height >  " + getMaxRainwaterBetweenTowers(towerHeight));


    }


    public static int trap(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (left <= right) {
            leftmax = Math.max(leftmax, A[left]);
            rightmax = Math.max(rightmax, A[right]);
            if (leftmax < rightmax) {
                max += (leftmax - A[left]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                left++;
            } else {
                max += (rightmax - A[right]);
                right--;
            }
        }
        return max;
    }



    // second approach

    public static int getMaxRainwaterBetweenTowers(int[] towerHeight) {
        int maxSeenSoFar = 0;

        int[] maxSeenRight = new int[towerHeight.length];
        int maxSeenLeft = 0;

        int rainwater = 0;

        for (int i = towerHeight.length - 1; i >= 0; i--) {
            if (towerHeight[i] > maxSeenSoFar) {
                maxSeenSoFar = towerHeight[i];
                maxSeenRight[i] = maxSeenSoFar;

            } else {
                maxSeenRight[i] = maxSeenSoFar;

            }

        }

        for (int i = 0; i < towerHeight.length; i++) {
           int leftRightMin =  Math.min(maxSeenLeft, maxSeenRight[i]);
            int curWater =   Math.max(leftRightMin- towerHeight[i], 0);
            rainwater = rainwater + curWater;
            if (towerHeight[i] > maxSeenLeft) {
                maxSeenLeft = towerHeight[i];

            }

        }

        return rainwater;

    }


}
