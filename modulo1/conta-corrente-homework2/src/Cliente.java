public class Cliente {
    private String nome, cpf;
    private Contato [] contatos = new Contato[2];
    private Endereco [] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato contato1, Contato contato2,
                   Endereco endereco1, Endereco endereco2) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = contato1;
        this.contatos[1] = contato2;
        this.enderecos[0] = endereco1;
        this.enderecos[1] = endereco2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] endereco) {
        this.enderecos = endereco;
    }

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
