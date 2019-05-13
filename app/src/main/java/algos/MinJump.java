package algos;

public class MinJump {

    static int minJumps(int arr[],
                        int n)
    {
        // jumps[0] will
        // hold the result
        int[] jumps = new int[n];
        int min;

        // Minimum number of jumps
        // needed to reach last
        // element from last elements
        // itself is always 0
        jumps[n - 1] = 0;


        // Start from the second
        // element, move from right
        // to left and construct the
        // jumps[] array where jumps[i]
        // represents minimum number of
        // jumps needed to reach arr[m-1]
        // from arr[i]
        for (int i = n - 2; i >= 0; i--)
        {
            // If arr[i] is 0 then arr[n-1]
            // can't be reached from here
            if (arr[i] == 0)
                jumps[i] = Integer.MAX_VALUE;

                // If we can direcly reach to
                // the end point from here then
                // jumps[i] is 1
            else if (arr[i] >= n - i - 1)
                jumps[i] = 1;

                // Otherwise, to find out
                // the minimum number of
                // jumps needed to reach
                // arr[n-1], check all the
                // points reachable from
                // here and jumps[] value
                // for those points
            else
            {
                // initialize min value
                min = Integer.MAX_VALUE;

                // following loop checks
                // with all reachable points
                // and takes the minimum
                for (int j = i + 1; j < n &&
                        j <= arr[i] + i; j++)
                {
                    if (min > jumps[j])
                        min = jumps[j];
                }

                // Handle overflow
                if (min != Integer.MAX_VALUE)
                    jumps[i] = min + 1;
                else
                    jumps[i] = min; // or Integer.MAX_VALUE
            }
        }

        return jumps[0];
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = {2,3,1,0,4}; //  {1, 3, 6, 1, 0, 9};
        int size = arr.length;
//        System.out.println("Minimum number of" +
//                " jumps to reach end is " +
//                minJumps(arr, size));


        System.out.println("Minimum number of" +
                " jumps to reach end is " +
                minJumps2(arr, size));

    }

    private static int minJumps2(int[] arr, int n) {
        int jumps[] = new int[n];  // jumps[n-1] will hold the
        // result
        int i, j;

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;  // if first element is 0,
        // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++)
        {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++)
            {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
                {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n-1];
    }




}

