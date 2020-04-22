package com.company;

import java.util.Scanner;

public class _09_SoftUniCoins2 {
    private static long DynamicProgramming(long value){
        int[] dp = new int[100];

        for (int i = 0; i < 100; i++){
            dp[i] = i;
            if (i >= 10)
                dp[i] = dp[i - 10] + 1 < dp[i] ? dp[i - 10] + 1 : dp[i];
            if (i >= 25)
                dp[i] = dp[i - 25] + 1 < dp[i] ? dp[i - 25] + 1 : dp[i];
        }

        int count = 0;
        while (value > 0){
            count += dp[(int) (value % 100)];
            value /= 100;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long input = Long.parseLong(console.nextLine());
//        long input = 2772788690199L;
//        long input = 1000000000000000L;
//        long input = 999999999999999L;

        System.out.println(DynamicProgramming(input));
    }
}
// СофтУни въвежда нова парична система, която използва монети със следните стойности:
// 1, 10, 25, 100, 1 000, 2 500, 10 000, 100 000, 250 000, 1 000 000, 10 000 000, 25 000 000
// и така нататък. С други думи за всяко K >= 0 има монети, които са със
// стойност 10K и монети със стойност 25*100K.
//
// 1; 1 000 000 000 000 000
//39	6	25+10+1+1+1+1
//8	8	1+1+1+1+1+1+1+1
//30	3	10+10+10 – 3 монети
// Има и друго решение тук, но то има 6 монети: 25+1+1+1+1+1
//2772788690199	36