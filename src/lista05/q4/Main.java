package lista05.q4;
public class Main {
    public static void main(String[] args) {
        OperacaoMatematica soma = (a, b) -> a + b;
        OperacaoMatematica subtracao = (a, b) -> a - b;
        OperacaoMatematica multiplicacao = (a, b) -> a * b;
        OperacaoMatematica divisao = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero.");
            }
            return a / b;
        };

        double x = 10, y = 4;

        System.out.printf("%.2f + %.2f = %.2f%n", x, y, soma.executar(x, y));
        System.out.printf("%.2f - %.2f = %.2f%n", x, y, subtracao.executar(x, y));
        System.out.printf("%.2f * %.2f = %.2f%n", x, y, multiplicacao.executar(x, y));
        System.out.printf("%.2f / %.2f = %.2f%n", x, y, divisao.executar(x, y));
    }
}
