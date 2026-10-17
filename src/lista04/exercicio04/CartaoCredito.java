package lista04.exercicio04;


public class CartaoCredito extends Pagamento {

    private static final double TAXA = 0.03; // 3% de taxa

    @Override
    public void processar(double valor) {
        double total = valor + valor * TAXA;
        System.out.printf("Cartão de crédito: valor %.2f + taxa de 3%% = %.2f%n", valor, total);
    }
}