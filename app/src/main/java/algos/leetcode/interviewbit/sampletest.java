package algos.leetcode.interviewbit;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class sampletest {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {

        int A= 71045970 ;
        int B= 41535484;
        int C= 64735492;

        int arr[] = new int[]{1,2,2,1};
        int arr2[] = new int[]{2,3,1,2};


//        int arr[] = new int[]{2, 1, 4, 10};
//        int arr2[] = new int[]{3, 6, 2, 10, 10};



//        int arr3[] = new int[]{-3,2,1};

        int resArr[] = findCommonArrayElement2(arr,arr2);
        System.out.println("findCommonArrayElement2  :  "+resArr.length );

        for(int i=0;i< resArr.length;i++){
            System.out.println("   "+resArr [i]+"  ;");
        }

    }

    public static int[] findCommonArrayElement2(int[] A, int[] B) {

        int resultArr[]= null;

        List<Integer> resultList = new ArrayList<Integer>();
        HashMap<Integer,Integer> map =new HashMap();

        for(int i =0;i<A.length;i++){

            if( map.get(A[i])!=null){
                map.put(A[i],map.get(A[i])+1);
            }else{
                map.put(A[i],1);
            }

        }
        for(int j=0;j<B.length;j++){
            Integer foundval  = map.get(B[j]);

            if(foundval !=null && foundval >0 ){
                resultList.add(B[j]);
                map.put(B[j],foundval-1);
            }
        }
        resultArr =new int[resultList.size()];
        for(int i =0;i<resultArr.length;i++){
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }




    public static int sumFound(int[] A) {
        // Arrays.sort(A);
        int result =0;
        int sumSoFar = 0;

        HashSet<Integer> savedSumSet = new HashSet();

        for(int i =0;i< A.length;i++){
            sumSoFar = sumSoFar +A[i];
            if(A[i] == 0){
                result = 1;
            }else if(sumSoFar == 0){
                result = 1;
            }else if(savedSumSet.contains(sumSoFar))
                result =1;


            savedSumSet.add(sumSoFar);

        }


        return result;


    }





    public static int[] findCommonArrayElement(int[] A, int[] B) {

        int resultArr[]= null;
        List<Integer> resultList = new ArrayList<Integer>();
        HashMap<Integer,Integer> map =new HashMap();

        for(int i =0;i<A.length;i++){
            map.put(A[i],i);
        }
        for(int j=0;j<B.length;j++){
            Integer foundval  = map.get(B[j]);

            if(foundval !=null){
                resultList.add(B[j]);
            }
        }
        resultArr =new int[resultList.size()];
        for(int i =0;i<resultArr.length;i++){
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }






    @RequiresApi(api = Build.VERSION_CODES.N)
    public static  int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }






    public static  long pow(int A, int B, int C) {

        long result = 1;
        for(int i =0;i<B;i++){
            result = result*A;
//            result = result % C;
        }
        result = result % C;
        if(result <0){
            return result + C;
        }
        return result;
    }



}
