package algos.leetcode.interviewbit;

public class prime {


    public static void main(String[] s) {
        int [] A = {8, 9, 10};
//        for(int i = 0;i < A.length ; i++ ){
//          System.out.print(" "+A[i]);
//        }
        int r = pow2(2,7,2048);
        System.out.print(" r :: "+r);
    }

    public static int pow3(int x, int n, int d) {
        long res = 1L;
        long temp = x;
        while (n > 0) {
            if (n % 2 == 0) {
                if(res == 1){
                    res = res * x;
                }else{
                    res = res * res;
                }
                res %= d;
                n = n >> 1;
            } else {
                res = res * x;
                res %= d;
                n = n - 1;
            }
        }
        res = (res + d) % d;
        return (int) res;
    }

    public static int pow2(int A, int B, int C) {
        long temp = A;
        long res = 1L;
        while (B > 0) {
            if (B % 2 == 1) {
                res *= temp;
                res %= C;
            }
            temp *= temp;
            temp %= C;
            B = B >> 1;
        }
        res = (res + C) % C;
        return (int) res;
    }

    public int pow(int A, int B, int C) {
        int r =1;
        if(A== 0){
            return 0;
        }
        for(int i =1; i <=B;i++){
            r = r*A;
            r= r % C;
        }
        r = r % C;
        if(r < 0 ){
            r = r+C;
        }

        return C;
    }

}
