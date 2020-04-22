package com.company;

import java.util.Scanner;

public class _02_NewSoftUniBuilding2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int row = Integer.parseInt(console.nextLine());
        int col = row+row/2;
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < col; i+=4)
            input.append("#...");
        String line = input.toString();

        for (int i = 0; i < col; i++) {
            System.out.println((line.substring(i) + line.substring(0, i)).substring(0,row));
        }
    }
}
//    String input = "Stackoverflow";
//    for(int i = 0; i < s.length(); i++){
//        input = shift(input);
//        System.out.println(input);
//    }
//}
//
//public static String shift(String s) {
//    return s.charAt(s.length()-1)+s.substring(0, s.length()-1);
//}