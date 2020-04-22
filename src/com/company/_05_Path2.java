package com.company;

import java.util.Scanner;

public class _05_Path2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char[] path = console.nextLine().toCharArray();
        char[] variable = {'L', 'R', 'S'};
        int count = 1;
        for (char ch : path)
            count *= ch == '*' ? variable.length : 1;

        System.out.println(count);
        generate(path, variable,0);
}

    private static void generate(char[] path, char[] variant, int index) {
        if(index == path.length)
            System.out.println(new String(path));
        else
            if (path[index] == '*')
                for (char ch : variant) {
                    path[index] = ch;
                    generate(path.clone(), variant, index + 1);
                }
            else
                generate(path, variant, index + 1);
    }
}