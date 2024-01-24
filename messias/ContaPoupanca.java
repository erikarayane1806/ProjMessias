public class ContaPoupanca extends Conta {
    private int diaAniversario;

    public ContaPoupanca(int numero, String nome, double saldo, String senha, int diaAniversario) {
        super(numero, nome, saldo, senha);
        this.diaAniversario = diaAniversario;
    }

    public int getDiaAniversario() {
        return this.diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque efetuado com sucesso. Novo saldo: " + this.getSaldo());
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido. Tente novamente.");
        }
    }

    @Override
    public void atualizar(double taxa) {
        this.setSaldo(this.getSaldo() + this.getSaldo() * taxa * 3);
        System.out.println("Atualização de aniversário realizada. Novo saldo: " + this.getSaldo());
    }

    @Override
    public String toString() {
        return "Conta Poupança: " + this.getNumero() + " - " + this.getNome() + " - " + this.getSaldo();
    }
}
