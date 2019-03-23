package com.pravin.interview.chapter1;

public class Problem1_3 {

    static String makeURLfi(String str){

        int strLength = str.length() ;
        String urlString = str.trim().replaceAll(" ", "%20");
        return urlString.length() == strLength ? urlString : "Not valid";
    }

    static String makeURLfiArray(String str){
        int count = 0;
        char[] charArray = str.toCharArray();
         for (Character character: str.trim().toCharArray()) {

             if (character == ' ') {
                 charArray[count] = '%';
                 charArray[count+1] = '2';
                 charArray[count+2] = '0';
             }
             count++;
         }

         return new String(charArray);
    }


    public static void main(String[] args) {

        System.out.println(makeURLfiArray("Mr John Smith      "));
    }
}
