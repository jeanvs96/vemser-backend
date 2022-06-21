public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    Integer agencia;
    Double saldo, chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("Cliente: " + this.cliente.nome + "\nAgência: " + this.agencia
                + "\nConta: " + this.numeroConta + "\nSaldo: " + this.saldo
                + "\nLimite de Cheque Especial: " + this.chequeEspecial);
    }

    public boolean sacar(double valorDoSaque) {
        if(valorDoSaque <= this.retornarSaldoComChequeEspecial() && valorDoSaque > 0) {
            this.saldo -= valorDoSaque;
            return true;
        }
        return false;
    }

    public boolean depositar(double valorDoDeposito) {
        if(valorDoDeposito > 0) {
            this.saldo += valorDoDeposito;
            return true;
        }
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        return this.saldo + this.chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valorDaTransferencia) {
        if(valorDaTransferencia <= this.retornarSaldoComChequeEspecial() && valorDaTransferencia > 0) {
            this.saldo -= valorDaTransferencia;
            conta.saldo += valorDaTransferencia;
            return true;
        }
        return false;
    }
}
