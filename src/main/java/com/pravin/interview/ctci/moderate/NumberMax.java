package com.pravin.interview.ctci.moderate;

public class NumberMax {

    static int flip (int bit) {
        return 1^bit;
    }
    static int sign(int x){
        System.out.println(x + " " );
      //  System.out.println(x >> 31  );
        return flip(x >> 31 & 1 );
    }

    int getMax(int a, int b) {
        int k = sign(a - b);
        System.out.println(k    + " kkk");
        int q = flip(k);
        return a*k + b*q;
    }

    int negate(int a) {
        return -a;
    }

    public static void main(String[] args) {
         NumberMax numberMax = new NumberMax();
         System.out.println(numberMax.getMax(-10, -2 ));
         //System.out.println( -1 & 1);

        //System.out.println(12930 % 1000);

        System.out.println(numberMax.negate( 100));
    }
}
