import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = null, nomeDoMaisPesado = null;
        Double altura, peso, alturaDoMaisAlto = 0.0, mediaDasAlturas = 0.0, pesoDoMaisPesado = 0.0;
        Integer idade, quantidadeDeJogadores = 0, idadeDoMaisVelho = 0;

        System.out.println("CADASTRO DE JOGADORES DE BASQUETE");
        System.out.println("Para sair, digite SAIR no nome do jogador.");
        System.out.println("------------------------------------------");
        while (true) {
            System.out.println("Informe o nome do " + (quantidadeDeJogadores + 1) + "° jogador: ");
            nome = scanner.nextLine();
            if("SAIR".equals(nome)) {
                break;
            }
            System.out.println("Informe a altura do jogador: ");
            altura = Double.parseDouble(scanner.nextLine());
            System.out.println("Informe a idade do jogador: ");
            idade = Integer.parseInt(scanner.nextLine());
            System.out.println("Informe o peso do jogador: ");
            peso = Double.parseDouble(scanner.nextLine());
            quantidadeDeJogadores += 1;
            if(altura > alturaDoMaisAlto) {
                alturaDoMaisAlto = altura;
            }
            if(idade > idadeDoMaisVelho) {
                idadeDoMaisVelho = idade;
            }
            if(peso > pesoDoMaisPesado) {
                pesoDoMaisPesado = peso;
                nomeDoMaisPesado = nome;
            }
            mediaDasAlturas += altura;
        }
        scanner.close();
        mediaDasAlturas /= quantidadeDeJogadores;

        System.out.format("Quantidade de jogadores cadastrados: " + quantidadeDeJogadores
                + "\nAltura do maior jogador: " + alturaDoMaisAlto
                + "\nJogador mais velho: " + idadeDoMaisVelho
                + "\nJogador mais pesado: " + nomeDoMaisPesado
                + "\nMédia das alturas: %.2f", mediaDasAlturas);
    }
}
