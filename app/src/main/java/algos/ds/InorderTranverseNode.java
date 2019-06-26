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

            // traverse the tree
            while (curr != null || s.size() > 0) {

            /* Reach the left most InorderTranverseNode of the
            curr InorderTranverseNode */
                while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                    s.push(curr);
                    curr = curr.left;
                }

                /* Current must be NULL at this point */
                curr = s.pop();

                System.out.print(curr.data + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
                curr = curr.right;
            }
        }


    }

    public static void secondAproch(BinaryTree tree) {

        Stack<InorderTranverseNode> stack = new Stack<InorderTranverseNode>();
        InorderTranverseNode curr = tree.root;
        if (tree.root != null) {
            stack.push(curr);

            while (stack.size() > 0) {

                InorderTranverseNode iterate = stack.peek();

                if (iterate != null) {
                    if (iterate.left != null) {
                        stack.push(iterate.left);
                    } else {
                        System.out.print("  " + iterate.data + " > ");
                        InorderTranverseNode nextNode = stack.pop();
                        System.out.print(" >> " + nextNode.data + " >>");
                        if (nextNode.right != null) {
                            stack.push(nextNode.right);
                        }
                    }

                } else {
                   // nothing
                }


            }


        } else {
            System.out.println("secondAproch empty tree");
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

        secondAproch(tree);
    }
}
