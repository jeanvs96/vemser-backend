import java.time.*;
import java.time.temporal.ChronoUnit;

public class Exercicio4 {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Europe/London");
        LocalDate localDate = LocalDate.now(zoneId);
        LocalDate showDate = LocalDate.of(2024, 9, 14);
        LocalTime localTime = LocalTime.now(zoneId);
        LocalTime showTime = LocalTime.of(18, 30);

        Period periodo = Period.between(localDate, showDate);
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();

        long horas = ChronoUnit.HOURS.between(localTime, showTime) ;
        long minutos = ChronoUnit.MINUTES.between(localTime, showTime) - (horas * 60);
        long segundos = ChronoUnit.SECONDS.between(localTime, showTime) - ((horas * 60 * 60) + (minutos * 60));

        System.out.println("Tempo até o Show Wesley Safadão X Black Sabbath");
        System.out.println(anos + " ANOS, "
                + meses + " MESES, "
                + dias + " DIAS, "
                + horas + " HORAS, "
                + minutos + " MINUTOS, "
                + segundos + " SEGUNDOS");
    }
}
