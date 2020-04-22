package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _08_Sticks2 {
    public static class Pair {
        private int first;
        private int second;

        Pair(int first, int second ) {
            this.first = first;
            this.second = second;
        }

        private void swapPairValue() {
            int temp = this.first;
            this.first = this.second;
            this.second = temp;
        }

        @Override
        public String toString() {
            return String.format("|%d-%d|", this.first, this.second);
        }
    }

    private static void permute(Set<String> set, Pair[] sticks, int index){
        if (index == sticks.length){
            set.add(Arrays.toString(sticks)
                    .replaceAll("[\\[\\]]", "")
                    .replaceAll(", ", " # "));
        }else{
            for (int i = index; i < sticks.length; i++){
                Pair temp = sticks[index];
                sticks[index] = sticks[i];
                sticks[i] = temp;

                permute(set, sticks, index + 1);

                temp = sticks[index];
                sticks[index] = sticks[i];
                sticks[i] = temp;

            }
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Set<String> set = new TreeSet<>();
        int steps = Integer.parseInt(console.nextLine());
        Pair[] sticks = new Pair[steps];
        int index=0;

        for (int i = 0; i < steps; i++)
            sticks[index++] = new Pair(console.nextInt(), console.nextInt());

        for (int i = 0; i < steps; i++) {
            permute(set, sticks, 0);
            sticks[i].swapPairValue();
            permute(set, sticks, 0);
            sticks[i].swapPairValue();
        }

        System.out.println(set.size());
        set.forEach(System.out::println);
        console.close();
    }
}