package algos;

public class StairsJumpCount {

    public static int totalWays(int n)
    {
        // create an array of n+1 size for storing solutions to the sub-problems
        int[] lookup = new int[n + 1];

        // base case: 1 way (with no steps)
        lookup[0] = 1;

        // There is only 1 way to reach the 1st stair
        lookup[1] = 1;

        // There are 2 ways to reach the 2nd stair
        lookup[2] = 2;

        for (int i = 3; i <= n; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2] + lookup[i - 3];
        }

        return lookup[n];
    }

    public static void main(String[] args)
    {
        int n = 4;
        System.out.println("Total ways to reach the " + n + "'th stair are "
                + totalWays(n));


        int jump[] = {1,2,3};
        int noOfStair = 4;
        System.out.println("jumpwaysjumpways Total ways to reach the " + n + "'th stair are "
                + jumpways(jump,noOfStair));


    }



    // my approch for this using dp

    public static int jumpways(int[] jump, int noOfStair) {

        int stairWays[] = new int[noOfStair];
        for (int i = 0; i < noOfStair; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < jump.length; k++) {
                    if (((j + 1) + jump[k]) == i + 1) {
                        stairWays[i] = stairWays[i] + stairWays[j] ;  
                    }
                }
            }

            for (int k = 0; k < jump.length; k++) {
                if (jump[k] == i + 1) {
                    stairWays[i] = stairWays[i] + 1;
                }
            }
        }


        return stairWays[noOfStair - 1];


    }







}
