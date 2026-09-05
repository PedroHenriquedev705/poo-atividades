package exercicio01;

import java.util.Scanner;
public class Exercico01{
    public static void main(String[] args){
        /*1.	Escreva um programa que leia o nome de um aluno e suas três notas, sendo a terceira nota com peso 2.
        Calcule e exiba a média ponderada, com duas casas decimais. Depois, exiba se o aluno está "Aprovado" (média ≥ 7) ou "Reprovado".*/

        Scanner scanner = new Scanner(System.in);
        String nome;
        double nota1,nota2,nota3;
        int peso1 = 1, peso2 = 1, peso3 = 2;

        System.out.println("Infomre o nome do aluno: ");
        nome = scanner.nextLine();
        System.out.println("Informe a primeira nota: ");
        nota1 = scanner.nextDouble();
        System.out.println("Informe a segunda nota: ");
        nota2 = scanner.nextDouble();
        System.out.println("Informe a terceira nota: ");
        nota3 = scanner.nextDouble();

        double media;
        int somapeso = peso1 + peso2 + peso3;
        media = ((nota1 * peso1)+(nota2 * peso2)+(nota3 * peso3))/somapeso;

        if(media >= 7 ){
            System.out.printf("O aluno %s tirou media: %.2f , o aluno esta aprovado",nome,media);
        }
        else{
            System.out.printf("O aluno %s tirou media: %.2f esta reprovado",nome,media);
        }
    }
}
