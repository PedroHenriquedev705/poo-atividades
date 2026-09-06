package exercicio03;
import java.util.Scanner;
/*3.Peça ao usuário um número inteiro positivo N.
 Em seguida, imprima todos os números primos entre 2 e N.*/

public class Exercicio03 {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um numero inteiro: ");
        num = scanner.nextInt();

        int k, i, divisores = 0;

        for (k = 2; k <= num; k++) {
            i = 1;
            divisores = 0;
            do {
                if (k % i == 0) {
                    divisores = divisores + 1;
                }
                i = i + 1;
            }
            while (i <= k);
            if (divisores == 2) {
                System.out.printf("O numero %d é primo\n", k);
            }
        }

    }
}
