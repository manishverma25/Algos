package algos.leetcode.scaler.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSumSubArray {

    public static void main(String[] args)
    {
//        int arr[] = { 1, 5, 7, -1, 5};
        int arr[] = {1,2,3,2,3};

        int n = arr.length;
//        int sum = 6;
        int sum = 5;
//        int A[] = {1, 2, 5, -7, 2, 3 ,1,1,1};
//        int A[] =    { 1, 2, 5, -7, 2, 3 ,3} ;// { 0, 0, -1, 0 }; //{-1,-1};
        int A[] =    {4,-1,2,1} ;// { 0, 0, -1, 0 }; //{-1,-1};
//        int resArr[] = maxset(A);
//        System.out.println("Final res  " +resArr.length );


//        ArrayList<Integer> resArr = maxset2( inputList );
        int [] resArr = flip( "1101010001" ); //"1101010001"
//        System.out.println("maxSubArray  " +maxSubArray(A) );
        System.out.println("Final res  " +resArr );

        for(int i=0;i< resArr.length;i++){
            System.out.print("   "+resArr [i]+"  ");
        }


    }

    public static ArrayList<Integer> maxset2(List<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) ||   ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }

    public static  int maxSubArray(final int[] A) {
        int fSum = Integer.MIN_VALUE;
        int sum =0;

        for(int pos =0; pos < A.length ; pos++){
            sum+=A[pos];
            if (sum > fSum){
                fSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }

        return fSum;
    }

    // flip bit for max one's
    public static int [] flip(String a) {
        int inputArr[] = new int[a.length()];
        int [] res =  new int[0];
        for(int i = 0;i< a.length(); i++){
            if(a.charAt(i) == '1'){
                inputArr[i] =-1;
            }else {
                inputArr[i] =1;
            }
        }

        int l =0,r = 0,leftIndex = 0;
        int fSum = 0;
        int sum =0;

        for(int pos =0; pos < inputArr.length ; pos++){
            sum+=inputArr[pos];
            if(sum < 0){
                sum = 0;
                leftIndex  = pos +1;
            }

            if (sum > fSum){
                l  = leftIndex;
                fSum = sum;
                r = pos;
            }

        }


        if(fSum >0){
           res = new int[2];
            res[0] = l+1;
            res[1] = r+1;
        }

        return res;
    }


    public static  int[] maxset(String a) {
        int res[] =null;
        int inputArr[] = new int[a.length()];

        for(int i = 0;i< a.length(); i++){
            if(a.charAt(i) == '1'){
                inputArr[i] =-1;
            }else {
                inputArr[i] =1;
            }
        }
        Answer newAnswer = new Answer();
        Answer finalAnswer = new Answer();
        finalAnswer.Sum =-1;
        long SumSoFar = 0;
        boolean isConsiderThisStarIndex = true;
        for (int pos = 0;pos< inputArr.length; pos++) {
            Integer num = inputArr[pos];
            if(num>=0){
                SumSoFar += num;
                if(SumSoFar >= newAnswer.Sum){
                    newAnswer.Sum = SumSoFar;
                    newAnswer.endIndex = pos;
                    if(num >= newAnswer.startIndex && isConsiderThisStarIndex){
                        newAnswer.startIndex = pos;
                        isConsiderThisStarIndex = false;
                    }
                }

                if( newAnswer.Sum  > finalAnswer.Sum  ){
                    finalAnswer.Sum = newAnswer.Sum;
                    finalAnswer.startIndex = newAnswer.startIndex;
                    finalAnswer.endIndex = newAnswer.endIndex;
                }

            }else{
                SumSoFar = 0;
                isConsiderThisStarIndex = true;
                newAnswer.Sum = -1;
                newAnswer.startIndex = 0;
                newAnswer.endIndex = 0;
            }

        } // for 1 EEE


        if(finalAnswer.Sum >=0){
            res = new int[2];
            res[0] = finalAnswer.startIndex+1;
            res[1] = finalAnswer.endIndex+1;
        }else{
            res = new int[0];
        }

        return res;

    }



    static class Answer {

        int startIndex = 0;
        int endIndex = 0;
        long Sum = -1;
    }
}
