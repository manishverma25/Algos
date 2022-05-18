package algos.leetcode;

public class RemoveDuplicateFromArray {

    public static void main(String []s){
       int []arr = {0,0,1,1,1};
//       int []arr = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(" TEST    ");
        System.out.println(" removeDuplicateFromSortedArray    "+removeDuplicates(arr));
        Util.print(arr);

    }

    public static int removeDuplicates(int []nums){

        int diffNumbers = 0;

        int writePointer = 0,readPointer = 0;

        while(readPointer < nums.length ){
            readPointer  =   getNextReadPointer(readPointer,nums);
            nums[writePointer++] = nums[readPointer++];
            diffNumbers++;
        }
        return diffNumbers;
    }

    public static int getNextReadPointer(int counterPointer,int []nums){
        int nextReadpointer  = counterPointer;
        while(nextReadpointer < nums.length -1  && nums[nextReadpointer] == nums[nextReadpointer+1] ){
            nextReadpointer++;
        }
        return nextReadpointer;
    }




    public int removeDuplicatesSol(int[] nums) {
        if (nums.length == 0) return 0;
        int w = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[w]) {
                w++;
                nums[w] = nums[r];
            }
        }
        return w + 1;
    }

}




















