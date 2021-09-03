package algos.recursion;

import java.util.ArrayList;

public class printStairPaths {
    static int choices[] = new int[]{1,2,3};
    static int stairs = 4;
    static ArrayList<String> stairOptions = new ArrayList<>();

    public static void main(String[] s) {

        printAllStaris("", stairs);
//        printAllStaris2("", stairs);

    }

    static void printAllStaris(String stairOptions, int leftStairs) {
        if (leftStairs == 0) {
            printOptions2(stairOptions);
            return;
        } else if (leftStairs < 0) {
            return;
        }

        for (int option = 0; option < choices.length; option++) {
            String newoption = stairOptions + ";"+choices[option];
            printAllStaris(newoption, leftStairs - choices[option]);
        }

    }


    static void printAllStaris2(String stairOptions, int leftStairs) {
        if (leftStairs == 0) {
            printOptions2(stairOptions);
            return;
        } else if (leftStairs < 0) {
            return;
        }


        String option1 = stairOptions + ";"+1;
        printAllStaris2(option1, leftStairs - 1);

        String option2 = stairOptions + ";"+2;
        printAllStaris2(option2, leftStairs - 2);
//        String option3 = stairOptions + ";"+3;
//        printAllStaris2(option3, leftStairs - 3);

    }


    public static void printOptions(ArrayList<String> stairOptions) {
        for (String steps : stairOptions) {
            System.out.println("setps are " + steps);
        }
    }

    public static void printOptions2(String  stairOptions) {
            System.out.println("setps are " + stairOptions);
//        }
    }
}
