package algos.leetcode.interviewbit.bitwise;

public class Bitwise2 {


    public static void main(String[] s) {

        int A[] = {1, 2, 3, 1, 2, 4};
//        int A []= {1, 2,2,5};
        int r[] = singlleNUmbers(A);

        for (int i = 0; i < r.length; i++) {
            System.out.print(" " + r[i]);
        }
    }


    public static int[] singlleNUmbers(int[] A) {

        int r[] = new int[2];

        long sumSet = 0;
        long sum = 0;
        long sumUnSet = 0;

        for (int i = 0; i < A.length; i++) {
            sum = sum ^ A[i];
        }

        int setBitNumber = -1;

        for (int i = 0; i <= 31; i++) {
            if ((sum >> i & 1) == 1) {
                setBitNumber = i;
                break;
            }
        }

        if (setBitNumber != -1) {
            for (int j = 0; j < A.length; j++) {

                if ((A[j] >> setBitNumber & 1) == 1) {
                    sumSet = sumSet ^ A[j];
                } else {
                    sumUnSet = sumUnSet ^ A[j];
                }
            }

        }
        if (sumUnSet > sumSet) {
            r[0] = (int) sumSet;
            r[1] = (int) sumUnSet;

        } else {
            r[0] = (int) sumUnSet;
            r[1] = (int) sumSet;
        }


        return r;
    }

    public int solve(int A) {
        long N = A + 1, mod = 1000 * 1000 * 1000 + 7;
        long ans = 0, pow2 = 1;
        for (int i = 0; i < 32; i++) {
            ans += ((N / (pow2 << 1)) * pow2) % mod + Math.max(0, N % (pow2 << 1) - pow2);
            ans %= mod;
            pow2 <<= 1;
        }
        return (int) ans;
    }

    public int countOneSum(int A) {
        long N = A + 1, mod = 1000 * 1000 * 1000 + 7;
        long ans = 0, pow2 = 1;
        for (int i = 0; i < 32; i++) {
            ans += ((N / (pow2 << 1)) * pow2) % mod + Math.max(0, N % (pow2 << 1) - pow2);
            ans %= mod;
            pow2 <<= 1;
        }
        return (int) ans;
    }

//    int countBits(int N){
//        N++;
//        int ans=N/2;
//        int sz=log(N);
//        int pow2=2;
//        while(pow2<=N)
//        {
//            int totalgroups=N/pow2;//having both groups of 0 and 1
//            int totalOnegroups=totalgroups/2;//full groups that are having only 1
//            int sz=pow2;
//            ans+=totalOnegroups*sz;//total number of ones in full groups
//            if(totalgroups%2)
//            {
//                int val=pow2;
//                ans+=(N%val);//(N%val) number o
//
//              }
//    pow2 *2
//         }
//

/*****
 For example A = 5;
 0 = 0000
 1 = 0001
 2 = 0010
 3 = 0011
 4 = 0100
 5 = 0101

 So, we will iterate till the number of bits in the number. And we don’t have to iterate every single number in the range from 1 to A.
 We will perform the following operations to get the desired result.

 First of all, we will add 1 to the number in order to compensate 0. As the binary number system starts from 0. So now A = A + 1.
 We will keep the track of the number of set bits encountered till now. And we will initialise it with A/2.
 We will keep one variable which is a power of 2, in order to keep track of bit we are computing.
 We will iterate till the power of 2 becomes greater than A.
 We can get the number of pairs of 0s and 1s in the current bit for all the numbers by dividing A by current power of 2.
 Now we have to add the bits in the set bits count. We can do this by dividing the number of pairs of 0s and 1s by 2 which will give us
 the number of pairs of 1s only and after that, we will multiply that with the current power of 2 to get the count of ones in the groups.
 Now there may be a chance that we get a number as number of pairs, which is somewhere in the middle of the group i.e. the number of 1s are less than
 the current power of 2 in that particular group. So, we will find modulus and add that to the count of set bits.

 Time Complexity : O(logA)*/
}
