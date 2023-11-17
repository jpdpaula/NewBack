package senac.java.Services;

import senac.java.Views.TelaCadastros;
import senac.java.Views.Telas;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.exit;

public class Roteamento {
    static Telas telas = new Telas();
    //    static Telas telas = new Telas();
    static TelaCadastros telaTelaCadastros = new TelaCadastros();
    static Scanner sc = new Scanner(System.in);

    public static void rotas(int escolha) {

        switch (escolha) {
            case 1:
                telaTelaCadastros.cadastroVendedor();
                break;
            case 2:
                telaTelaCadastros.cadastroCliente();
                break;
            case 3:
                telaTelaCadastros.cadastroProduto();
                break;
            case 4:
                exit(0);
                break;
            case 5:
                System.out.println("Inicializando servidor");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                telas.telaInicial();
                break;
        }
    }

    public static void rotasReturn(String resposta) {
        int tipoCadastro;

        System.out.println("Se deseja criar um novo cadastro digite (S), " +
                "se quiser voltar para o menu para poder sair digite (N): ");
        resposta = sc.nextLine().toLowerCase(Locale.ROOT);

        switch (resposta) {
            case "s":
                do {
                    System.out.println("Escolha o tipo de cadastro:");
                    System.out.println("1 - Cadastro de Vendedor");
                    System.out.println("2 - Cadastro de Cliente");
                    System.out.println("3 - Cadastro de Produto");
                    System.out.println("4 - Voltar para o menu principal");
                    tipoCadastro = Integer.parseInt(sc.nextLine());

                    switch (tipoCadastro) {
                        case 1:
                            telaTelaCadastros.cadastroVendedor();
                            break;
                        case 2:
                            telaTelaCadastros.cadastroCliente();
                            break;
                        case 3:
                            telaTelaCadastros.cadastroProduto();
                            break;
                        case 4:
                            telas.telaInicial();
                            break;
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                    }
                } while (tipoCadastro != 4);
                break;
            case "n":
                telas.telaInicial();
                break;
            default:
                System.out.println("Resposta inválida! Tente novamente.");
                break;
        }
    }
}