package algos.leetcode;


import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import algos.cracking.coding.book.CtCILibrary.TreeNode;

class LCA {

    private TreeNode ans;

    public LCA() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }



    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String []s){
        print1();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    static void print1(){
        System.out.println("print1 .... "+getcube(squrefunction,5));
//        Function<Integer , Function<Integer ,String  >> t = getfunction(1);
        Integer num = 2;
//        getfunction2(num);
       String r=  testfunction.apply(1);
        System.out.println("rrrr .... "+r);


        Function<Integer ,String  > t = getfunction2.apply(num);
        System.out.println("created function  .... "+( t.apply(num)));

    }

    static  Function<Integer ,Integer  > squrefunction = (a) -> {
        return (a *a);
    };
    static  Function<Integer ,String  > testfunction = (a) -> {

        return  (a + "****a");
    };



    @RequiresApi(api = Build.VERSION_CODES.N)
    static int getcube(Function<Integer ,Integer  > f, int n ){
        return n*(f.apply(n));
    }

    static  Function<Integer , Function<Integer ,String  >> getfunction2 = (paramNumber) -> {

        System.out.println("param  .... "+paramNumber);
        Function<Integer ,String  >    newFunction  = null ;
        if(paramNumber== 1){
            newFunction  = (nestedParam) -> {
                return "VehicleBrandDivisonEntity.getTenantId()";
            };
        }else if(paramNumber== 2){
            newFunction  = (nestedParam) -> {
                return "VehicleBrandDivisonEntity.getBrand()";
            };
        }else if(paramNumber== 3){
            newFunction  = (nestedParam) -> {
                return "VehicleBrandDivisonEntity.Futurefield()";
            };
        }

        return newFunction;
    };



    //    static  Function<Integer , Function<Integer ,Integer  >   > getfunction = (a) -> {
//
//        System.out.println("param  .... "+a);
//        Function<Integer ,Integer  >    newFunction  ;
//        if(a== 1){
//            newFunction  = (aNested) -> {
//                return (aNested *aNested);
//            };
//        }else if(a== 2){
//            newFunction  = (aNested) -> {
//                return (aNested *aNested);
//            };
//        }
//        newFunction  = (aNested) -> {
//            return (aNested *aNested);
//        };
//
//        return newFunction;
//    };


}