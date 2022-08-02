import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    //CONTA CORRENTE

    @Test
    public void saqueContaCorrente() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.sacar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1500.0, contaCorrente.getSaldo());
    }

    @Test
    public void saqueContaCorrenteSemSaldo() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.sacar(5000);

        Assertions.assertFalse(saque);
    }

    @Test
    public void transferenciaContaCorrente() {
        ContaCorrente contaCorrente = contaCorrenteFactory();
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean transferencia = contaCorrente.transferir(contaPoupanca, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaCorrente.getSaldo());
        Assertions.assertEquals(2500.0, contaPoupanca.getSaldo());
    }

    @Test
    public void transferenciaContaCorrenteSemSaldo() {
        ContaCorrente contaCorrente = contaCorrenteFactory();
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean transferencia = contaCorrente.transferir(contaPoupanca, 5000.0);

        Assertions.assertFalse(transferencia);
    }

    @Test
    public void depositoContaCorrente() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaCorrente.getSaldo());
    }

    @Test
    public void depositoContaCorrenteSaldoNegativo() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.depositar(-300);

        Assertions.assertFalse(saque);
    }


    //CONTA POUPANÇA


    @Test
    public void saqueContaPoupanca() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();
        contaPoupanca.creditarTaxa();

        boolean saque = contaPoupanca.sacar(100.0);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1920.0, contaPoupanca.getSaldo());
    }

    @Test
    public void saqueContaPoupancaSemSaldo() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean saque = contaPoupanca.sacar(3000);

        Assertions.assertFalse(saque);
    }

    @Test
    public void transferenciaContaPoupanca() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean transferencia = contaPoupanca.transferir(contaPagamento, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaPoupanca.getSaldo());
        Assertions.assertEquals(2500.0, contaPagamento.getSaldo());
    }

    @Test
    public void transferenciaContaPoupancaSemSaldo() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean transferencia = contaPoupanca.transferir(contaPagamento, 5000.0);

        Assertions.assertFalse(transferencia);
    }

    @Test
    public void depositoContaPoupanca() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean saque = contaPoupanca.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaPoupanca.getSaldo());
    }

    @Test
    public void depositoContaPoupancaSaldoNegativo() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean saque = contaPoupanca.depositar(-300);

        Assertions.assertFalse(saque);
    }


    //CONTA PAGAMENTO


    @Test
    public void saqueContaPagamento() {
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean saque = contaPagamento.sacar(100.0);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1895.75, contaPagamento.getSaldo());
    }

    @Test
    public void saqueContaPagamentoSemSaldo() {
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean saque = contaPagamento.sacar(3000);

        Assertions.assertFalse(saque);
    }

    @Test
    public void transferenciaContaPagamento() {
        ContaPagamento contaPagamento = contaPagamentoFactory();
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean transferencia = contaPagamento.transferir(contaCorrente, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaPagamento.getSaldo());
        Assertions.assertEquals(2500.0, contaCorrente.getSaldo());
    }

    @Test
    public void transferenciaContaPagamentoSemSaldo() {
        ContaPagamento contaPagamento = contaPagamentoFactory();
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean transferencia = contaPagamento.transferir(contaCorrente, 5000.0);

        Assertions.assertFalse(transferencia);
    }

    @Test
    public void depositoContaPagamento() {
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean saque = contaPagamento.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaPagamento.getSaldo());
    }

    @Test
    public void depositoContaPagamentoSaldoNegativo() {
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean saque = contaPagamento.depositar(-300);

        Assertions.assertFalse(saque);
        Assertions.assertEquals(2000.0, contaPagamento.getSaldo());
    }

    //util

    public ContaCorrente contaCorrenteFactory(){
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setChequeEspecial(1000.0);
        contaCorrente.setSaldo(2000.0);
        return contaCorrente;
    }

    public ContaPoupanca contaPoupancaFactory(){
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(2000.0);
        return contaPoupanca;
    }

    public ContaPagamento contaPagamentoFactory(){
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(2000.0);
        return contaPagamento;
    }
}
