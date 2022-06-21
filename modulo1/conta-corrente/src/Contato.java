public class Contato {
    String descricao, telefone;
    Integer tipo;

    public void imprimirContato() {
        switch (this.tipo) {
            case 1 -> {
                System.out.println("Tipo: Residencial \n" + "Telefone: " + this.telefone
                        + "\nDescrição: " + this.descricao);
            }
            case 2 -> {
                System.out.println("Tipo: Comercial \n" + "Telefone: " + this.telefone
                        + "\nDescrição: " + this.descricao);
            }
            default -> {
                System.out.println("Contato não encontrado.");
            }
        }
    }
}
