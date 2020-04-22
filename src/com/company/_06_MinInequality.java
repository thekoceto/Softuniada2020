package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _06_MinInequality {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int k = Integer.parseInt(console.nextLine());
        int n = Integer.parseInt(console.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = console.nextInt();
        int diff = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for(int i = k - 1; i < n; i++)
            diff = arr[i] - arr[i-k+1] < diff ? arr[i] - arr[i-k+1] : diff;

        System.out.println(diff);
    }
}
