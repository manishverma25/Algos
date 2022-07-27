package algos.leetcode;


public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "abba";
//        System.out.println("ans "+findLongestPalindromicSubstring(input));
        System.out.println("ans "+hammingDistance(2,1));
    }

    private static String findLongestPalindromicSubstring(String input) {
        if(input.isEmpty()) {
            return "";
        }
        int n = input.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrom = new boolean[n][n];

        for(int j = 0; j < n; j++) {
            System.out.println( );
            palindrom[j][j] = true;
            for(int i = 0; i < j; i++) {
                System.out.print("  i "+i+" j "+j+",,");
                char ci= input.charAt(i);
                char cj= input.charAt(j);
//                System.out.print(" i  "+i+" j "+j + " ci "+ci+ "  cj "+cj+"  ;;");
                if( ci == cj && (j-i <= 2 || palindrom[i+1][j-1])) {
                    palindrom[i][j] = true;
                    if(j-i+1 > longestSoFar) {
                        longestSoFar = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return input.substring(startIndex, endIndex+1);
    }



    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }


    public int[] searchRange(int[] nums, int target) {

        int firstOccurrence = this.findBound(nums, target, true);

        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }

        int lastOccurrence = this.findBound(nums, target, false);

        return new int[]{firstOccurrence, lastOccurrence};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {

            int mid = (begin + end) / 2;

            if (nums[mid] == target) {

                if (isFirst) {

                    // This means we found our lower bound.
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }

                    // Search on the left side for the bound.
                    end = mid - 1;

                } else {

                    // This means we found our upper bound.
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }

                    // Search on the right side for the bound.
                    begin = mid + 1;
                }

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return -1;
    }


}
