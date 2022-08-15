package algos.leetcode.interviewbit.Array;

import java.util.ArrayList;

public class Matrix3 {

    public static void main(String s[]) {

        int a[] = new int[]{-8, -7, -6};
//        int res = firstMissingPositive(a);
        int aa[][] =new int[][] {
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 1},
        };
//   11
//        ArrayList<Interval> ar =new ArrayList<>();
//        ar.add(new Interval(1,3));
//        ar.add(new Interval(7,10));
//        ar.add(new Interval(13,15));
//
//        Interval br =new Interval(2,11);

//        ArrayList<Interval> ar =new ArrayList<>();
////        ar.add(new Interval(1,3));
//        ar.add(new Interval(7,10));
//        ar.add(new Interval(13,15));
//
//        Interval br =new Interval(8,11);




        ArrayList<Interval> ar =new ArrayList<>();
////        ar.add(new Interval(1,3));
//        ar.add(new Interval(1,2));
//        ar.add(new Interval(3,6));
////        ar.add(new Interval(8,10));
//
//        Interval br =new Interval(10,8);




        ar.add(new Interval(1,3));
        ar.add(new Interval(5,7));
        ar.add(new Interval(9,11));

        Interval br =new Interval(2,10);

        ArrayList<Interval> resArr = insert(ar,br);
//        System.out.println(" r :  " +resArr);
        for(Interval i :resArr){
            System.out.println("   " +i.start + " "+i.end);
        }
    }


    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();

        if(newInterval.end < newInterval.start){
          int t =   newInterval.end;
            newInterval.end =   newInterval.start;
            newInterval.start =    t;
        }

        boolean isnewIntervalUsed = false;
        for (int index = 0; index <  intervals.size() ; index++){
            Interval interval = intervals .get(index);
            if(newInterval.end <  interval.start){  //1
                result.add(newInterval);
                isnewIntervalUsed = true;
                while(index <  intervals.size()){
                    result.add(intervals .get(index));
                    index++;
                }
            }else  if(newInterval.end <=  interval.end && newInterval.start >=  interval.start  ){  //2
                isnewIntervalUsed = true;
                while(index <  intervals.size()){
                    result.add(intervals .get(index));
                    index++;
                }
            }else   if( interval.end < newInterval.start  ){  //1
                result.add(interval);
            }else{
                newInterval.start = Math.min(newInterval.start ,interval.start );
                newInterval.end = Math.max(newInterval.end ,interval.end );
            }
        }
        if(!isnewIntervalUsed){
            result.add(newInterval);
        }

        return result;
    }




   static public class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }
}
