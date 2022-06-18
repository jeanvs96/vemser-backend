import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        String nome;
        String estado;
        Integer idade;
        String cidade;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o seu nome?");
        nome = scanner.nextLine();
        System.out.println("Qual a sua idade?");
        idade = Integer.parseInt(scanner.nextLine());
        System.out.println("Mora em qual Estado?");
        estado = scanner.nextLine();
        System.out.println("Em qual cidade você mora?");
        cidade = scanner.nextLine();

        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos, é da cidade " + cidade  +
                        ", situada no estado de " + estado + ".");
    }
}
