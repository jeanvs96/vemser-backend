import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        double valorConsumido, valorPago;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valor consumido:");
        valorConsumido = scanner.nextDouble();
        System.out.println("Valor pago:");
        valorPago = scanner.nextDouble();
        scanner.close();

        if (valorPago < valorConsumido) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
        } else if (valorPago >= valorConsumido) {
            System.out.println("Troco: \nR$" + (valorPago - valorConsumido));
        }
    }
}
