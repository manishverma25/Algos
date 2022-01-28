package algos.leetcode;

import java.util.HashMap;
import java.util.Iterator;

public class Microsoft2 {


    static int callTimeForCutOfRateInMinutes = 5;

    static String S= "00:01:07,400-234-090\n" +
            "00:05:01,701-080-080\n" +
            "00:05:00,400-234-090";
    public static void  main(String s[]){
        int arr[]= {1, 3, 6, 4, 1, 2};
        System.out.println("solution found :  "+solution(S));

    }

    public static int solution(String S) {
        int price = 0;

        String callDetails[] = S.split("\n");
        HashMap<String,Integer> phoneToCallTimeMapping = new HashMap<>();

        for( String call : callDetails){
            String callTime = call.split(",")[0];
            String phNo = call.split(",")[1];
            int callTimeInSeconds = getCallTimeInSeconds(callTime);
//           System.out.println("call:  "+call);   System.out.println("phNo:  "+phNo);   System.out.println("callTime :  "+callTime);  System.out.println("callTimeInSeconds:  "+ callTimeInSeconds);
            Integer  previousCallTime =  phoneToCallTimeMapping.get(phNo);
            if(previousCallTime!=null){
                phoneToCallTimeMapping.put(phNo, previousCallTime + callTimeInSeconds);
            }else{
                phoneToCallTimeMapping.put(phNo, callTimeInSeconds);
            }
        }

        String maxCallDurationPhoneNumber =  getMaxCallDurationPhoneNumber(phoneToCallTimeMapping);
        price = getAllCallPrice(maxCallDurationPhoneNumber,S);
//        System.out.println("@@@@  price :  "+price);
        return price;

    }


    public static int getCallTimeInSeconds(String callTime ){
        int callTimeInMinutes = 0;
        String callTimeInHHMMSS []= callTime.split(":");
        callTimeInMinutes= callTimeInMinutes +  Integer.parseInt(callTimeInHHMMSS[0])*60*60; //hr
        callTimeInMinutes= callTimeInMinutes +  Integer.parseInt(callTimeInHHMMSS[1])*60; //mm
        callTimeInMinutes= callTimeInMinutes +  Integer.parseInt(callTimeInHHMMSS[2]);

        return callTimeInMinutes;
    }


    public static int getAllCallPrice(    String maxCallDurationPhoneNumber ,String callData){
        int totalPrice  =0;
        String callDetails[] = callData.split("\n");

        for( String call : callDetails){
            String callTime = call.split(",")[0];
            String phoneNumber = call.split(",")[1];
            int callTimeInSeconds = getCallTimeInSeconds(callTime);

            if(phoneNumber.equalsIgnoreCase(maxCallDurationPhoneNumber)){
//                System.out.println("max call phoneNumber  "+phoneNumber +" so skipping it ..." );
            }else {
                if(callTimeInSeconds > callTimeForCutOfRateInMinutes *60 ){
                    int leftTimeInSec = callTimeInSeconds % 60;
                    int callDurationInMinutes = callTimeInSeconds /60;
//                    System.out.println("11 callDurationInMinutes ...  "+callDurationInMinutes   );
                    if(leftTimeInSec > 0){
//                        System.out.println("11 leftTimeInSec ...  "+leftTimeInSec  );
                        callDurationInMinutes++;
                    }
                    totalPrice = totalPrice +  150 * (callDurationInMinutes) ;
//                    System.out.println("calculationg 150  totalPrice ..."+totalPrice+"  callDurationInMinutes "+callDurationInMinutes  );
                }else{
                    int leftTimeInSec = callTimeInSeconds % 60;
                    int callDurationInMinutes = callTimeInSeconds /60;
//                    System.out.println("callDurationInMinutes ...  "+callDurationInMinutes   );
                    if(leftTimeInSec > 0){
//                        System.out.println("leftTimeInSec ...  "+leftTimeInSec  );
                        callDurationInMinutes++;
                    }
                    totalPrice = totalPrice +  3 * (callDurationInMinutes) ;

//                    System.out.println("calculationg 3333 totalPrice ..."+totalPrice+"  callDurationInMinutes "+callDurationInMinutes  );
                }
            }

//            System.out.println("totalPrice ... "+totalPrice  );
        }

        return totalPrice;
    }

    public static String getMaxCallDurationPhoneNumber(    HashMap<String,Integer> phoneToCallTimeMapping ){
        String maxCallDurationPhoneNumber  = "";
        int maxCAllDuration = Integer.MIN_VALUE;

        Iterator<String> itr = phoneToCallTimeMapping.keySet().iterator();
        while (itr.hasNext()){
            String phoneNumber = itr.next();
            Integer callDuration = phoneToCallTimeMapping.get(phoneNumber);


            if(callDuration > maxCAllDuration){
                maxCAllDuration =  callDuration ;
                maxCallDurationPhoneNumber =phoneNumber;
            }

//            System.out.println("in hashmap key "+phoneNumber + ", value " + callDuration);
        }

        return maxCallDurationPhoneNumber;
    }
}
