package algos.temp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StreamofUniqueNumbers {
    private static void findUniqueNumbers(int[] data, int i1, int i2, List<Integer> result, boolean skipFirst) {

        int a = data[i1];
        int b = data[i2];
        if (a == b) {
            if (!skipFirst) {
                result.add(a);
            }
        }
        else {
            int i3 = (i1 + i2) / 2;
            findUniqueNumbers(data, i1, i3, result, skipFirst);
            findUniqueNumbers(data, i3 + 1, i2, result, data[i3] == data[i3 + 1]);
        }
    }

    public static void main(String []s){
//        int a[] = {1,2,2};//1,1,2,2,2,3,3,3,3};,2,2,2,2,2
//        System.out.println(">>>> ");
//        for(int n :  findUniqueNumbers(a)){
//            System.out.print(" "+n);
//        }
//        System.out.println("<<<<<< ");

        int[] test = {1,2,2};//{-1, -1, -1, -1, 0, 0, 0, 0,2,3,4,5,5,6,7,8};
        System.out.println(getUniqueValues(test, 0, test.length - 1));
    }

    public static List<Integer> getUniqueValues(int[] array, int i, int j) {
        if (array == null || array.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        if (array[i] == array[j]) {
            result.add(array[i]);
        } else {
            int mid = (i + j) / 2;
            result.addAll(getUniqueValues(array, i, mid));

            // avoid duplicate divide
            while (mid < j && array[mid] == array[++mid]);


            if (array[(i + j) / 2] != array[mid]) {
                result.addAll(getUniqueValues(array, mid, j));
            }
        }
        return result;
    }
    public static List<Integer> findUniqueNumbers(int[] data) {
        List<Integer> result = new LinkedList<Integer>();
        findUniqueNumbers(data, 0, data.length - 1, result, false);
        return result;
    }
}











