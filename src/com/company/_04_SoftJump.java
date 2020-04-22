package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _04_SoftJump {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] token = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        char[][] input = new char[token[0]][token[1]];

        int win = 0;
        int row = token[0]-1;
        int col = 0;

        for (int i = 0; i < token[0]; i++) {
            String temp = console.nextLine();
            for (int j = 0; j < token[1]; j++) {
                input[i][j] = temp.charAt(j);
                if (temp.charAt(j) == 'S')
                    col = j;
            }
        }

        int steps = Integer.parseInt(console.nextLine());
        while (steps-- > 0) {
            token = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            shift(input[token[0]], token[1]);
            if (input[row - win - 1][col] == '-') {
                input[row - win - 1][col] = 'S';
                input[row - win][col] = win == 0 ? '0' : '-';
                if (row == ++win)
                    break;
            }
        }
        System.out.println(win == row ? "Win" : "Lose");
        System.out.println("Total Jumps: " + win);
        for (char[] chars : input) {
            for (char ch : chars)
                System.out.print(ch);
            System.out.println();
        }
        int a = 5;
    }

    private static void shift(char[] current, int steps) {
        while (steps-- > 0){
            char temp = current[current.length - 1];
            System.arraycopy(current, 0, current, 1, current.length - 1);
            current[0] = temp;
        }
    }
}
