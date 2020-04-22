package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _04_SoftJump2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] token = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        List <List <Character>> input = new ArrayList<>();
        for (int i = 0; i < token[0]; i++) {
            input.add(new ArrayList<>());
            String temp = console.nextLine();
            for (int j = 0; j < token[1]; j++)
                input.get(i).add(temp.charAt(j));
        }
        int win = 0;
        int row = token[0]-1;
        int col = input.get(row).indexOf('S');

        int steps = Integer.parseInt(console.nextLine());
        while (steps-- > 0) {
            token = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            shift(input.get(token[0]), token[1]);
            if (input.get(row - win - 1).get(col) == '-') {
                input.get(row - win - 1).set(col, 'S');
                input.get(row - win).set(col, win == 0 ? '0' : '-');
                if (row == ++win)
                    break;
            }
        }
        System.out.println(win == row ? "Win" : "Lose");
        System.out.println("Total Jumps: " + win);
        input
                .stream()
                .map(characters -> characters
                        .toString()
                        .replaceAll("[\\[\\], ]", ""))
                .forEach(System.out::println);
    }

    private static void shift(List<Character> current, int steps) {
        while (steps-- > 0)
            current.add(0, current.remove(current.size()-1));
    }
}
