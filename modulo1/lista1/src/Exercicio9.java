import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Integer idadeAnos, idadeMeses, idadeDias, idadeEmDiasTotal;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe sua idade (anos, meses e dias) \nAnos:");
        idadeAnos = scanner.nextInt();
        System.out.println("Meses:");
        idadeMeses = scanner.nextInt();
        System.out.println("Dias:");
        idadeDias = scanner.nextInt();

        idadeEmDiasTotal = idadeDias + (idadeMeses * 30) + (idadeAnos * 365);
        System.out.println("Idade total em dias: " + idadeEmDiasTotal + " dias");
    }
}
