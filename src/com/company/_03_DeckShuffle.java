package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DeckShuffle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = Integer.parseInt(console.nextLine());
        int[] deck = new int[N];
        int[] currDeck = new int[N];
        for (int i = 0; i < N; i++)
            deck[i] = i+1;

        int[] X = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int x : X ) {
            int index = 0;
            int d = x > deck.length - x ? x : deck.length - x;
            for (int i = 0; i < d; i++) {
                if (i < x)
                    currDeck[index++] = deck[i];
                if (i < deck.length - x)
                    currDeck[index++] = deck[x + i];
            }
            deck = currDeck.clone();
        }
        for (int card : deck )
            System.out.print(card + " ");
    }
}
//7
//0 1 2 3
//1 4 3 5 2 6 7
//В началото имаме следната подредба: [1, 2, 3, 4, 5, 6, 7]
//След първото размесване получаваме: [1, 2, 3, 4, 5, 6, 7]
//След второто размесване получаваме: [1, 2, 3, 4, 5, 6, 7]
//След третото размесване получаваме: [1, 3, 2, 4, 5, 6, 7]
//След четвъртото размесване получаваме: [1, 4, 3, 5, 2, 6, 7]