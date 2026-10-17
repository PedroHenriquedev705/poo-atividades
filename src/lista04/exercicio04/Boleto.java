package lista04.exercicio04;

public class Boleto extends Pagamento {

    private static final double TARIFA = 3.50; // tarifa fixa de emissão

    @Override
    public void processar(double valor) {
        double total = valor + TARIFA;
        System.out.printf("Boleto: valor %.2f + tarifa de %.2f = %.2f%n", valor, TARIFA, total);
    }
}
