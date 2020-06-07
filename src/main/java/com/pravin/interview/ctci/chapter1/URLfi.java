package com.pravin.interview.ctci.chapter1;

public class URLfi {

    public String urlFi(String s, int trueLength) {

        char[] str = s.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + (spaceCount * 2) - 1;
        if (trueLength < index) str[trueLength] = '\0';
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                str[index] = str[i];
            } else {

                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index = index - 2;
            }
            index--;
        }

        return new String(str);
    }

}
