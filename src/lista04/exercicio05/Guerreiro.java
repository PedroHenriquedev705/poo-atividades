package lista04.exercicio05;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " golpeia " + alvo.getNome() + " com a espada!");
        alvo.receberDano(25);
    }
}

