public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, String nome, double saldo, String senha, double limite) {
        super(numero, nome, saldo, senha);
        this.limite = limite;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.getSaldo() + this.getLimite()) {
            double novoSaldo = this.getSaldo() - valor;
            if (novoSaldo >= 0) {
                this.setSaldo(novoSaldo);
                System.out.println("Saque realizado. Saldo atual: " + this.getSaldo());
            } else {
                System.out.println("Saldo insuficiente. Tente novamente.");
            }
        } else {
            System.out.println("Quantia de saque inválida. Por favor, faça outra tentativa.");
        }
    }

    @Override
    public void atualizar(double taxa) {
        this.setSaldo(this.getSaldo() + this.getSaldo() * taxa * 2);
        System.out.println("Atualização realizada. Novo saldo: " + this.getSaldo());
    }
}
