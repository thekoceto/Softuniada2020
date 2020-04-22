package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class _08_Sticks {

    private static void generate(TreeSet<String> set, Pair[] sticks, int index) {
        if (index == sticks.length) {
            set.add(Arrays.stream(sticks)
                    .map(Pair::toString)
                    .collect(Collectors.joining(" # ")));
        } else {
            for (int i = index; i < sticks.length; i++) {
                swapElement(sticks, index, i);
                generate(set, sticks, index + 1);

                sticks[index].swapPairValue();
                generate(set, sticks, index + 1);
            }
        }
    }

    private static void swapElement(Pair[] sticks, int index1, int index2) {
        Pair temp = sticks[index1];
        sticks[index1] = sticks[index2];
        sticks[index2] = temp;
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        TreeSet<String> set = new TreeSet<>();
        int steps = Integer.parseInt(reader.readLine());

        Pair[] sticks = reader.lines()
                .limit(steps).map(line -> {
                    String[] tokens = line.split("\\s+");
                    return new Pair(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
                })
                .toArray(Pair[]::new);

        generate(set, sticks, 0);

        //set.forEach(stick -> sb.append(System.lineSeparator()).append(stick));
        System.out.println(set.size()
                //set.forEach(stick -> sb.append(System.lineSeparator()).append(stick));
        );
    }

    public static class Pair {
        private int first;
        private int second;

        Pair(int first, int second) {
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
            return "|" + this.first + "-" + this.second + "|";
        }
    }
}