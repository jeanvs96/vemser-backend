import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        double alturaDoRetangulo, baseDoRetangulo, areaDoRetangulo;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor da altura do retângulo:");
        alturaDoRetangulo = scanner.nextDouble();
        System.out.println("Informe o valor da base do retângulo:");
        baseDoRetangulo = scanner.nextDouble();

        areaDoRetangulo = baseDoRetangulo * alturaDoRetangulo;
        System.out.println("A área do triângulo é: " + areaDoRetangulo);
    }
}
