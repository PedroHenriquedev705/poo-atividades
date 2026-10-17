package lista04.exercicio05;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 80);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " lança uma bola de fogo em " + alvo.getNome() + "!");
        alvo.receberDano(35);
    }
}


