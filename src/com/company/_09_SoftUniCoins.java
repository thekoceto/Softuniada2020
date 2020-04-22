package com.company;

import java.util.Scanner;

public class _09_SoftUniCoins {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long input = Long.parseLong(console.nextLine());
        int coin = 0, fIndex = 12, sIndex = 6;
        while (input > 0){
            while ((long)Math.pow(100,sIndex)*25 > (long)Math.pow(10,fIndex)){
                if (input - (long)25*Math.pow(100,sIndex) >= 0){
                    input -= (long)25*Math.pow(100,sIndex);
                    coin++;
                }else
                    sIndex--;
            }
            while ((long)Math.pow(10,fIndex) > (long)Math.pow(100,sIndex)*25){
                if (input - (long)Math.pow(10,fIndex) >= 0) {
                    input -= (long) Math.pow(10, fIndex);
                    coin++;
                }else
                    fIndex--;
            }
        }
        System.out.println(coin);
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