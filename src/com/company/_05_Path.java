package com.company;

import java.util.Scanner;

public class _05_Path {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char[] path = console.nextLine().toCharArray();
        int count = 1;
        for (char ch : path)
            count *= ch == '*' ? 3 : 1;

        System.out.println(count);
        generate(path, 0);
    }

    private static void generate(char[] path, int index) {
        if(index == path.length)
            System.out.println(new String(path));
        else if (index < path.length) {
            if (path[index] == '*'){
                path[index] = 'L';
                generate(path.clone(), index + 1);
                path[index] = 'R';
                generate(path.clone(), index + 1);
                path[index] = 'S';
                generate(path.clone(), index + 1);
            }
            else
                generate(path, index + 1);
        }
    }
}
