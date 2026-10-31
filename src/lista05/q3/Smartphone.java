package lista05.q3;
public class Smartphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    private int abas = 1;

    @Override
    public void ligar() {
        System.out.println("Ligando para o contato...");
    }

    @Override
    public void atender() {
        System.out.println("Chamada atendida.");
    }

    @Override
    public void exibirPagina() {
        System.out.println("Exibindo página na aba " + abas + ".");
    }

    @Override
    public void adicionarNovaAba() {
        abas++;
        System.out.println("Nova aba aberta. Total de abas: " + abas);
    }

    @Override
    public void tocar() {
        System.out.println("Tocando música...");
    }

    @Override
    public void pausar() {
        System.out.println("Música pausada.");
    }
}
