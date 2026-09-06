package exercicio04;
import java.util.Scanner;
/*4.	Uma aplicação interessante dos computadores é exibir diagramas e gráficos de barras.
Escreva um aplicativo que leia cinco números entre 1 e 30. Para cada número que é lido,
 seu programa deve exibir o mesmo número de asteriscos adjacentes.
Por exemplo, se seu programa lê o número 7, ele deve exibir *******.
Exiba as barras dos asteriscos depois de ler os cinco números.*/
public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num,k,i, tamanho = 5;
        int vet[];
        vet = new int[5];

        for(k=0;k<tamanho;k++){
            System.out.println("Informe um numero inteiro: ");
            vet[k] = scanner.nextInt();
        }
        int j = 0;
        for(k=1;k<=5;k++){
            for(i=1;i<=vet[j];i++){
                System.out.print("*");
            }
            System.out.print("\n");
            j = j + 1;
        }

    }
}
