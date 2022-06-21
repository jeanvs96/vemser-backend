import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numeroInformado, numeroAdivinhado;
        boolean controle = true;

        System.out.println("Informe um número: ");
        numeroInformado = scanner.nextInt();
        while(controle) {
            System.out.println("Tente adivinhar o número informado: ");
            numeroAdivinhado = scanner.nextInt();
            if (numeroInformado.equals(numeroAdivinhado)) {
                System.out.println("Correto!");
                controle = false;
            }else if (numeroAdivinhado > numeroInformado) {
                System.out.println("O número a ser encontrado é menor do que você digitou!");
            }else {
                System.out.println("O número a ser encontrado é maior do que você digitou!");
            }
        }
    }
}
