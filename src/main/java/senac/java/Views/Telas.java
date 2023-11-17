package senac.java.Views;

import java.util.Scanner;
import senac.java.Services.Roteamento;

public class Telas {
    static Scanner sc = new Scanner(System.in);

    public static void telaInicial() {
        int escolhaInput = 0;

        System.out.println("Bem vindo ao nosso código!!");
        System.out.println(" ");

        System.out.println("Selecione a opção desejada:");
        System.out.println(" ");
        System.out.println("1. Cadastrar Vendedor");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Cadastrar Produto");
        System.out.println("4. Sair");
        System.out.println("5. inicializar servidor web");
        escolhaInput = Integer.parseInt(sc.nextLine());

        Roteamento.rotas(escolhaInput);
    }
}