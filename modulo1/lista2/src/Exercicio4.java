import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numeros = new int [3];
        int posicaoDoMenor = 0, controle = 999999999;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o " + (i + 1) +"° valor: ");
            numeros[i] = scanner.nextInt();
            if(numeros[i] < controle) {
                posicaoDoMenor = i;
                controle = numeros[i];
            }
        }
        scanner.close();
        System.out.println("A posição do menor valor é: " + posicaoDoMenor);
    }
}
