import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Integer totalDeEleitores, votosNulos, votosBrancos, votosValidos;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o total de eleitores:");
        totalDeEleitores = scanner.nextInt();
        System.out.println("Informe o total de votos nulos:");
        votosNulos = scanner.nextInt();
        System.out.println("Informe o total de votos em branco:");
        votosBrancos = scanner.nextInt();
        System.out.println("Informe o total de votos válidos:");
        votosValidos = scanner.nextInt();
        System.out.println("Representação de votos com relação ao número de eleitores:");
        System.out.println("Nulos: " + ((totalDeEleitores/100) * votosNulos) + "%");
        System.out.println("Em branco: " + ((totalDeEleitores/100) * votosBrancos) + "%");
        System.out.println("Válidos: " + ((totalDeEleitores/100) * votosValidos) + "%");
    }
}
