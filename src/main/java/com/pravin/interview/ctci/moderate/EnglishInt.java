package com.pravin.interview.ctci.moderate;

import java.util.LinkedList;

public class EnglishInt {

    public static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    public static String hundred = "Hundred";
    public static String negative = "Negative";

    // 12930
    public String convert(int num){
        if (num == 0) {
            return smalls[0];
        }else if (num < 0) {
            return negative + " " + toEnglish(-1 * num);
        }
        return toEnglish(num);
    }

    private String toEnglish(int num) {
        LinkedList<String> list = new LinkedList<>();

        int bigCounter = 0;

        while (num > 0) {
             if (num % 1000 != 0) {
                 String chunk = convertPart(num % 1000) + "" + bigs[bigCounter];
                 list.addFirst(chunk);
             }
             num /= 1000;
            bigCounter++;
        }

        return listToString(list);
    }

    private String convertPart(int num) {
        LinkedList<String> parts  = new LinkedList<>();
        if (num >= 100) {
            parts.addLast(smalls[num/100]);
            parts.addLast(hundred);
            num %= 100;
        }

        if (num >= 10  && num <= 19) {
            parts.addLast(smalls[num]);
        }else if (num >= 20) {
            parts.add(tens[num/10]);
            num %= 10;
        }

        if (num >= 1 && num <= 9) {
            parts.addLast(smalls[num]);
        }
        return listToString(parts);
    }

    private String listToString(LinkedList<String> parts) {
        StringBuilder stringBuilder = new StringBuilder();

        while (!parts.isEmpty()) {
            stringBuilder.append(parts.pop());
            stringBuilder.append(" ");
        }

        return stringBuilder.toString() ;
    }


    public static void main(String[] args) {
        EnglishInt englishInt = new EnglishInt();
        System.out.println(englishInt.convert(-65612));
    }
}
