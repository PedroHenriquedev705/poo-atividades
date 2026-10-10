package lista03.exercicio01;

public class Turma {

    private Aluno[] alunos;
    private int qtdAlunos = 0;

    public Turma(int capacidade) {
        alunos = new Aluno[capacidade];
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (qtdAlunos >= alunos.length) {
            System.out.println("Turma cheia.");
            return false;
        }
        alunos[qtdAlunos++] = aluno;
        return true;
    }

    public void listarAprovados() {
        System.out.println("=== Aprovados ===");
        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].estaAprovado()) {
                System.out.println(alunos[i]);
            }
        }
    }

    public void listarReprovados() {
        System.out.println("=== Reprovados ===");
        for (int i = 0; i < qtdAlunos; i++) {
            if (!alunos[i].estaAprovado()) {
                System.out.println(alunos[i]);
            }
        }
    }
}
