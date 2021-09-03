package algos.recursion;

import java.util.ArrayList;

public class AllSubSequence {


    static  String seq= "ab";
    public static void  main(String []s){


        ArrayList<String> subSequenceList = getAllSubSequence(seq);

        System.out.println("sub seq  "+subSequenceList);
    }


    static ArrayList<String> getAllSubSequence(String seq) {

        ArrayList<String> subSequenceList = new ArrayList<>();

        if (seq.length() == 0) {
            ArrayList<String> result = new ArrayList<>();
            result.add(" ");
            return result;
        }

        char ch = seq.charAt(0);
        String restSubStr = seq.substring(1);
        ArrayList<String> childSubSequenceList = getAllSubSequence(restSubStr);
        for (String s : childSubSequenceList) {
            subSequenceList.add(s);
            subSequenceList.add(s + ch);
        }

        return subSequenceList;
    }


}
