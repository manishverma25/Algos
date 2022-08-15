package algos.leetcode.interviewbit;

import java.util.ArrayList;

public class Modlus1 {

    public static void main(String s[]) {


        int a [] = {3,2,4,1,0};

        int A =  71045970;
        int B = 41535484;
        int C  = 64735492;
        int r = pow3(-2,2,20);//   A,B,C  20805472
//        int r = pow3(-2,3,1024*2);//   A,B,C  20805472
        System.out.print("  " +  r);
    }






    public static  int pow2(int A, int B, int C) {
        long a = A;
        long res = 1L;
        while (B > 0) {
            if (B % 2 == 1) {
                res *= a;
                res %= C;
            }
            a *= a;
            a %= C;
            B = B >> 1;
        }
        res = (res + C) % C;
        return (int) res;
    }

    public static int pow3(int A, int B, int C) {
        long r = 1;
        long a = A;
        if (A == 0)
            return 0;
        while (B > 0) {
            if (B % 2 == 0) {
                a = a * a;
                a = a % C;
                B = B >> 1;
            } else {
                r = a*r;
                r = r % C;
                B--;
            }

        }
        if (r < 0)
            r = (r + C);

        return (int) r;
    }


    static void arrange( int a [] ){

        int n = a.length;
        for(int i = 0;i < n ; i++){
            a[i] = a[i]* n;
        }
        for(int i = 0;i < n ; i++){
            int val0 = a[i]/n;
            int val  = a[ val0 ];
            int mod  =  (  val /n );
            a[i] = a[i] + mod ;
//            a[i] = a[i] +   (  a[ a[i]/n ] /n );
        }

        for(int i = 0;i < n ; i++){
            a[i] = a[i]  % n;
        }

    }

    public void arrange3(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);
        }
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }

    static void arrange2(ArrayList<Integer> a ){
        int n = a.size();
        for(int i = 0;i < n ; i++){
          a.set(i,a.get(i)*n);
        }
        for(int i = 0;i < n ; i++){
            int val = a.get(i);
            int val2 = (  a.get( a.get(i)/n ) /n );
            a.set(i, val+val2) ;
        }

        for(int i = 0;i < n ; i++){
            a.set(i,a.get(i) % n);
        }

    }
}
