public class Principal {

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente(1, "Bianca", 1000, "0987", 1000);
        ContaPoupanca cp1 = new ContaPoupanca(2, "Jaiane", 1000, "0987", 30);

        System.out.println("Olá!");

        int numTent = 3;
        while (numTent > 0) {
            System.out.print("Informe o número da conta: ");
            int numero = Integer.parseInt(System.console().readLine());

            System.out.print("Digite a sua senha: ");
            String senha = new String(System.console().readPassword());

            if (cc1.getNumero() == numero && cc1.verificarSenha(senha)) {
                operacoes(cc1);
                break;
            } else if (cp1.getNumero() == numero && cp1.verificarSenha(senha)) {
                operacoes(cp1);
                break;
            } else {
                System.out.println("Por favor, revise o número da conta ou a senha e faça outra tentativa.");
                numTent--;
            }
        }
    }

    private static void operacoes(Conta conta) {
        int escolha;

        while (true) {
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Sair");

            escolha = Integer.parseInt(System.console().readLine());

            if (escolha == 1) {
                System.out.print("Informe o valor para sacar: ");
                double valorSaque = Double.parseDouble(System.console().readLine());
                conta.sacar(valorSaque);
            } else if (escolha == 2) {
                System.out.print("Informe o valor para depositar: ");
                double valorDeposito = Double.parseDouble(System.console().readLine());

                // Realiza o depósito
                conta.depositar(valorDeposito);

                // Imprime o saldo atualizado apenas uma vez após o depósito
                System.out.println("Depósito realizado. Saldo atualizado: " + conta.getSaldo());

                // Sai do loop e volta ao menu
                break;
            } else if (escolha == 3) {
                System.out.println("Sistema encerrado. Até mais!");
                return;
            } else {
                System.out.println("Escolha inválida. Por favor, selecione uma opção válida.");
            }
        }
    }
}
