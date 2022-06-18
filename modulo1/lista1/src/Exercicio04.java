import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Integer estado, cidade;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do Estado escolhido: \n1 - São Paulo" +
                "\n2 - Rio de Janeiro\n3 - Bahia");
        estado = scanner.nextInt();
        switch (estado) {
            case 1 -> {
                System.out.println("Digite o número da cidade escolhida: \n1 - São Paulo" +
                        "\n2 - Mogi das Cruzes");
                cidade = scanner.nextInt();
                switch (cidade) {
                    case 1 -> {
                        System.out.println("São Paulo/São Paulo\nPopulação: 12,33 milhões\nPrincipal festa: Carnaval\nIDH: 0,783");
                    }
                    case 2 -> {
                        System.out.println("São Paulo/Mogi das Cruzes\nPopulação: 455 mil\nPrincipal festa: Festa do Divino\nIDH: 0,655");
                    }
                    default -> throw new IllegalStateException("Opção inválida: " + cidade);
                }
            }
            case 2 -> {
                System.out.println("Digite o número da cidade escolhida: \n1 - Rio de Janeiro" +
                        "\n2 - Niterói");
                cidade = scanner.nextInt();
                switch (cidade) {
                    case 1 -> {
                        System.out.println("Rio de Janeiro/Rio de Janeiro\nPopulação: 6,74 milhões\nPrincipal festa: Carnaval\nIDH: 0,799");
                    }
                    case 2 -> {
                        System.out.println("Rio de Janeiro/Niterói\nPopulação: 515 mil\nPrincipal festa: Carnaval\nIDH: 0,837");
                    }
                    default -> throw new IllegalStateException("Opção inválida: " + cidade);
                }
            }
            case 3 -> {
                System.out.println("Digite o número da cidade escolhida: \n1 - Salvador" +
                        "\n2 - Feira de Santana");
                cidade = scanner.nextInt();
                switch (cidade) {
                    case 1 -> {
                        System.out.println("Bahia/Salvador\nPopulação: 2,95 milhões\nPrincipal festa: Festa de Santa Bárbara.\nIDH: 0,673");
                    }
                    case 2 -> {
                        System.out.println("Bahia/Feira de Santana\nPopulação: 627 mil\nPrincipal festa: Bando Anunciador\nIDH: 0,712");
                    }
                    default -> throw new IllegalStateException("Opção inválida: " + cidade);
                }
            }
            default -> throw new IllegalStateException("Opção inválida: " + estado);
        }
    }
}
