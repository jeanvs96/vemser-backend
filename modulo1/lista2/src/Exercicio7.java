import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] numeros = new int[4][4];
        int quantidadeAcimaDeDez = 0;

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.println("Insira o " + (j + 1) + "° valor na " + (i + 1) + "° linha:");
                numeros[i][j] = scanner.nextInt();
                if (numeros[i][j] > 10) {
                    quantidadeAcimaDeDez += 1;
                }
            }
        }
        System.out.println("A matriz possui " + quantidadeAcimaDeDez + " valores maiores que 10.");
    }
}
