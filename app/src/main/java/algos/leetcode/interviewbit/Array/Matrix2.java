package algos.leetcode.interviewbit.Array;

public class Matrix2 {



    public static void main(String s[]) {

        int a[] = new int[]{-8, -7, -6};
//        int res = firstMissingPositive(a);
        int aa[][] =new int[][] {
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 1},
        };

        int r = solve(aa);

        System.out.println(" r :  " + r);
    }

    /***
     A = [   [0, 1, 1]
     [0, 0, 1]
     [0, 1, 1]   ]

     [
     [0, 0, 1, 1]
     [0, 0, 1, 1]
     [0, 0, 1, 1]
     [1, 1, 1, 1]
     ]

     */

    int solveit(int[][] a) {
        int n = a[0].length;
        int ans = 0;
        int row = 0, i, j;
        for (i = 0, j = n - 1; i < n && j > 0; i++) {
            while (a[i][j] == 1  ) {
                row = i;
                j--;
            }
        }
        return row;
    }


    public static  int solve(int[][] A) {
        int index = -1;

        if (A == null || A.length == 0)
            return index;
        int rows = A.length;
        int col = A[0].length;

        int firstOnePos = A.length;
        for (int c = col-1; c >= 0; c--) {
            if (A[0][c] == 1) {
                firstOnePos = c;
            } else {
                break;
            }
        }

        if (firstOnePos >= 0) {
            index = 0;
        }
        for (int r = 1; r < rows; r++) {
            if (A[r][firstOnePos-1] == 0)
                continue;
            else {
                while (firstOnePos > 0 && A[r][firstOnePos-1] == 1) {
                    firstOnePos--;
                    index = r;
                }

            }
        }

        return index;
    }


    public int solve2(int[][] A) {
        int index = -1;

        if (A == null || A.length == 0)
            return index;
        int rows = A.length;
        int col = A[0].length;
        int fcounter = 0;

        for (int r = 0; r < rows; r++) {
            int counter = 0;
            for (int c = 0; c < col; c++) {
                if (A[r][c] == 1)
                    counter++;

            }
            if (counter > fcounter) {
                fcounter = counter;
                index = r;
            }
        }

        return index;
    }






/***  int solveit(vector<vector<int> > &a){
 int n=a.size();
 int ans=0;
 int row =0,i,j;
 for (i=0,j=n-1; i<n&&j>0;i++){
 while (a[i][j]==1&&j>=0){
 row = i;
 j--;
 }
 }
 return row;
 }*/


}
