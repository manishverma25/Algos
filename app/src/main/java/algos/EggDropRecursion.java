package algos;

public class EggDropRecursion {

    public int getDrops(int eggs, int floors){
        //base case 1:
        //if floors = 0 then no drops are required OR floors = 1 then 1 drop is required
        if(floors==0 || floors==1)
            return floors;

        //base case 2:
        //if only one egg is there then drops = floors
        if(eggs==1)
            return floors;

        int minimumDrops=Integer.MAX_VALUE, tempResult;
        //check dropping from all the floors 1 to floors and pick the minimum among those.
        //for every drop there are 2 scenarios - a) either egg will break b) egg will not break
        for (int i = 1; i <=floors ; i++) {
            //for the worst case pick the maximum among a) and b)
            tempResult = Math.max(getDrops(eggs-1,i-1), getDrops(eggs, floors-i));
            minimumDrops = Math.min(tempResult,minimumDrops);
        }
        return minimumDrops + 1;
    }

    public static void main(String[] args) {
        EggDropRecursion eggDropRecursion = new EggDropRecursion();
        int eggs = 2;
        int floors = 2;//10;
        System.out.printf("(Recursion) Minimum number of drops required in worst case with eggs: " + eggs + " and floors:" + floors + " is: " + eggDropRecursion.getDrops(eggs,floors));
    }


    public int getDropsDP(int eggs, int floors){

        int [][] eggDrops = new int [eggs+1][floors+1];
        //base case 1:
        //if floors = 0 then no drops are required // OR floors = 1 then 1 drop is required
        for (int i = 1; i <=eggs ; i++) {
            eggDrops[i][0] = 0;
            eggDrops[i][1] = 1;
        }
        //base case 2:
        //if only one egg is there then drops = floors
        for (int i = 1; i <=floors ; i++) {
            eggDrops[1][i] = i;
        }

        for (int i = 2; i <=eggs ; i++) {
            for (int j = 2; j <=floors ; j++) {
                eggDrops[i][j] = Integer.MAX_VALUE;
                int tempResult;
                for (int k = 1; k <=j ; k++) {
                    tempResult = 1 + Math.max(eggDrops[i-1][k-1], eggDrops[i][j-k]);
                    eggDrops[i][j] = Math.min(tempResult,eggDrops[i][j]);
                }
            }
        }
        // eggDrops[eggs][floors] will have the result : minimum number of drops required in worst case
        return eggDrops[eggs][floors];
    }
}
