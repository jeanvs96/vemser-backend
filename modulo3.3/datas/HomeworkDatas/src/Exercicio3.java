import java.time.LocalDateTime;

public class Exercicio3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(15).plusHours(10);
        System.out.println("Dia da semana daqui 15 dias: " + localDateTime.getDayOfWeek());
        System.out.println("Dia no ano corrido: " + localDateTime.getDayOfYear());
    }
}
