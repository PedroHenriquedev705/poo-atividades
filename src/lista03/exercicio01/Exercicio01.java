package lista03.exercicio01;

public class Exercicio01 {

    public static void main(String[] args) {
        Aluno ana = new Aluno("Ana", "2024001");
        ana.cadastrarNota(8.0);
        ana.cadastrarNota(7.5);
        ana.cadastrarNota(9.0);
        ana.cadastrarNota(6.5);

        Aluno bruno = new Aluno("Bruno", "2024002");
        bruno.cadastrarNota(5.0);
        bruno.cadastrarNota(6.0);
        bruno.cadastrarNota(4.5);
        bruno.cadastrarNota(7.0);
        bruno.cadastrarNota(10.0); // excede o limite

        Aluno carla = new Aluno("Carla", "2024003");
        carla.cadastrarNota(7.0);
        carla.cadastrarNota(7.0);

        Turma turma = new Turma(10);
        turma.adicionarAluno(ana);
        turma.adicionarAluno(bruno);
        turma.adicionarAluno(carla);

        turma.listarAprovados();
        turma.listarReprovados();
    }
}
