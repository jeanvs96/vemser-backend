public class Endereco {
    Integer tipo, numero;
    String logradouro, complemento, cep, cidade, estado, pais;

    public void imprimirEndereco() {
        switch (this.tipo) {
            case 1 -> {
                System.out.println("Tipo: Residencial" + "Rua: " + this.logradouro
                        + "Número: " + numero + "\nComplemento: " + this.complemento
                        + "\nCEP: " + this.cep + "\nCidade: " + this.cidade
                        + "\nEstado: " + this.estado + "\nPaís: " + this.pais);
            }
            case 2 -> {
                System.out.println("Tipo: Comercial" + "Rua: " + this.logradouro
                        + "Número: " + numero + "\nComplemento: " + this.complemento
                        + "\nCEP: " + this.cep + "\nCidade: " + this.cidade
                        + "\nEstado: " + this.estado + "\nPaís: " + this.pais);
            }
            default -> {
                System.out.println("Endereço não encontrado.");
            }
        }
    }
}
