package lista05.q5;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Imprimivel> documentos = new ArrayList<>();
        documentos.add(new RelatorioFinanceiro());
        documentos.add(new Contrato());
        documentos.add(new RelatorioFinanceiro());

        String email = "financeiro@empresa.com";

        // Versão 1: com instanceof
        System.out.println("=== Com instanceof ===");
        for (Imprimivel doc : documentos) {
            doc.imprimir();
            if (doc instanceof EnviavelPorEmail) {
                ((EnviavelPorEmail) doc).enviar(email);
            }
        }

        // Versão 2: polimorfismo, sem verificações explícitas
        System.out.println("\n=== Com polimorfismo ===");
        for (Imprimivel doc : documentos) {
            doc.processar(email);
        }
    }
}
