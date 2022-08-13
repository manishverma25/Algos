package algos.leetcode.interviewbit.bitwise;

import java.util.ArrayList;
import java.util.List;

public class BitwiseOp {
    public static void main(String []s){
        int a = 5;
        int b = 7;

       int ar[] = new int []{1, 2, 2, 3, 1};
//        System.out.println("res = " + hammingWeight(21));

//        String A = "01";
//        String B = "11";
////        System.out.println("res = " + addBinary(A,B));
//        Integer num = 13;
//        printDigit(num);

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(1073741824);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(1);
        System.out.println("res = " + singleNumber(list));
    }


    public static int singleNumber(final List< Integer > A) {
        int[] bits = new int[32];
        for (int num: A) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }
        int number = 0;
        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }
//        for (int i = 0; i <= 31; i++) {
//            number = number  + bits[i] *  (int) Math.pow(2,i);
//        }
        return number;
    }



    public static  void printDigit(Integer num ){
        int[] bits = new int[8];
        int n2 = num;
        String s= "";
        System.out.println();
        for (int i = 0; i < 8; i++) {
            bits[i] += (1 & (num >> i));
            s = " " + bits[i] +s;
        }

        int number = 0;
        for (int i = 7; i >= 0; i--) {
            number = number * 2 + bits[i];
        }

    }





    public static  String addBinary(String A, String B) {
        String ans = "";
        int sum = 0 , cary = 0;
        int  i  = A.length()-1;
        int j = B.length()-1;

        while (i >= 0 || j >= 0 || cary !=0 ){
            if(i >= 0 ){
                sum =sum +  A.charAt(i) -'0';
                i--;
            }
            if(j >= 0 ){
                sum =sum +  B.charAt(j) -'0';
                j--;
            }
            sum =sum + cary;
            cary = 0;
            System.out.println("  >>>>>>>  sum "+sum + "cary  "+cary);
            if(sum >=2){
                cary = sum / 2;
                sum = sum % 2;
            }
           char  c =   (char)  (sum +'0');
            System.out.println(" c = " + c +" sum "+sum + "cary  "+cary);
            ans =   c + ans ;
            sum = 0 ;
        }
        return ans;
    }

    public static  int numSetBits2(int A) {

        int c = 0;
        while(A !=0 ){

            A = A-1 & 1;
            c++;
        }
        return c;

    }

    public static int singleNumber(final int[] A) {
        int xor = A[0];

        for(int i = 1; i < A.length ; i++){
            xor = xor^ A[i];

        }


        return xor;
    }


    public  static  int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            System.out.println("mask = " + mask  +" bits "+bits) ;
            if ((n & mask) != 0) {
                System.out.println("mask = " + mask  +" bits "+bits+  " iiiii "+i) ;
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }


    public static  int numSetBits(int A) {

        int c = 0;
        while(A !=0 ){

            A = A >>2;

          if(  (A | 1)  == 1)
          {
              c++;
          }
        }
        return c;

    }
}
