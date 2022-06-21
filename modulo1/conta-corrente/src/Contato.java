public class Contato {
    String descricao, telefone;
    Integer tipo;

    public void imprimirContato() {
        switch (this.tipo) {
            case 1 -> {
                System.out.println("CONTATO Tipo: Residencial \n" + "Telefone: " + this.telefone
                        + "\nDescrição: " + this.descricao + "\n");
            }
            case 2 -> {
                System.out.println("CONTATO Tipo: Comercial \n" + "Telefone: " + this.telefone
                        + "\nDescrição: " + this.descricao + "\n");
            }
            default -> {
                System.out.println("Contato não encontrado.");
            }
        }
    }
}
