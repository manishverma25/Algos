package algos.ds;

import java.util.Stack;

public class InorderTranverseNode {

    int data;
    InorderTranverseNode left, right;

    public InorderTranverseNode(int item) {
        data = item;
        left = right = null;
    }

    /* Class to print the inorder traversal */
    static class BinaryTree {
        InorderTranverseNode root;

        void inorder() {
            if (root == null)
                return;
            Stack<InorderTranverseNode> s = new Stack<InorderTranverseNode>();
            InorderTranverseNode curr = root;
            while (curr != null || s.size() > 0) {
            /* Reach the left most InorderTranverseNode of the
            curr InorderTranverseNode */
                while (curr != null) {
                    /* place pointer to a tree node on   the stack before traversing  the node's left subtree */
                    s.push(curr);
                    curr = curr.left;
                }
                /* Current must be NULL at this point */
                curr = s.pop();
                System.out.print(curr.data + " ");
                /* we have visited the node and its left subtree.  Now, it's right  subtree's turn */
                curr = curr.right;
            }
        }


    }

    public static void secondApproach(BinaryTree tree) {
        Stack<InorderTranverseNode> stack = new Stack<InorderTranverseNode>();
        InorderTranverseNode curr = tree.root;
        if (tree.root != null) {
            stack.push(curr);

            while (curr != null && stack.size() > 0) {
                while (curr != null) {
                    if (curr.left != null) {
                        stack.push(curr.left);
                    }
                    curr = curr.left;
                }
//                if (stack.size() > 0) {
                    curr = stack.pop();
                    System.out.print("  " + curr.data + " > ");
                    if (curr.right != null) {
                        stack.push(curr.right);
                        curr = curr.right;
                    }
//                }
            }
        }
    }

    public static void main(String args[]) {

        /* creating a binary tree and entering
        the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new InorderTranverseNode(1);
        tree.root.left = new InorderTranverseNode(2);
        tree.root.right = new InorderTranverseNode(3);
        tree.root.left.left = new InorderTranverseNode(4);
        tree.root.left.right = new InorderTranverseNode(5);
        tree.inorder();

        secondApproach(tree);
    }
}
