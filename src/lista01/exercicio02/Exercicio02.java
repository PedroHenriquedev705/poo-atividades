package exercicio02;
import java.util.Scanner;

/*2.	Peça um número ao usuário. Verifique e imprima:
        ●	"Múltiplo de 3", se for múltiplo de 3;
        ●	"Múltiplo de 5", se for múltiplo de 5;
        ●	"Múltiplo de ambos", se for múltiplo de 3 e 5;
        ●	"Não é múltiplo de 3 nem de 5", caso contrário.*/

public class Exercicio02 {
    public static void main(String[] args){
        int num,resto1,resto2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um numero inteiro: ");
        num = scanner.nextInt();

        resto1 = num%3;
        resto2 = num%5;

        if(resto1 == 0 && resto2 == 0){
            System.out.printf("O numero: %d eh multiplo de 3 e de 5",num);
        }
        else if (resto1 == 0) {
            System.out.printf("O numero %d eh multiplo de 3",num);
        }
        else if (resto2 == 0) {
            System.out.printf("O numero %d eh multiplo de 5",num);
        }
        else {
            System.out.println("Não é multiplo de 3 nem de 5");
        }

    }

}
