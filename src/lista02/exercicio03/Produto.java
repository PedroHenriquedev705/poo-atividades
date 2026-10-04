package lista02.exercicio03;

public class Produto {

        private int codigo;
        private String nome;
        private double preco;
        private int estoque;

        public Produto(int codigo, String nome, double preco, int estoque) {
            this.codigo = codigo;
            this.nome = nome;
            this.preco = preco;
            this.estoque = estoque;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public int getEstoque() {
            return estoque;
        }

        public void setPreco(double preco) {
            if (preco >= 0) {
                this.preco = preco;
            }
        }

        public void exibirInfo() {
            System.out.println("Código: " + codigo);
            System.out.println("Nome: " + nome);
            System.out.println("Preço: " + preco);
            System.out.println("Estoque: " + estoque);
        }
    }
