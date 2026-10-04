package lista02.exercicio04;

// src/Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Titular: ");
        String titular = sc.nextLine();

        ContaCorrente conta = new ContaCorrente(numero, titular);

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do saque: ");
                    if (conta.sacar(sc.nextFloat())) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saque negado: saldo insuficiente, valor inválido ou acima de 10000.");
                    }
                    break;
                case 2:
                    System.out.print("Valor do depósito: ");
                    if (conta.depositar(sc.nextFloat())) {
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Depósito negado: o valor deve ser positivo e no máximo 10000.");
                    }
                    break;
                case 3:
                    System.out.printf("Saldo atual: R$ %.2f%n", conta.consultarSaldo());
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
