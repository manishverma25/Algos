package algos.leetcode.interviewbit.stack;

import static algos.leetcode.interviewbit.Linkedlist.ReverseList.createList;

import java.util.Stack;


public class StackProblem1 {

    public static  void main(String s[]) {

//        while (!stack.isEmpty()){
//            System.out.println("now poping");
//            String peek =  stack.peek();
//            String pop =  stack.pop();
//            System.out.println("peek "+peek+" pop "+pop);
//        }

        String abc = solve("abba");
        System.out.println("sub >>>>> "+abc);
    }

    public static String solve(String A) {
        String res = "";

        Stack<String> stack = new Stack<>();
        String t = A;
        for(int i = 0; i < t.length() ;i++){
            String sub = t.substring(i,i+1);
            System.out.println("sub "+sub);

            if(!stack.isEmpty() && sub.equalsIgnoreCase(stack.peek()) ){
                stack.pop();
            }else{
                stack.push(sub);
            }
        }

        while (!stack.isEmpty()){
            System.out.println("now poping");
            String pop =  stack.pop();
            System.out.println( " pop "+pop);
            res = pop+res;
        }
        return res;
    }
}
