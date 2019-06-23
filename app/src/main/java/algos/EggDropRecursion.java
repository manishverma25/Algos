package algos;

public class EggDropRecursion {

    public int getDrops(int eggs, int floors) {
        //base case 1:
        //if floors = 0 then no drops are required OR floors = 1 then 1 drop is required
        if (floors == 0 || floors == 1)
            return floors;

        //base case 2:
        //if only one egg is there then drops = floors
        if (eggs == 1)
            return floors;

        int minimumDrops = Integer.MAX_VALUE, tempResult;
        //check dropping from all the floors 1 to floors and pick the minimum among those.
        //for every drop there are 2 scenarios - a) either egg will break b) egg will not break
        for (int i = 1; i <= floors; i++) {
            //for the worst case pick the maximum among a) and b)
            tempResult = Math.max(getDrops(eggs - 1, i - 1), getDrops(eggs, floors - i));
            minimumDrops = Math.min(tempResult, minimumDrops);
        }
        return minimumDrops + 1;
    }

    public static void main(String[] args) {
        EggDropRecursion eggDropRecursion = new EggDropRecursion();
        int eggs = 4;
        int floors = 3;
        System.out.println(" AAA drops required  with eggs:" +
                " " + eggs + " and floors:" + floors + " is: " + eggDropRecursion.getDrops(eggs, floors));
        System.out.println(" BBBB  drops required  with eggs:" +
                " " + eggs + " and floors:" + floors + " is: " + eggDropRecursion.egg_drop(floors, eggs));
    }


    public int getDropsDP(int eggs, int floors) {

        int[][] eggDrops = new int[eggs + 1][floors + 1];
        for (int i = 1; i <= eggs; i++) {
            eggDrops[i][0] = 0;
            eggDrops[i][1] = 1;
        }
        for (int i = 1; i <= floors; i++) {
            eggDrops[1][i] = i;
        }

        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                eggDrops[i][j] = Integer.MAX_VALUE;
                int tempResult;
                for (int k = 1; k <= j; k++) {
                    tempResult = 1 + Math.max(eggDrops[i - 1][k - 1], eggDrops[i][j - k]);
                    eggDrops[i][j] = Math.min(tempResult, eggDrops[i][j]);
                }
            }
        }
        // eggDrops[eggs][floors] will have the result : minimum number of drops required in worst case
        return eggDrops[eggs][floors];
    }


    int egg_dropR(int eggs, int floors) {
        if (floors == 0 || floors == 1 || eggs == 1) {
            return floors;
        }
        int min_drops = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            // If the egg breaks on floor x, we only need to test floors up to the
            // x-1th floor. We also have one less egg since the egg broke.
            int egg_break = egg_dropR(eggs - 1, i - 1);
            // If the egg did not break on floor x, we only need to test floors
            // starting from the floor-xth floor onwards. The number of eggs
            // does not change since the egg did not break.
            int egg_not_break = egg_dropR(eggs, floors - i);
            // Find the number of drops necessary in the WORST CASE scenario.
            // Don't forget to add one to include the current drop.
            int drops = Math.max(egg_break, egg_not_break) + 1;
            System.out.println("  i  = " + i + ",  eggs =  " + eggs + ", floor =  " + floors + " ,egg_break =  " + egg_break + " ,egg_not_break = " + egg_not_break + ", drop  >>> = " + drops);
            if (drops < min_drops) {
                min_drops = drops;
            }
        }

        return min_drops;
    }


    int egg_drop(int floors, int eggs) {
        int[][] memo = new int[floors + 1][eggs + 1];
        for (int floor = 0; floor <= floors; floor++) {
            for (int egg = 0; egg <= eggs; egg++) {
                if (floor == 0 || egg == 0) {
                    memo[floor][egg] = 0;
                } else if (floor == 1) {
                    memo[floor][egg] = 1;
                }
                else if (egg == 1) {
                    memo[floor][egg] = floor;
                } else {
                    memo[floor][egg] = Integer.MAX_VALUE;
                    // Consider each drop from first to current floor
                    for (int x = 1; x <= floor; x++) {
                        // If the egg breaks on floor x, we only need to test floors up to the
                        // x-1th floor. We also have one less egg since the egg broke.
                        int egg_break = memo[x - 1][egg - 1];
                        // If the egg did not break on fl oor x, we only need to test floors
                        // starting from the floor-xth floor onwards. The number of eggs
                        // does not change since the egg did not break.
                        int egg_not_break = memo[floor - x][egg];
                        int drops = Math.max(egg_break, egg_not_break) + 1;
                        if (drops < memo[floor][egg]) {
                            memo[floor][egg] = drops;
                        }
                    }

                }
            }
        }

        return memo[floors][eggs];
    }
}
