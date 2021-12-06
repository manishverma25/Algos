package algos.interviewquestions;

public class ArrrangeNegativeOnLeft {

    static int arr[] = {-2,7,-1,6,3,-9,4,8,-3};
    public static void main(String []s){

        printArr();
        makeLeftNegativeWithOrder();
        System.out.println("after re arrange");
        printArr();
    }


    public static void printArr(){
        System.out.println();
        for(int pos =0;pos <arr.length;pos++){
            System.out.print(" "+arr[pos]);
        }

        System.out.println();
    }

    public static void makeLeftNegativeWithOrder(){

        int leftPostivePos = findPositivePos(0);
        int rightNegativePos   = findNegativePos(leftPostivePos+1);

        while(   leftPostivePos > 0 && leftPostivePos < arr.length-1 &&
                ( rightNegativePos > 0 && rightNegativePos < arr.length ) ){

            int temp = arr[leftPostivePos];
            arr[leftPostivePos] = arr[rightNegativePos];
            arr[rightNegativePos] = temp;

              leftPostivePos = findPositivePos(leftPostivePos+1);
              rightNegativePos   = findNegativePos(leftPostivePos+1);
        }
    }


    static int findPositivePos(int start){

        for(int pos = start; pos < arr.length; pos++){

            if(arr[pos]> 0 )
                return pos;
        }

        return -1;
    }

    static int findNegativePos(int start){

        for(int pos = start; pos < arr.length; pos++){

            if(arr[pos]< 0 )
                return pos;
        }

        return -1;
    }
}
