package lista05.q5;
public class RelatorioFinanceiro implements Imprimivel, EnviavelPorEmail {

    @Override
    public void imprimir() {
        System.out.println("Imprimindo relatório financeiro.");
    }

    @Override
    public void enviar(String email) {
        System.out.println("Enviando relatório financeiro para " + email);
    }

    // Este documento imprime E envia.
    @Override
    public void processar(String email) {
        imprimir();
        enviar(email);
    }
}
