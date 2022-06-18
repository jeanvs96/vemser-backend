import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        String palavra;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual palavra deseja traduzir? ");
        palavra = scanner.nextLine();

        switch (palavra) {
            case "Cachorro" -> {
                System.out.println("Dog");
            }
            case "Dog" -> {
                System.out.println("Cachorro");
            }
            case "Tempo" -> {
                System.out.println("Time");
            }
            case "Time" -> {
                System.out.println("Tempo");
            }
            case "Amor" -> {
                System.out.println("Love");
            }
            case "Love" -> {
                System.out.println("Amor");
            }
            case "Cidade" -> {
                System.out.println("City");
            }
            case "City" -> {
                System.out.println("Cidade");
            }
            case "Feliz" -> {
                System.out.println("Happy");
            }
            case "Happy" -> {
                System.out.println("Feliz");
            }
            case "Triste" -> {
                System.out.println("Sad");
            }
            case "Sad" -> {
                System.out.println("Triste");
            }
            case "Deveria" -> {
                System.out.println("Should");
            }
            case "Should" -> {
                System.out.println("Deveria");
            }
            case "Poderia" -> {
                System.out.println("Could");
            }
            case "Could" -> {
                System.out.println("Poderia");
            }
            default -> {
                System.out.println("Essa palavra não é válida.");
            }
        }
    }
}
