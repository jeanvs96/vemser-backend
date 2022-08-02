import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    //CONTA CORRENTE

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.sacar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1500.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldoEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.sacar(5000);

        Assertions.assertFalse(saque);
        Assertions.assertEquals(2000.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaContaCorrenteEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = contaCorrenteFactory();
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean transferencia = contaCorrente.transferir(contaPoupanca, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaCorrente.getSaldo());
        Assertions.assertEquals(2500.0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaContaCorrenteSemSaldoEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = contaCorrenteFactory();
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean transferencia = contaCorrente.transferir(contaPoupanca, 5000.0);

        Assertions.assertFalse(transferencia);
        Assertions.assertEquals(2000.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaCorrenteEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaCorrenteSaldoNegativoEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean saque = contaCorrente.depositar(-300);

        Assertions.assertFalse(saque);
        Assertions.assertEquals(2000.0, contaCorrente.getSaldo());
    }


    //CONTA POUPANÇA


    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();
        contaPoupanca.creditarTaxa();

        boolean saque = contaPoupanca.sacar(100.0);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1920.0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldoEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean saque = contaPoupanca.sacar(3000);

        Assertions.assertFalse(saque);
        Assertions.assertEquals(2000.0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaContaPoupancaEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean transferencia = contaPoupanca.transferir(contaPagamento, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaPoupanca.getSaldo());
        Assertions.assertEquals(2500.0, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaContaPoupancaSemSaldoEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean transferencia = contaPoupanca.transferir(contaPagamento, 5000.0);

        Assertions.assertFalse(transferencia);
        Assertions.assertEquals(2000.0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaPoupancaEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean saque = contaPoupanca.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaPoupancaSaldoNegativoEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = contaPoupancaFactory();

        boolean saque = contaPoupanca.depositar(-300);

        Assertions.assertFalse(saque);
        Assertions.assertEquals(2000.0, contaPoupanca.getSaldo());
    }


    //CONTA PAGAMENTO


    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean saque = contaPagamento.sacar(100.0);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1895.75, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldoEVerificarSaldoComSucesso() {
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean saque = contaPagamento.sacar(3000);

        Assertions.assertFalse(saque);
        Assertions.assertEquals(2000.0, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaContaPagamentoEVerificarSaldoComSucesso() {
        ContaPagamento contaPagamento = contaPagamentoFactory();
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean transferencia = contaPagamento.transferir(contaCorrente, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaPagamento.getSaldo());
        Assertions.assertEquals(2500.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaContaPagamentoSemSaldoEVerificarSaldoComSucesso() {
        ContaPagamento contaPagamento = contaPagamentoFactory();
        ContaCorrente contaCorrente = contaCorrenteFactory();

        boolean transferencia = contaPagamento.transferir(contaCorrente, 5000.0);

        Assertions.assertFalse(transferencia);
        Assertions.assertEquals(2000.0, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaPagamentoEVerificarSaldoComSucesso() {
        ContaPagamento contaPagamento = contaPagamentoFactory();

        boolean saque = contaPagamento.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaPagamentoSaldoNegativoEVerificarSaldoComSucesso() {
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
