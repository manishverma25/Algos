package algos.leetcode.interviewbit;

public class Modulus2 {


    public static void main(String s[]) {
//        int []A =  { 1, 2, 3, 4, 5};
//        int B = 2;

        int []A =  {  5, 17, 100, 11};
        int B = 28;

        int r = noOfPairs(A,B);//   A,B,C  20805472
        System.out.print("  " +  r);
    }

    public static  int noOfPairs(int[] A, int B) {
        long pairs = 0;


        int [] modArr = new int [B];

        for(int i  =0 ;i < A.length ;i++)
        {
            modArr[A[i]%B ]++;
        }


        int leftpointer = 1;
        int rightPointer = B-1;


        while(leftpointer < rightPointer){
            pairs +=   modArr[leftpointer]*modArr[rightPointer];
            leftpointer++;
            rightPointer--;
        }

        pairs = pairs+  (modArr[0]* (modArr[0]-1))/2;

        if(B%2 == 0){
            pairs =pairs +   (modArr[B/2]* (modArr[B/2]-1))/2;
        }
        return (int) pairs;
    }



}
