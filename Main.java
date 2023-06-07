import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BiffException, IOException {

        Scanner sc = new Scanner(System.in);

        Bot bot1 = new Bot();

        System.out.println("Digite a senha de acesso:");
        String senha = sc.next();
        String resp = "s";

        if(senha.equals(bot1.getSenha())){
            while(resp.equals("s")) {
                bot1.botOpcoes();
                int opcao = sc.nextInt();
                    bot1.executarBot(opcao);
                    resp = sc.next().toLowerCase();
            }
        }else{
            System.out.println("Senha invalida!");
        }

    }
}