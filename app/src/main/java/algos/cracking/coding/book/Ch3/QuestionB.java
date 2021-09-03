package algos.cracking.coding.book.Ch3;

import algos.cracking.coding.book.CtCILibrary.AssortedMethods;

public class QuestionB {
    public static void printStacks(MultiStack stacks) {
        //System.out.println(stacks.stackToString(0));
        //System.out.println(stacks.stackToString(1));
        //System.out.println(stacks.stackToString(2));
        System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
    }

    public static void main(String [] args) throws Exception  {
        MultiStack stacks = new MultiStack(3, 4);
//        printStacks(stacks);
//        stacks.push(0, 10);
//        printStacks(stacks);
//        stacks.push(1, 20);
//        printStacks(stacks);
//        stacks.push(2, 30);
//        printStacks(stacks);
//
//        stacks.push(1, 21);
//        printStacks(stacks);
//        stacks.push(0, 11);
//        printStacks(stacks);
//        stacks.push(0, 12);
//        printStacks(stacks);
//
//        stacks.pop(0);
//        printStacks(stacks);
//
//        stacks.push(2, 31);
//        printStacks(stacks);
//
//        stacks.push(0, 13);
//        printStacks(stacks);
//        stacks.push(1, 22);
//        printStacks(stacks);
//
//        stacks.push(2, 31);
//        printStacks(stacks);
//        stacks.push(2, 32);
//        printStacks(stacks);
//        stacks.push(2, 33);
//        printStacks(stacks);
//        stacks.push(2, 34);
//        printStacks(stacks);
//
//        stacks.pop(1);
//        printStacks(stacks);
//        stacks.push(2, 35);
//        printStacks(stacks);




        ////// testing

        printStacks(stacks);
        stacks.push(0, 1);
        stacks.push(2, 2);
        stacks.push(2, 3);
        stacks.push(2, 4);
        stacks.push(2, 5);
        printStacks(stacks);
        stacks.push(2, 6);
        printStacks(stacks);

        System.out.println("Final Stack: " + AssortedMethods.arrayToString(stacks.getValues()));
    }
}