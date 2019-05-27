package algos;

public class ThreeIncreaseNumberSet {


    public static void main(String []s){
        int ar[] = {3,2,4,1,7,5,8};// {3,9,7,6,5,8};; //  {1,6,4,3,9}    {3,9,7,6}

        System.out.println(increasingTriplet(ar));
    }

        public  static boolean increasingTriplet(
                int[] nums) {

            // start with two largest values, as soon as
            // we find a number bigger than both, while
            // both have been updated, return true.
            int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;

            for (int n : nums) {

                // update small if n is smaller than both
                if (n <= small) {
                    small = n;
                }

                // update big only if greater than small but
                // smaller than big
                else if (n <= big) {
                    big = n;
                }

                // return if you find a number bigger than
                // both
                else
                    return true;
            }
            return false;
        }
}
