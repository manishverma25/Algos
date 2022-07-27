package algos.leetcode.sat;

public class BitManipulation {


    public static void main(String[] args) {
        String input = "abba";
//        System.out.println("ans "+findLongestPalindromicSubstring(input));
        System.out.println("ans "+hammingDistance(2,1));
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
}
