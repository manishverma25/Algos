package algos.leetcode.array;

import java.util.ArrayList;
import java.util.List;

  class FindNumber {

    public static void main(String []s){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(3);
        list.add(6);
        System.out.println("bcdbc");

    }




    public static List<Integer> oddNumbers(int l, int r) {
        // Write your code here

        ArrayList<Integer> list = new ArrayList<>();


        for(int i = l;i<=r;i++){
            if(i%2 ==1){
                list.add(i);
            }
        }
        return list;

    }
    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here

        String found = "NO";


       for(int num :arr ){
           if(num == k){
               found = "Yes";
               return found;
           }
       }


        return found;
    }
}

class  b extends FindNumber {

}
