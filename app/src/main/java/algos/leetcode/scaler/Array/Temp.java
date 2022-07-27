package algos.leetcode.scaler.Array;

import java.util.HashMap;

public class Temp {

    public static void main(String[] args)
    {
//        int arr[] = { 1, 5, 7, -1, 5};
        int arr[] = {1,2,3,2,3};

        int n = arr.length;
//        int sum = 6;
        int sum = 5;
        int A[] = {0, 3, 7, 6, 4, 0, 5, 5, 5 };
        int A2[] = {9, 9, 9, 9, 9 };
        int resArr[] = plusOne(A);
        System.out.println("Count of pairs is " +resArr );

        for(int i=0;i< resArr.length;i++){
            System.out.print("   "+resArr [i]+"  ");
        }
//        System.out.println("Count of pairs is " + plusOne(arr, n, sum));
    }




    public static  int[] plusOne(int[] A) {
        int B[] = new int [A.length];

        int carry = 0;
        int addedNUmber = 1;
        for(int i = A.length-1;i>=0;i--){

            int tempSum = A[i]+carry + addedNUmber;
            if(tempSum >=10){
                carry = 1;
            }else{
                carry = 0;
            }
            B[i] =  tempSum % 10;
            addedNUmber = 0;

            if(i == 0){
                if(carry!= 0){

                    int C[] = new int [A.length+1];
                    C[0] = carry;
                    for(int j =0;j<B.length;j++){
                        C[j+1] = B[j];
                    }
                    return filterZeroArray(C);
                }
            }
        }

        return filterZeroArray(B);
    }

    public static  int[] filterZeroArray(int[] A) {

        if(A[0] ==0){

            int counter = 0;
            int i = 0;
            while(A[i] == 0 && i< A.length){
                counter++;
                i++;
            }
            int []C = new int[A.length -counter];
            int pos = 0;
            for(int j = counter; j<A.length;j++,pos ++){
                C[pos] = A[j];
            }
            return C;
        }

        return A;
    }






    static int getPairsCount(int arr[], int n, int k)
    {
        HashMap<Integer,Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count += m.get(k - arr[i]);
            }
            if(m.containsKey(arr[i])){
                m.put(arr[i], m.get(arr[i])+1);
            }
            else{
                m.put(arr[i], 1);
            }
        }
        return count;
    }

    // Driver function to test the above function

}

