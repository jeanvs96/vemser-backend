import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] valores = new int[20];

        for (int i = 0; i < valores.length; i++) {
            System.out.println("Informe o " + (i + 1) + "° valor");
            valores[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println();
        for (int i = valores.length - 1; i >= 0; i--) {
            System.out.print(valores[i] + " ");
        }
    }
}
