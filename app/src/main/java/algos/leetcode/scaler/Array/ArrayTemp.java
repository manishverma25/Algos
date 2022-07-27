package algos.leetcode.scaler.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayTemp {
    public static void main(String st[]){
       test();
        System.out.println("   Hello, World! End ");
    }


    public static void test(){
        int n= 5;
        for(int i = 1;i<= n;i++ ){
            for(int start = i;start <= n ;start++){
                System.out.print( "  \n");
                for(int end = i; end <=start ; end++){
                    System.out.print( " "+end);
                }

            }
        }
    }
}
