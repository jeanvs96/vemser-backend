import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        String produto;
        double valorDoProduto;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do produto: ");
        produto = scanner.nextLine();
        System.out.println("Informe o valor do produto: ");
        System.out.print("R$");
        valorDoProduto = scanner.nextDouble();
        scanner.close();
        double [] promocaoDoProduto = {
                valorDoProduto * 0.95, valorDoProduto * 0.90 * 2,
                valorDoProduto * 0.85 * 3, valorDoProduto * 0.80 * 4,
                valorDoProduto * 0.75 * 5, valorDoProduto * 0.70 * 6,
                valorDoProduto * 0.65 * 7, valorDoProduto * 0.60 * 8,
                valorDoProduto * 0.55 * 9, valorDoProduto * 0.50  * 10
        };

        System.out.println("PROMOÇÃO DE " + produto.toUpperCase());
        System.out.println("Valor original: R$" + valorDoProduto );
        System.out.println("-----------------------");
        for (int i = 0; i < promocaoDoProduto.length; i++) {
            System.out.format("Comprando " + (i + 1) + " unidade(s): R$ %.2f\n", promocaoDoProduto[i]);
        }
    }
}
