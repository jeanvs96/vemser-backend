import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] numeros = new int[5][4];
        int maiorNotaFinal = 0, matriculaMaiorNotaFinal = 0;
        double mediaNotasFinais = 0.0;

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                switch (j) {
                    case 0 -> {
                        System.out.println("Informe o " + (i + 1) + "° número de matrícula: ");
                        numeros[i][j] = scanner.nextInt();
                    }
                    case 1 -> {
                        System.out.println("Informe a média das provas: ");
                        numeros[i][j] = scanner.nextInt();
                    }
                    case 2 -> {
                        System.out.println("Informe a média dos trabalhos: ");
                        numeros[i][j] = scanner.nextInt();
                        mediaNotasFinais += (numeros[i][1] * 0.6) + (numeros[i][2] * 0.4);
                        numeros[i][j + 1] = (int)((numeros[i][1] * 0.6) + (numeros[i][2] * 0.4));
                        if (numeros[i][j + 1] > maiorNotaFinal) {
                            matriculaMaiorNotaFinal = numeros[i][0];
                            maiorNotaFinal = numeros[i][j + 1];
                        }
                    }
                }
            }
        }
        scanner.close();
        mediaNotasFinais /= numeros.length;
        System.out.println("Matrícula que obteve a maior nota final: " + matriculaMaiorNotaFinal
                + "\nNota: " + maiorNotaFinal);
        System.out.println("Média das notas finais: " + mediaNotasFinais);
    }
}

