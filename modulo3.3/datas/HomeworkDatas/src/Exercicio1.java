import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meses;
        int dias;
        System.out.println("Informe sua data de aniversário(YYYY-MM-DD):");
        LocalDate dataDeAniversario = LocalDate.parse(scanner.nextLine());
        LocalDate dataAtual = LocalDate.now();

        if (dataDeAniversario.withYear(dataAtual.getYear()).isBefore(dataAtual)){
            Period periodo = Period.between(dataAtual, dataDeAniversario.withYear(dataAtual.plusYears(1).getYear()));
            meses = periodo.getMonths();
            dias = periodo.getDays();
        } else {
            Period periodo = Period.between(dataAtual, dataDeAniversario.withYear(dataAtual.getYear()));
            meses = periodo.getMonths();
            dias = periodo.getDays();
        }
        System.out.println("Faltam " + meses + " meses e " + dias + " dias para o seu próximo aniversário!");
        scanner.close();
    }
}
