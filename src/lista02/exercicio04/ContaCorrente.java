package lista02.exercicio04;

public class ContaCorrente {
    private static final float LIMITE_OPERACAO = 10000;

    private int numero;
    private String titular;
    private float saldo;

    public ContaCorrente(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public boolean sacar(float valor) {
        if (valor <= 0 || valor > LIMITE_OPERACAO || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean depositar(float valor) {
        if (valor <= 0 || valor > LIMITE_OPERACAO) {
            return false;
        }
        saldo += valor;
        return true;
    }

    public float consultarSaldo() {
        return saldo;
    }
}
