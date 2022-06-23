public class Main {
    public static void main(String[] args) {

        Contato jeanContato1 = new Contato(1, "Disponível das 18h as 21h", "11948718672");
        Contato jeanContato2 = new Contato(2, "Disponível das 9h as 17h", "1133334444");
        Endereco jeanEndereco1 = new Endereco(1, 40, "Rua das Orquídeas",
                "Apartamento 15", "01410030", "São Paulo", "São Paulo", "Brasil");
        Endereco jeanEndereco2 = new Endereco(2, 1559, "Rua das Máquinas",
                "17° Andar", "05205040", "São Paulo", "São Paulo", "Brasil");
        Cliente jean = new Cliente("Jean", "69061807034", jeanContato1,
                jeanContato2, jeanEndereco1, null);

        ContaCorrente contaJean = new ContaCorrente(jean, "1010", "1101", 1500.0, 200.0);


        Contato heleniceContato1 = new Contato(1, "Disponível das 17h as 21h", "11999995555");
        Contato heleniceContato2 = new Contato(2, "Disponível das 8h as 16h", "1155553322");
        Endereco heleniceEndereco1 = new Endereco(1, 115, "Rua das Rosas",
                "Apartamento 45", "03447110", "São Paulo", "São Paulo", "Brasil");
        Endereco heleniceEndereco2 = new Endereco(2, 1559, "Rua das Máquinas",
                "35° Andar", "05205040", "São Paulo", "São Paulo", "Brasil");
        Cliente helenice = new Cliente("Helenice Accioly", "73150576091", heleniceContato1,
                heleniceContato2, heleniceEndereco1, heleniceEndereco2);
        ContaPoupanca contaHelenice = new ContaPoupanca(helenice, "1010", "2202", 200000.0);


        //TESTES ContaCorrente:
        System.out.println("TESTES: \n");

        //Conferindo o estado das contas:
        contaJean.imprimir();
        System.out.println();
        contaHelenice.imprimir();

        //Transferindo de Conta Corrente para Conta Poupança
        System.out.println("Transferindo de Conta Corrente para Conta Poupança");
        contaJean.transferir(contaHelenice, 500);
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        System.out.println("Transferencia inválida: " + contaJean.transferir(contaHelenice,1500.0) + "\n");

        //Transferindo de Conta Poupança para Conta Corrente
        System.out.println("Transferindo de Conta Poupança para Conta Corrente");
        contaHelenice.transferir(contaJean, 500);
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("Transferencia inválida: " + contaHelenice.transferir(contaJean,-1500.0) + "\n");

        //Saque
        System.out.println("Saque:");
        System.out.println("CC: " + contaJean.sacar(500));
        System.out.println("CC inválido: " + contaJean.sacar(2000));
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("CP: " + contaHelenice.sacar(500));
        System.out.println("CP inválido: " + contaHelenice.sacar(20000000));
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());

        //Deposito
        System.out.println("\nDepósito:");
        System.out.println("CC: " + contaJean.depositar(500));
        System.out.println("CC inválido: " + contaJean.depositar(-2000));
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("CP: " + contaHelenice.depositar(500));
        System.out.println("CP inválido: " + contaHelenice.depositar(-20000000));
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());

        //Teste de alteração do Cheque Especial:
        System.out.println("\nTeste de alteração do Cheque Especial");
        System.out.println("Saldo com Cheque Especial: " + contaJean.retornarSaldoComChequeEspecial());
        contaJean.setChequeEspecial(0.0);
        System.out.println("Após alterar Cheque Especial para 0: " + contaJean.retornarSaldoComChequeEspecial());

        //Creditando taxa na Conta Poupança:
        System.out.println("Creditando taxa na Conta Poupança:");
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        contaHelenice.creditarTaxa();
        System.out.println("Saldo após creditar taxa: " + contaHelenice.getSaldo());
    }
}
