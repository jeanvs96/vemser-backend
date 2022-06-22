public class Main {
    public static void main(String[] args) {
        Cliente jean = new Cliente();
        jean.nome = "Jean Victor da Silva";
        jean.cpf = "69061807034";
        jean.contatos[0] = new Contato();
        jean.contatos[0].tipo = 1;
        jean.contatos[0].telefone = "11948718672";
        jean.contatos[0].descricao = "Disponível das 18h as 21h";
        jean.contatos[1] = new Contato();
        jean.contatos[1].tipo = 2;
        jean.contatos[1].telefone = "1133334444";
        jean.contatos[1].descricao = "Disponível das 9h as 17h";
        jean.enderecos[0] = new Endereco();
        jean.enderecos[0].tipo = 1;
        jean.enderecos[0].logradouro = "Rua das Orquídeas";
        jean.enderecos[0].numero = 40;
        jean.enderecos[0].complemento = "Apartamento 15";
        jean.enderecos[0].cep = "01410030";
        jean.enderecos[0].cidade = "São Paulo";
        jean.enderecos[0].estado = "São Paulo";
        jean.enderecos[0].pais = "Brasil";
        jean.enderecos[1] = new Endereco();
        jean.enderecos[1].tipo = 2;
        jean.enderecos[1].logradouro = "Rua das Máquinas";
        jean.enderecos[1].numero = 1559;
        jean.enderecos[1].complemento = "17° Andar";
        jean.enderecos[1].cep = "05205040";
        jean.enderecos[1].cidade = "São Paulo";
        jean.enderecos[1].estado = "São Paulo";
        jean.enderecos[1].pais = "Brasil";

        Cliente helenice = new Cliente();
        helenice.nome = "Helenice da Silva";
        helenice.cpf = "73150576091";
        helenice.contatos[0] = new Contato();
        helenice.contatos[0].tipo = 1;
        helenice.contatos[0].telefone = "11999995555";
        helenice.contatos[0].descricao = "Disponível das 17h as 21h";
        helenice.contatos[1] = new Contato();
        helenice.contatos[1].tipo = 2;
        helenice.contatos[1].telefone = "1155553322";
        helenice.contatos[1].descricao = "Disponível das 8h as 16h";
        helenice.enderecos[0] = new Endereco();
        helenice.enderecos[0].tipo = 1;
        helenice.enderecos[0].logradouro = "Rua das Rosas";
        helenice.enderecos[0].numero = 40;
        helenice.enderecos[0].complemento = "Apartamento 45";
        helenice.enderecos[0].cep = "03447110";
        helenice.enderecos[0].cidade = "São Paulo";
        helenice.enderecos[0].estado = "São Paulo";
        helenice.enderecos[0].pais = "Brasil";
        helenice.enderecos[1] = new Endereco();
        helenice.enderecos[1].tipo = 2;
        helenice.enderecos[1].logradouro = "Rua das Máquinas";
        helenice.enderecos[1].numero = 1559;
        helenice.enderecos[1].complemento = "35° Andar";
        helenice.enderecos[1].cep = "05205040";
        helenice.enderecos[1].cidade = "São Paulo";
        helenice.enderecos[1].estado = "São Paulo";
        helenice.enderecos[1].pais = "Brasil";

        ContaCorrente contaJeanVictorDaSilva = new ContaCorrente();
        contaJeanVictorDaSilva.cliente = jean;
        contaJeanVictorDaSilva.agencia = 1010;
        contaJeanVictorDaSilva.numeroConta = "1101";
        contaJeanVictorDaSilva.saldo = 1500.0;
        contaJeanVictorDaSilva.chequeEspecial = 200.0;

        ContaCorrente contaHeleniceDaSilva = new ContaCorrente();
        contaHeleniceDaSilva.cliente = helenice;
        contaHeleniceDaSilva.agencia = 1010;
        contaHeleniceDaSilva.numeroConta = "2202";
        contaHeleniceDaSilva.saldo = 200000.0;
        contaHeleniceDaSilva.chequeEspecial = 10000.0;

        //TESTES ContaCorrente:

        contaJeanVictorDaSilva.imprimirContaCorrente();
        System.out.println();
        contaHeleniceDaSilva.imprimirContaCorrente();
        System.out.println();

        System.out.println("Teste de transferência inválida: ");
        System.out.println(contaJeanVictorDaSilva.transferir(contaHeleniceDaSilva, 1850.0));
        System.out.println("Teste de depósito inválido: ");
        System.out.println(contaJeanVictorDaSilva.depositar(-150.0));
        System.out.println("Teste de depósito válido: ");
        System.out.println(contaJeanVictorDaSilva.depositar(150.0));
        System.out.println("Teste de transferência válida: ");
        System.out.println(contaJeanVictorDaSilva.transferir(contaHeleniceDaSilva, 1850.0));
        System.out.println("Teste de saque inválido: ");
        System.out.println(contaJeanVictorDaSilva.sacar(50.0));
        System.out.println("Teste de saque válido: ");
        System.out.println(contaHeleniceDaSilva.sacar(15000.0));
        System.out.println("Teste de consulta de Saldo + Cheque Especial:");
        System.out.println(contaHeleniceDaSilva.retornarSaldoComChequeEspecial());
        System.out.println();

        contaJeanVictorDaSilva.imprimirContaCorrente();
        System.out.println();
        contaHeleniceDaSilva.imprimirContaCorrente();
        System.out.println();

    }
}
