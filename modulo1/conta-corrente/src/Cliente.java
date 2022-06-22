public class Cliente {
    String nome, cpf;
    Contato [] contatos = new Contato[2];
    Endereco [] enderecos = new Endereco[2];

    public void imprimirContatos() {

        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                contatos[i].imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        for (int i = 0; i < enderecos.length; i++) {
            if (enderecos[i] != null) {
                enderecos[i].imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("CLIENTE\n" + this.nome + "\nCPF: " + this.cpf);
    }
}
