import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bot {
     String nome = "LOLA";
     String senha = "senaimange";
     String descricao = "Bot criado porque o rodrigo pediu,"+
                                "e estou aqui para te ajudar no ecommerce";

     String enderecoExcel = "Área de Trabalho";

    LerEscreverExcel teste = new LerEscreverExcel(enderecoExcel);

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void botOpcoes() {
        System.out.println("Oi, eu sou o "+this.nome);
        System.out.println("Eu sou o "+this.descricao);
        System.out.println("Aqui estão as opções aonde posso ajudar você");
        System.out.println("   ");
        System.out.println("1 - Ver todos os produtos");
        System.out.println("2 - Ver todos os preços");
        System.out.println("3 - Mostar senha");
        System.out.println("   ");
        System.out.println("Digite a opcao desejada:");
    }

    public void executarBot(int opcao) throws BiffException, IOException {

        Scanner sc = new Scanner(System.in);

        teste.lerExcel();

        switch (opcao) {
            case 1 -> {
                System.out.println("Todos os produtos cadastrados:");
                for (int x = 0; x <= teste.getAs1().length - 1; x++) {
                    System.out.println(teste.getAs1()[x]);
                }
            }
            case 2 -> {
                System.out.println("Todos os preçõs cadastrados:");
                for (int x = 0; x <= teste.getAs2().length - 1; x++) {
                    System.out.println(teste.getAs2()[x]);
                }
            }
            case 3 -> System.out.println("A senha é " + this.senha);
            default -> System.out.println("Opção inválida!");
        }

        System.out.println("Deseja escolher outra opção? S ou N");
    }
}