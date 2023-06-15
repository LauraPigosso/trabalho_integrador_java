package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static <e> void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String running = "S";
        List<Produto> listaProdutos = Ler_excel.lendoExcel();

        System.out.println("Olá, eu sou a lolabot! E Irei lhe auxiliar nessa jornada..");

        while (!running.equals("N")) {
            menuPrincipal();

            int Menu_muito_top = choose(sc, 1, 5);

            //  Mostrar todos os produtos
            if (Menu_muito_top == 1) {
                showAll(listaProdutos);

                //  Ordenar por nome
            } else if (Menu_muito_top == 2) {
                boolean voltar = true;
                while (voltar){
                    menuShowOrderName();
                    int escolhaMarca = choose(sc, 1, 3);

                    List<Produto> listaProdutoOrganizada = listaProdutos;
                    voltar = orderName(escolhaMarca, listaProdutoOrganizada);
                }

                //  Ordenar por preço
            } else if (Menu_muito_top == 3) {
                boolean voltar = true;
                while (voltar){
                    menuShowOrderPrice();
                    int escolhaMarca = choose(sc, 1, 3);

                    List<Produto> listaProdutoOrganizada = listaProdutos;
                    voltar = orderPrice(escolhaMarca, listaProdutoOrganizada);
                }

                // Calcular a média de preços
            } else if (Menu_muito_top == 4) {
                double media = media(listaProdutos);
                System.out.printf("A média de preços é igual a: %.2f \n",media);

                // Opção 5: Sair do programa
            } else if (Menu_muito_top == 5) {
                break;

            } else {
                System.out.println("Erro");
            }
        }
    }

    // Exibe o menu principal
    public static void menuPrincipal() {
        System.out.println("---------------------------------");
        System.out.println("|                                |");
        System.out.println("|[1] Mostrar toda a lista.       |");
        System.out.println("|[2] Mostrar ordem por nome.     |");
        System.out.println("|[3] Mostrar ordem por preço.    |");
        System.out.println("|[4] Média de preços.            |");
        System.out.println("|[5] Sair.                       |");
        System.out.println("---------------------------------");
    }


    public static int choose(Scanner sc, int min, int max){
        int escolha;
        while (true) {
            try {
                System.out.print("Escolha sua opção: ");
                escolha = sc.nextInt();

                if (escolha >= min && escolha <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Digite um número, por favor.");
            }
        }
        return escolha;
    }

    public static void showAll(List<Produto> listaProdutos) {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-42s | %-6s \n", "NOME", "PREÇO");
        System.out.println("------------------------------------------------------------------");

        for (Produto produto : listaProdutos) {
            System.out.printf("| %-42s | %.2f \n", produto.getNome(), produto.getPreco());
        }

    }


    public static void menuShowOrderName(){
        System.out.println("---------------------------------");
        System.out.println("|        Ordenar por nome        |");
        System.out.println("|                                |");
        System.out.println("|[1] De A a Z.                   |");
        System.out.println("|[2] De Z a A.                   |");
        System.out.println("|[3] Voltar.                     |");
        System.out.println("---------------------------------");
    }

    public static boolean orderName(int escolha, List<Produto> listaCertinha){
        if (escolha == 1) {
            listaCertinha.sort((Produto s1, Produto s2) -> s1.getNome().compareTo(s2.getNome()));

        } else if (escolha == 2) {
            listaCertinha.sort((Produto s1, Produto s2) -> s2.getNome().compareTo(s1.getNome()));

        } else if (escolha == 3) {
            return false;
        }

        showAll(listaCertinha);
        return true;
    }



    public static void menuShowOrderPrice(){
        System.out.println("---------------------------------");
        System.out.println("|        Ordenar por preço       |");
        System.out.println("|                                |");
        System.out.println("|[1] Crescente.                  |");
        System.out.println("|[2] Decrescente.                |");
        System.out.println("|[3] Voltar.                     |");
        System.out.println("---------------------------------");
    }


    public static boolean orderPrice(int escolha, List<Produto> listaCertinha){
        if (escolha == 1) {
            listaCertinha.sort((Produto s1, Produto s2) -> Double.compare(s1.getPreco(), s2.getPreco()));
        } else if (escolha == 2) {
            listaCertinha.sort((Produto s1, Produto s2) -> Double.compare(s2.getPreco(), s1.getPreco()));
        } else if (escolha == 3) {
            return false;
        }

        showAll(listaCertinha);
        return true;
    }


    public static double media(List<Produto> listaProdutos) {
        double soma = 0.0;
        for (Produto produto : listaProdutos) {
            soma += produto.getPreco();
        }
        return soma / listaProdutos.size();
    }
}
