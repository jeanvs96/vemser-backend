public class Endereco {
    Integer tipo, numero;
    String logradouro, complemento, cep, cidade, estado, pais;

    public void imprimirEndereco() {
        switch (this.tipo) {
            case 1 -> {
                System.out.println("ENDEREÇO Tipo: Residencial" + "\nRua: " + this.logradouro
                        + "\nNúmero: " + numero + "\nComplemento: " + this.complemento
                        + "\nCEP: " + this.cep + "\nCidade: " + this.cidade
                        + "\nEstado: " + this.estado + "\nPaís: " + this.pais + "\n");
            }
            case 2 -> {
                System.out.println("ENDEREÇO Tipo: Comercial" + "\nRua: " + this.logradouro
                        + "\nNúmero: " + numero + "\nComplemento: " + this.complemento
                        + "\nCEP: " + this.cep + "\nCidade: " + this.cidade
                        + "\nEstado: " + this.estado + "\nPaís: " + this.pais + "\n");
            }
            default -> {
                System.out.println("Endereço não encontrado.");
            }
        }
    }
}
