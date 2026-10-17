package lista04.exercicio04;



public class Pix extends Pagamento {

    private static final double DESCONTO = 0.05; // 5% de desconto

    @Override
    public void processar(double valor) {
        double total = valor - valor * DESCONTO;
        System.out.printf("Pix: valor %.2f - desconto de 5%% = %.2f%n", valor, total);
    }
}
