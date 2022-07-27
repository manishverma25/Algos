package algos.leetcode.other;

import android.util.Pair;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algos.cracking.coding.book.Ch3Testing.Q3_03_Stack_of_Plates.Node;

public class NumberOfIsland {

    static char [][] grid = { {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
    };




    public static void main(String []s){
        numIslands(grid);
    }


    static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }




    static  public int maxDepth(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
//            Pair<Node, Integer> current = stack.poll();
//            root = current.getKey();
//            int current_depth = current.getValue();
//            if (root != null) {
//                depth = Math.max(depth, current_depth);
//                for (Node c : root.children) {
//                    stack.add(new Pair(c, current_depth + 1));
//                }
//            }
        }
//        List<Integer> heights = new LinkedList<>();
//
//        return Collections.max(heights) + 1;
        return depth;
    }


}
