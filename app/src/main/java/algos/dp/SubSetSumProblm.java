package algos.dp;

import java.util.LinkedList;

//https://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/

public class SubSetSumProblm {


    public static boolean subSetDP(int[] A, int sum) {
        boolean[][] solution = new boolean[A.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for(int i=1;i<=sum;i++){
            solution[0][i]=false;
        }
        // if sum is 0 the we can make the empty subset to make sum 0
        for(int i=0;i<=A.length;i++){
            solution[i][0]=true;
        }
        //
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=sum;j++){
                //first copy the data from the top
                solution[i][j] = solution[i-1][j];

                //If solution[i][j]==false check if can be made
                if(solution[i][j]==false && j>=A[i-1])
                    solution[i][j] = solution[i][j] || solution[i-1][j-A[i-1]];
            }
        }

        findSubsetPath(solution,A);
        return solution[A.length][sum];
    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 7, 1};
        System.out.println("\nFrom DP: " + subSetDP(A, 6) );
    }


    public static LinkedList<Integer> findSubsetPath(boolean[][] solution, int[] A) {
        LinkedList<Integer> list = new LinkedList<>();


        int col = solution[solution.length - 1].length -1 ;
        int row = A.length  ;

        if (!solution[row][col]) {  //solution[A.length + 1][solution.length + 1]
            return list;
        }


//        for (; col >= 1; ) {
            for (; row >= 1 ; ) {
                if (solution[row][col]) {
                    if (!solution[row - 1][col]) {
                        list.add(A[row-1]);
                        col = col - A[row-1];
                        row--;
                        // if row 0 then return bcoz it completes
                    } else {
                        row--;
                    }
                } else {
                    row--;
                }
            }
//        }

        for(int val : list ){
            System.out.println(",item  :   "+val );
        }

        return list;
    }
}
