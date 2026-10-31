package lista05.q3;
public class Main {
    public static void main(String[] args) {
        Smartphone celular = new Smartphone();

        celular.ligar();
        celular.atender();

        celular.exibirPagina();
        celular.adicionarNovaAba();
        celular.exibirPagina();

        celular.tocar();
        celular.pausar();
    }
}
