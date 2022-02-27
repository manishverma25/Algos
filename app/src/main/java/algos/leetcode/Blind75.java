package algos.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import algos.cracking.coding.book.CtCILibrary.TreeNode;


class Blind75 {

    static int  maxsum = Integer.MIN_VALUE;
    public static void main(String []s){


        System.out.println("..... "+"");
    }



    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        System.out.println("max_sum :   "+ max_sum + "   , node :"+(node == null? -1 : node.val));

        System.out.println("node.val + Math.max(left_gain, right_gain)  :   "+ (node.val + Math.max(left_gain, right_gain)) + "   , node :"+(node == null? -1 : node.val));

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

//    [-100,90,-200,null,null,15,7]
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        int newDpth = 1;
        while(!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            System.out.println("root :   "+ root + "   , current_depth :"+current_depth);
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
                newDpth = newDpth+1;
            }
        }
        return newDpth;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    static  void   twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }


    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level

        System.out.println("node.val :   "+ node.val + "   , level :"+level);

        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }else{
            System.out.println(" esle case node.val :   "+ node.val + "   , level :"+level);
        }


        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public int maxPathSum2(TreeNode root) {

        maxsum(root);

        return maxsum;
    }
    private int maxsum(TreeNode root) {
        // time: O(n), visit each node once
        // space: O(height), either O(logn) on average, or O(n) in worst case.

        if (root == null) return 0;

        int leftmax = maxsum(root.left);
        int rightmax = maxsum(root.right);

        int maxpathsum = Math.max(leftmax, rightmax);
        // case 1. left + right + root.val
        // case 2. Math.max(left, right) + root
        // case 3. root itself
        int currmax = Math.max(Math.max(leftmax + rightmax + root.val, maxpathsum + root.val), root.val);
        maxsum = Math.max(maxsum, currmax);

        // note, can not return currmax here because currmax is max of (1,2,3)
        // but in case 1, if we take (left + right + root), we can not return this to the parent
        // becasue a valid path can only have one direction, for example:
        //             1
        //         2       3
        //               4    5
        // 1-3-4-5 is not a valid path, because 3 is re-visited, so case 1 can not be returned to parent
        // it can only be either (leftpath + root) or (rightpath + root) or (root itself)
        // it can not be (left + right + root)
        // thus we can only return Math.max(case 2, case 3) to parent
        return Math.max(Math.max(leftmax, rightmax) + root.val, root.val);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
