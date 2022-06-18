import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        double notas [] = new double [4];
        double somaDasNotas = 0, mediaSimplesDasNotas;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Valor da nota " + (i + 1) + ":");
            notas[i] = scanner.nextDouble();
            somaDasNotas += notas[i];
        }
        scanner.close();

        mediaSimplesDasNotas = somaDasNotas / 4;

        if (mediaSimplesDasNotas <= 5) {
            System.out.println("Média: " + mediaSimplesDasNotas + "\nReprovado.");
        } else if (mediaSimplesDasNotas > 5 && mediaSimplesDasNotas < 7) {
            System.out.println("Média: " + mediaSimplesDasNotas + "\nEm exame.");
        } else {
            System.out.println("Média: " + mediaSimplesDasNotas + "\nAprovado.");
        }
    }
}