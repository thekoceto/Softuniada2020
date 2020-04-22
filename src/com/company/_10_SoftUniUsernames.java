package com.company;

import java.util.Scanner;

public class _10_SoftUniUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int d = Integer.parseInt(console.nextLine());
        int l = Integer.parseInt(console.nextLine());
        int u = Integer.parseInt(console.nextLine());

        System.out.println(Solve(n, d, l, u) );
        console.close();
    }

    private static long ModuloPower(long x, long y) {
        long result = 1;
        while (y > 0) {
            if ((y & 1) != 0)
                result = (result * x) % 1000000007;
            x = (x * x) % 1000000007;
            y /= 2;
        }

        return result;
    }

    private static long BinomialCoefficient(int n, int k, long[] factorials, long[] reverseFactorials) {
        return (((factorials[n] * reverseFactorials[k]) % 1000000007) * reverseFactorials[n - k]) % 1000000007;
    }

    private static int Solve(int n, int d, int l, int u) {
        long[] factorials = new long[n + 1];
        long[] reverseFactorials = new long[n + 1];
        factorials[0] = reverseFactorials[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorials[i] = (i * factorials[i - 1]) % 1000000007;
            reverseFactorials[i] = ModuloPower(factorials[i], 1000000007 - 2);
        }
        long[] powersOf10 = new long[n + 1];
        long[] powersOf30 = new long[n + 1];
        powersOf10[0] = powersOf30[0] = 1;
        for (int i = 1; i <= n; i++) {
            powersOf10[i] = (10 * powersOf10[i - 1]) % 1000000007;
            powersOf30[i] = (30 * powersOf30[i - 1]) % 1000000007;
        }

        long[] count = new long[n + 1];
        count[0] = (l + u == 0) ? 1 : 0;
        for (int i = 1; i <= n; i++) {
            if (i >= l + u) {
                count[i] = 2 * count[i - 1];
                if (l > 0)
                    count[i] += BinomialCoefficient(i - 1, l - 1, factorials, reverseFactorials);
                if (u > 0)
                    count[i] += BinomialCoefficient(i - 1, u - 1, factorials, reverseFactorials);
                count[i] %= 1000000007;
            }
        }

        long result = 0;
        for (int i = l + u; i <= n - d; i++) {
            long current = 1;

            current = (current * count[i]) % 1000000007;
            current = (current * powersOf30[i]) % 1000000007;
            current = (current * powersOf10[n - i]) % 1000000007;
            current = (current * BinomialCoefficient(n, i, factorials, reverseFactorials)) % 1000000007;
            result = (result + current) % 1000000007;
        }

        return (int)result;
    }
}

// Новите потребителски имена ще са с дължина точно N символа.
// Трябва да съдържат поне D цифри (има 10 възможни цифри 0-9),
// поне L малки български букви (има 30 различни български малки букви [а-я]),
// и поне U главни български букви (има 30 различни български главни букви [А-Я]).

// Помогни на СофтУни да намери броя на всички възможни потребителски имена,
// отговарящи на съответните правила. Изведете отговора на конзолата, модулно разделен на 1,000,000,007.

// На първия ред ще получите числото N.
// На втория ред ще получите числото D.
// На третия ред ще получите числото L.
// На четвъртия ред ще получите числото U.

//2
//2
//0
//0
// 100
// Тук потребителските имена трябва да бъдат с дължина
// 2 и да съдържат поне 2 цифри,
// така че единствените валидни потребителски имена са
// "00" – "99" и има 100 възможни потребителски имена.

//3
//1
//1
//1
// 54000
// Отговорът е 3! * 10 * 30 * 30
// За щастие, в този случай точният брой на символите
// от конкретен тип е известен.
// Валидно потребителско име съдържа точно една цифра,
// точно една малка буква и точно една главна буква.

//10
//4
//4
//4
// 0
// Този случай не удовлетворява изискванията.

//10
//3
//1
//3
// 691232721
// Тук символите са едва 10, а отговорът доста по-голям.