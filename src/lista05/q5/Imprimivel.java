package lista05.q5;
public interface Imprimivel {
    void imprimir();

    // Comportamento padrão: documentos que só imprimem não precisam sobrescrever.
    default void processar(String email) {
        imprimir();
    }
}
