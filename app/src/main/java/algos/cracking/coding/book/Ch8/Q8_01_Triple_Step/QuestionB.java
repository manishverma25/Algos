package algos.cracking.coding.book.Ch8.Q8_01_Triple_Step;

import java.util.Arrays;

public class QuestionB {

	public static int countWays(int n) {
		int[] map = new int[n + 1];
		Arrays.fill(map, -1);
		return countWays(n, map);
	}
	
	public static int countWays(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		int ways = countWays(n);
		System.out.println(ways);
		apprch2(n);
	}


	public static void apprch2(int n  ){
		int totalways = 0;

		int ways[] = new int [n];
		ways[0] = 1;
		ways[1] = 2;
		ways[2] = 4;

		for(int i =3 ; i< n ;i++){
			ways[i] = ways[i-3]+ ways[i-2]+ways[i-1];


		}
		System.out.println("aother app "+ways[n-1]);
	}

}
