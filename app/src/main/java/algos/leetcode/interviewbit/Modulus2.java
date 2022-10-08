package algos.leetcode.interviewbit;

public class Modulus2 {


    public static void main(String s[]) {
//        int []A =  { 1, 2, 3, 4, 5};
//        int B = 2;

//        int []A =  {  5, 17, 100, 11};
//        int B = 28;

        int A = 3;
        int B = 5;

//        int r = noOfPairs(A,B);//   A,B,C  20805472
        int r = solve(A,B);//   A,B,C  20805472
//        System.out.print("  " +  r);

        int t = 3 << 2;
        System.out.println("\n t " +  t);
    }


    public static int solve(int A, int B) {

        for(long i=1;i <B;i++){

            if( ( i*A)% B == 1){
                long res = i;
                return (int) res;
            }
        }
        return 1;
    }

    public static  int noOfPairs(int[] A, int B) {
        long pairs = 0;
        int mod = (int)1e9+7;
        long [] modArr = new long [B];
        for(int i  =0 ;i < A.length ;i++)
        {
            modArr[A[i]%B ]++;
        }


        int leftpointer = 1;
        int rightPointer = B-1;


        while(leftpointer < rightPointer){
            pairs +=   modArr[leftpointer]*modArr[rightPointer];
            pairs%=mod;
            leftpointer++;
            rightPointer--;
        }

        pairs = pairs+  (modArr[0]* (modArr[0]-1))/2;
        pairs%=mod;

        if(B%2 == 0){
            pairs =pairs +   (modArr[B/2]* (modArr[B/2]-1))/2;
            pairs%=mod;
        }
        pairs%=mod;
        return (int) pairs;
    }



}
