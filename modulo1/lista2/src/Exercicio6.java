import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer [] numeros = {1, 2, 3, 1, 4, 6, 7, 4, 4, 1};
        Integer numeroParaConferir;
        boolean numeroEncontrado = false;

        System.out.println("Informe o número para conferir se existe no vetor: ");
        numeroParaConferir = scanner.nextInt();
        scanner.close();
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i].equals(numeroParaConferir)) {
                System.out.println("Número encontrado na posição: " + i + " do vetor 'numeros'");
                numeroEncontrado = true;
            }
        }
        if (!numeroEncontrado) {
            System.out.println("O número informado não existe no vetor.");
        }

    }
}
