package algos.cracking.coding.book.timecomplexity;

public class Permutation {

    static  void permutation(String s){
        permutation(s,"");
    }

    static void permutation(String str, String prefix){
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String []s){
        permutation("abcd")  ;
    }
}
