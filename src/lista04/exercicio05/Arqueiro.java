package lista04.exercicio05;

public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        super(nome, 100);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " dispara uma flecha certeira em " + alvo.getNome() + "!");
        alvo.receberDano(20);
    }
}
