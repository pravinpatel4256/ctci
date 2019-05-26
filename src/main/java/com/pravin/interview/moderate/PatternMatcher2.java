package com.pravin.interview.moderate;

public class PatternMatcher2 {

    public boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;
        int size = value.length();

        char char1 = pattern.charAt(0);
        char char2 = char1 == 'a' ? 'b' : 'a';

        int char1Count = findCount(pattern, char1);
        int char2Count = findCount(pattern, char2);

        int maxChar1PatternSize = size/char1Count;

        if (char2Count == 0) {
            String a = value.substring(0, maxChar1PatternSize);
            String decoded = decode(pattern, a, null);
            return decoded.equals(value);
        }

        int firstChar2 = pattern.indexOf(char2);

        for (int p1Size = 0 ; p1Size <= maxChar1PatternSize; p1Size++) {
            int remainLen = size - p1Size*char1Count;
            String p1Pattern = value.substring(0, p1Size);
            if(remainLen%char2Count == 0){
                int char2Index = firstChar2 * p1Size;
                int char2Size = remainLen/char2Count;
                String p2Pattern = value.substring(char2Index, char2Index+char2Size);
                if(value.equals(decode(pattern, p1Pattern, p2Pattern))){
                    System.out.println(p1Pattern);
                    System.out.println(p2Pattern);
                    return true;
                }

            }

        }


        return false;
    }

    private int findCount(String pattern, char c) {
        long aLong = pattern.chars().boxed().filter(x -> (char) x.intValue() == c).count();

        return (int) aLong;
    }

    private String decode(String pattern, String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        char first = pattern.charAt(0);
        for (char c : pattern.toCharArray()) {
            if (c == first) {
                stringBuilder.append(a);
            } else {
                stringBuilder.append(b);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PatternMatcher2  p = new PatternMatcher2();
        boolean isMatched = p.doesMatch("aaaaaa", "catcatcatcatcatcat");
        System.out.println(isMatched);

    }
}
