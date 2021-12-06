package algos.recursion;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class EqualSumPartition {
    static int []arr  = {1,2,3,4,5,6};
//    static ArrayList<Integer> sum1 = new ArrayList<>();
//    static ArrayList<Integer> sum2 = new ArrayList<>();
public static String HEXA_HEADER_FINGERPRINT= "46 4d 52 00 20 32 30 00 00 00 01 09 00 00 01 20 01 60 00 c5 00 c5 01 00 00 00 57 2F";
    public static String HEXA_FOOTER_FINGERPRINT= "00 00";



    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        Charset charset = Charset.forName("ASCII");
        return new String(hexDigits);
    }

    /***
     *
     * Convert bytearray to hexa data
     */

    public static String convertToHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }

    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
        }
        return result.toString();
    }


    public static String addHeaderAndFooter(String data,byte[] byteArray,String t1) {
        String convertedData =  HEXA_HEADER_FINGERPRINT + ""+ t1+ ""+HEXA_FOOTER_FINGERPRINT;
        return convertedData;
    }

    public static void main(String []args){
        System.out.println("Hello World");

        String data = "manish";
        System.out.println("data "+data);
        Charset charset = Charset.forName("UTF-8");


        byte[] byteArrray = data.getBytes(charset);
        System.out.println("byteArrray "+byteArrray.toString());

        String str = new String(byteArrray, charset);
        System.out.println(" byteArrray in str "+str);
        System.out.println("testing");

        String hex = convertToHexString(byteArrray);

        System.out.println("converted to hex "+hex);

        String hex2 = hex(byteArrray);

        System.out.println("converted to hex "+hex2);



    }


}
