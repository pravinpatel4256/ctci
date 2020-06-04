package com.pravin.interview.ctci.chapter1;

public class OneEditAway {

    public boolean isOneEditAway(String s1, String s2){

        if (s1 == null || s2 == null) {
            return false;
        }
        else if (s1.length() == s2.length()) {
            return oneReplaceAway(s1, s2);
        }else if (s1.length() - 1 == s2.length()) {
            return oneInsertAway(s2, s1);
        }else if (s1.length() + 1 == s2.length()) {
            return oneInsertAway(s1, s2);
        }else {
            return false;
        }
    }

    private boolean oneInsertAway(String smallStr, String longStr) {
        int index2 = 0;

        for (int i = 0; i < smallStr.length(); i++) {
            if (smallStr.charAt(i) != longStr.charAt(i)) {
                index2++;
                if(index2 > 1){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean oneReplaceAway(String s1, String s2) {
        boolean isFirst = false;
        for(int i = 0; i< s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){

                if(isFirst){
                    return false;
                }
                isFirst = true;
            }
        }
        return true;
    }
}
