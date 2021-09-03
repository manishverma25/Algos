package algos.recursion;

import java.util.ArrayList;

public class MaxIndex {


    static  int arr[] = new int[] {5,2,2,2,4,5,8};
    static ArrayList storedIndex = new ArrayList<Integer>();
    public static void main(String s[]){

//        int res = findLfirstIndex(0,2,-1);
//        int res = findAllIndex(0,2);
        int res = getNumberIndexFromLast(0,2);

        System.out.println("result f : "+res);
    }

    static int findLastIndex(int curentPos, int element) {
        int index = -1;
        if (curentPos == arr.length) {
            if (arr[curentPos - 1] == element) {
                index = curentPos - 1;
            }
            return index;
        }

        int res = findLastIndex(curentPos + 1, element);
        if(res != -1)
            return res;

        if (arr[curentPos] == element) {
            index = curentPos;
            return index;
        }

        return index;
    }

    static int findAllIndex(int curentPos, int element) {
        int index = -1;
        if (curentPos   == arr.length -1) {
            if (arr[curentPos  ] == element) {
                index = curentPos   ;
                storedIndex.add(index);
            }
            return index;
        }else{
            findAllIndex(curentPos + 1, element);
            if (arr[curentPos] == element) {
                index = curentPos;
                storedIndex.add(index);
            }
        }
        return index;
    }


   static int findLfirstIndex(int curentPos, int element,int foundIndex){
        int index = -1;

        if(curentPos  ==  arr.length){
            if(arr[curentPos-1] == element){
                index = curentPos - 1;
            }
            return index;
        }

        if(arr[curentPos] == element){
            index = curentPos;
            return index;
        }

        return findLfirstIndex(curentPos+1,element,foundIndex);
    }


    static int getNumberIndexFromLast(int index, int element) {
        int result = -1;
        if (index == arr.length - 1) {
            if (arr[index] == element) {
                result = index;
            }
            return result;
        }
        int fromRightIndexResult = getNumberIndexFromLast(index + 1, element);

        if (fromRightIndexResult != -1) {
            return fromRightIndexResult;
        }

        if (arr[index] == element) {
            result = index;
        }

        return result;
    }







}
