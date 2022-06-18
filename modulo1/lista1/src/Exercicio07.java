public class Exercicio07 {
    public static void main(String[] args) {
        Integer valor1 = 10, valor2 = 20, aux;
        aux = valor1;
        valor1 = valor2;
        valor2 = aux;

        System.out.println("Valor 1: " + valor1 + "\nValor 2: " + valor2);
    }
}
