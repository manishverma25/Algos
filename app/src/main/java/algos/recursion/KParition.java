package algos.recursion;

import java.util.ArrayList;


public class KParition {
    static int counter = 0;

    public static void main(String[] s) {
        int n = 3;
        int k = 2;
        ArrayList<ArrayList<Integer>> subsetList = new ArrayList();
        for (int i = 0; i < k; i++) {
            subsetList.add(new ArrayList<Integer>());
        }
        paritionaKSubset(1, n, k, 0, subsetList);
    }

    private static void paritionaKSubset(int i, int n, int k, int ssf, ArrayList<ArrayList<Integer>> subsetList) {
        System.out.println("called partitionaKSubset "+i+" n: "+n+" k :: "+k+ " ssf :"+ssf);
        if (i > n) {
            if (ssf == k) {
                counter++;
                for (ArrayList<Integer> set : subsetList) {
                    System.out.print(set + "");
                }
                System.out.println();
            }
            return;



            
        }
        for (int j = 0; j < subsetList.size(); j++) {
            if (subsetList.get(j).size() > 0) {
                subsetList.get(j).add(i);
                paritionaKSubset(i + 1, n, k, ssf, subsetList);
                subsetList.get(j).remove(subsetList.get(j).size() - 1);
            } else {
                subsetList.get(j).add(i);
                paritionaKSubset(i + 1, n, k, ssf + 1, subsetList);
                subsetList.get(j).remove(subsetList.get(j).size() - 1);
                break;
            }

        }

    }
}
