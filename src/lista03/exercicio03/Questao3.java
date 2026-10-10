package lista03.exercicio03;

import java.util.Arrays;
import java.util.Scanner;

public class Questao3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos termos de Fibonacci? ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Informe um valor maior que zero.");
            sc.close();
            return;
        }

        long[] fib = new long[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println(Arrays.toString(fib));
        sc.close();
    }
}
