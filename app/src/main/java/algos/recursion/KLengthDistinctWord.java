package algos.recursion;

public class KLengthDistinctWord {

    public static void main(String [] s){
        String str = "abc";
        int k =2;
        Character spots[] = new Character[k];

//        generateWords(0,str,0,k,spots);
        generateSelection(str,2,"");
    }


    public static void generateWords(int cc,String ustr,int ssf,int ts,Character [] spots){
        if(cc == ustr.length()){
            if(ssf == ts){
                for(int i=0;i<spots.length;i++ ){
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }
        char ch = ustr.charAt(cc);
        for(int i =0; i < spots.length ; i++){
            if(spots[i] == null){
                spots[i] = ch;
                generateWords(cc+1,ustr,ssf+1,ts,spots);
                spots[i] = null;
            }
        }
        generateWords(cc+1,ustr,ssf,ts,spots);
    }


    // for https://www.youtube.com/watch?v=fy5mFaHVuRs&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=16
    public static void generateSelection(String str, int seqLength, String answer) {

        if (answer.length() == seqLength) {
            System.out.println(answer);
        }
        if (str.length() == 0) {
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String substr = str.substring(i + 1);
            generateSelection(substr, seqLength, answer + c);
        }

    }
}
