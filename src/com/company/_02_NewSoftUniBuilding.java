package com.company;

import java.util.Scanner;

public class _02_NewSoftUniBuilding {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int row = Integer.parseInt(console.nextLine());
        int col = row+row/2;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++)
                System.out.print((j+i)%4==0 ? '#' : '.');
            System.out.println();
        }
    }
}