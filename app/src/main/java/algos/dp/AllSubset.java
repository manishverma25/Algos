package algos.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubset {


    public static void main(String s[]){
        String  arr[] = {"a","b","c"};

//      System.out.println(  subsets(arr));
        System.out.println(  exist(chr,"ABCESE"));

    }

        public static List<List<String>> subsets(String[] nums) {
            List<List<String>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<String>(), nums, 0);
            return list;
        }

        private static void backtrack(List<List<String>> list , List<String> tempList, String [] nums, int start){
            list.add(new ArrayList<>(tempList));
            for(int i = start; i < nums.length; i++){
                tempList.add(""+ nums[i]);
                backtrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }


    public static char chr[][] = {{'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
    };
        public static boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int y = 0; y < board.length; y++) {
                for (int x = 0; x < board[y].length; x++) {
                    if (exist(board, y, x, w, 0))
                        return true;
                }
            }
            return false;
        }

        private static boolean exist(char[][] board,
                              int y, int x, char[] word, int i) {
            if (i == word.length)
                return true;
            if (y < 0
                    || x < 0
                    || y == board.length
                    || x == board[y].length)
                return false;

            if (board[y][x] != word[i])
                return false;

            board[y][x] ^= 256;

            boolean exist =
                    exist(board, y, x + 1, word, i + 1)
                            || exist(board, y, x - 1, word, i + 1)
                            || exist(board, y + 1, x, word, i + 1)
                            || exist(board, y - 1, x, word, i + 1);
            board[y][x] ^= 256;

            return exist;
        }


}
