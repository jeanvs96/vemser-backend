import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        double valorPorHora, horasNormaisTrabalhadas, horasExtras50, horasExtras100, salarioBruto;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor da hora em R$: ");
        valorPorHora = scanner.nextDouble();
        System.out.println("Informe o número de horas normais trabalhadas: ");
        horasNormaisTrabalhadas = scanner.nextDouble();
        System.out.println("Informe o número de horas extras 50%: ");
        horasExtras50 = scanner.nextDouble();
        System.out.println("Informe o número de horas extras 100%: ");
        horasExtras100 = scanner.nextDouble();

        salarioBruto = (valorPorHora * horasNormaisTrabalhadas) + (valorPorHora * horasExtras50 * 1.5)
                + (valorPorHora * horasExtras100 * 2);

        System.out.println("Salário bruto:\n" + salarioBruto);
    }
}
