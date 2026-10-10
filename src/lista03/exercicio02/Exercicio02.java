package lista03.exercicio02;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[6];
        int qtd = 0;

        while (qtd < numeros.length) {
            System.out.print("Digite o número " + (qtd + 1) + " (1 a 60): ");
            int n = sc.nextInt();

            if (n < 1 || n > 60) {
                System.out.println("Número fora do intervalo. Tente novamente.");
                continue;
            }
            if (jaExiste(numeros, qtd, n)) {
                System.out.println("Número repetido. Tente novamente.");
                continue;
            }
            numeros[qtd++] = n;
        }

        Arrays.sort(numeros);
        System.out.println("Números sorteados: " + Arrays.toString(numeros));
        sc.close();
    }

    private static boolean jaExiste(int[] array, int tamanho, int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }
}
