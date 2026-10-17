package lista04.exercicio05;

public class Main {

    public static void main(String[] args) {

        Personagem[] grupo = {
                new Guerreiro("Thorin"),
                new Mago("Merlin"),
                new Arqueiro("Legolas")
        };

        Personagem inimigo = new Guerreiro("Orc");

        System.out.println("=== Turno de combate ===");

        for (Personagem p : grupo) {
            if (inimigo.estaVivo()) {
                p.atacar(inimigo); // polimorfismo: cada classe ataca de um jeito
            }
        }

        System.out.println("\nVida restante do inimigo: " + inimigo.getVida());
    }
}