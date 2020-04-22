package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _08_Sticks3 {
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

    private static void generate(Set<String> set, Pair[] sticks, int index){
        if (index == sticks.length){
            set.add(Arrays.toString(sticks)
                    .replaceAll("[\\[\\]]", "")
                    .replaceAll(", ", " # "));
        }else{
            for (int i = index; i < sticks.length; i++){
                swapElement(sticks, index, i);
                generate(set, sticks, index+1);
                sticks[index].swapPairValue();
                generate(set, sticks, index +1);
                sticks[index].swapPairValue();
                swapElement(sticks, index, i);
            }
        }
    }

    private static void swapElement(Pair[] sticks, int index1, int index2) {
        Pair temp = sticks[index1];
        sticks[index1] = sticks[index2];
        sticks[index2] = temp;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Set<String> set = new TreeSet<>();
        int steps = Integer.parseInt(console.nextLine());
        Pair[] sticks = new Pair[steps];

        for (int i = 0; i < steps; i++)
            sticks[i] = new Pair(console.nextInt(), console.nextInt());

        generate(set, sticks, 0);

        System.out.println(set.size());
        set.forEach(System.out::println);
        console.close();
    }
}