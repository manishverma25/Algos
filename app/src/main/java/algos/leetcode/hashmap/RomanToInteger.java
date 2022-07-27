package algos.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String []s){

        String roman = "IIV";
        int num = 91;
//        System.out.print(  "num "+num+ " result : "+(intToRoman(num)));
        System.out.print(  "roman "+roman+ " result : "+(romanToInt(roman)));

    }

    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public static int romanToInt(String s) {

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            }
            else {
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }


    private static final int[] values2 = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values2.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values2[i] <= num) {
                num -= values2[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }




}
