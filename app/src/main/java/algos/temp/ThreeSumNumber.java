package algos.temp;



import java.io.*;
        import java.util.ArrayList;
        import java.util.HashMap;


// Main class should be named 'Solution'
class ThreeSumNumber {
    public static void main(String[] args) {
        System.out.println("Hello, World");

        int arr[] = new int []{2, 1, 3, 5, 4};
        // int arr2[] = new int []{1,2,3,4,5,6,7,8,9,10};

        ArrayList< ArrayList< Integer>>   result = give2Sum(8,arr);
        System.out.println("result is "+result);
        printoutPut(result);


    }

    public static void printoutPut(ArrayList< ArrayList< Integer>>  result  ){
        System.out.println(" Found solution ");
        for(int  i =0 ;i < result.size();i++){

            System.out.println("  ");
            ArrayList< Integer> foundSet =   result.get(i);

            for(int j = 0;j < foundSet.size();j++){
                System.out.print(" "+foundSet.get(j));
            }
            //  System.out.print(" "+result[i]);
        }
    }



    public static  int [] getExcludeedArray(int arr[],int pos){

        int excludedArray [] = new int[arr.length];

        for(int i =0; i < arr.length;i++)
        {
            if(i != pos){
                excludedArray[i] = arr[i]  ;
            }
        }
        return excludedArray;

    }


    public static  ArrayList< ArrayList< Integer>> give3Sum(int sum, int arr[]){

        ArrayList< ArrayList< Integer>> resultList = new ArrayList<>();
        int result [] = null;
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(int i =0 ; i < arr.length;i++ ){

            ArrayList< ArrayList< Integer>> resulttwoSumList =   give2Sum(sum-arr[i],getExcludeedArray(arr,i));
            if(resulttwoSumList.size()>0 ){

                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                for(int listindex= 0;listindex < resulttwoSumList.size();listindex++){

                    ArrayList< Integer> twoItemList = resulttwoSumList.get(listindex);

                    for(int index= 0;index < twoItemList.size();index++){
                        list.add(twoItemList.get(index));
                    }
                }

                resultList.add(list);
            }
            resulttwoSumList.clear();

        }
        return resultList;
    }



    public static  ArrayList< ArrayList< Integer>> give2Sum(int sum, int arr[]){

        ArrayList< ArrayList< Integer>> resultList = new ArrayList<>();
        int result [] = null;
        HashMap<Integer,Integer> hashmap = new HashMap();


        for(int i =0 ; i < arr.length;i++ ){

            Integer foundData = hashmap.get(arr[i]);
            if(foundData != null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(foundData);
                list.add(arr[i]);

                resultList.add(list );
                // return new int[]{foundData,arr[i]};
            }else{
                hashmap.put(sum-arr[i],arr[i]);
            }

        }
        return resultList;
    }

}



// Find Possible 3Sum of target in Array
// [2, 1, 3, 5, 4] target=8 >> ['2, 1, 5', '1, 3, 4']
// Unique number in each element
// '2, 2, 4' X
// '2, 1, 5', '1, 2, 5'

// [2, 1, 3, 5, 4]




// 2, 1, 5
// 1, 2, 5
