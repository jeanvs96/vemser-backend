public interface Movimentacao {

    public abstract boolean sacar(double valor);

    public abstract boolean depositar(double valor);

    public abstract boolean transferir(Conta conta, double valor);

}
