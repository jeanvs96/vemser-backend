import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anos;
        int meses;
        int dias;
        System.out.println("Informe a primeira data(YYYY-MM-DD):");
        LocalDate primeiraData = LocalDate.parse(scanner.nextLine());
        System.out.println("Informe a segunda data(YYYY-MM-DD):");
        LocalDate segundaData = LocalDate.parse(scanner.nextLine());

        if (primeiraData.isBefore(segundaData)){
            Period periodo = Period.between(primeiraData, segundaData);
            anos = periodo.getYears();
            meses = periodo.getMonths();
            dias = periodo.getDays();
        } else {
            Period periodo = Period.between(segundaData, primeiraData);
            anos = periodo.getYears();
            meses = periodo.getMonths();
            dias = periodo.getDays();
        }
        System.out.println("Temos entre as duas datas " + anos + " anos, " + meses + " meses e " + dias + " dias.");
        scanner.close();
    }
}
