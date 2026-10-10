package lista03.exercicio01;

public class Aluno {

    private static final int MAX_NOTAS = 4;
    private static final double MEDIA_APROVACAO = 7.0;

    private String nome;
    private String matricula;
    private double[] notas = new double[MAX_NOTAS];
    private int qtdNotas = 0;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    // Cadastra uma nota (máximo de 4). Retorna false se não foi possível.
    public boolean cadastrarNota(double nota) {
        if (qtdNotas >= MAX_NOTAS) {
            System.out.println("Limite de " + MAX_NOTAS + " notas atingido.");
            return false;
        }
        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida (deve estar entre 0 e 10).");
            return false;
        }
        notas[qtdNotas++] = nota;
        return true;
    }

    public double calcularMedia() {
        if (qtdNotas == 0) {
            return 0;
        }
        double soma = 0;
        for (int i = 0; i < qtdNotas; i++) {
            soma += notas[i];
        }
        return soma / qtdNotas;
    }

    public boolean estaAprovado() {
        return calcularMedia() >= MEDIA_APROVACAO;
    }

    @Override
    public String toString() {
        return String.format("%s (matrícula %s) - média: %.2f", nome, matricula, calcularMedia());
    }
}
