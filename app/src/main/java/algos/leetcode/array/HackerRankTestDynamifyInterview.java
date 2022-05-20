package algos.leetcode.array;

import java.util.List;

public class HackerRankTestDynamifyInterview {

    static  String [] players = {"Louise","Richard"};

    public static void main(String []s){
        String test =  "13174607262084689114";
        counterGame(test);

    }
    public static void counterGame(    List<String> tests) {
        for(String test:tests){
            counterGame(test);
        }
    }


    public static void counterGame(   String test){

        Long turn =1L;


        try{
            Long number = Long.parseLong(test);
            if(number == 1 ){
                System.out.println(  players[1]);
                return;
            }
            while (number  >1){

                boolean isNumberPowerOfTwo =  isNumberPowerOfTwo(number);

                if(isNumberPowerOfTwo){
                    number = number/2;
//                System.out.println("  nearestMaxPowerOfTwo "+  number);
                }else{

                    Long nearestMaxPowerOfTwo=   getNearestMaxPowerOfTwo(number);
//                System.out.println("NOT .. nearestMaxPowerOfTwo "+  nearestMaxPowerOfTwo);
                    number = number -nearestMaxPowerOfTwo;
                }

                turn++;
            }
            printWinner(turn);
        }catch (NumberFormatException e){
            System.out.println(".......NumberFormatException "+  e.getLocalizedMessage());
            e.printStackTrace();
        }
//        9,223,372,036,854,775,807
//        13,174,607,262,084,689,114

    }



    static Long getNearestMaxPowerOfTwo(Long num) {
        Long p = 1L;
        while (num / p > 1){
            p = p*2;
        }
        return p;

    }

    static boolean isNumberPowerOfTwo(Long num) {
        boolean isPowerOfTwo = false;
        Long p = 1L;
        if(num < 2){
            return isPowerOfTwo;
        }
        while (num / p > 1){
            p = p*2;
        }
        if(num % p == 0){
            isPowerOfTwo = true;
        }
        return isPowerOfTwo;
    }


    public static void printWinner(   Long turn){
        if(turn % 2 == 0){
            System.out.println(   players[0]);
        }else{
            System.out.println(  players[1]);
        }

    }



}
