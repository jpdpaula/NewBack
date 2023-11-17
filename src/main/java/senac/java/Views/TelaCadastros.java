package senac.java.Views;

import senac.java.Domain.Product;
import senac.java.Domain.Sales;
import senac.java.Domain.Users;
import senac.java.Services.Roteamento;

import java.util.Scanner;

public class TelaCadastros {

    static Scanner sc = new Scanner(System.in);
    static Users cliente = new Users();
    static Sales vendedor = new Sales();
    static Product produto = new Product();

    static String resposta = "";
    static Roteamento rota = new Roteamento();

    public static void cadastroVendedor() {

        System.out.println("Bem vindo ao cadastro de vendas");
        System.out.println(" ");
        System.out.println("Preencha corretamente os dados abaixo: ");
        System.out.println(" ");
        System.out.println("Digite a sua imagem");
        vendedor.image = sc.nextLine();
        System.out.println(" ");
        System.out.println("Digite a sua imagem");
        vendedor.titulo = sc.nextLine();
        System.out.println(" ");
        System.out.println("Digite a sua imagem");
        vendedor.subtitulo = sc.nextLine();
        System.out.println(" ");

        System.out.println("Cadastro de vendas realizado com sucesso:");
        System.out.println("Nome: " + vendedor.image);
        System.out.println("Sobrenome: " + vendedor.titulo);
        System.out.println("Telefone: " + vendedor.subtitulo);

        rota.rotasReturn(resposta);
    }

    public static void cadastroCliente() {

        System.out.println("Bem vindo ao cadastro de cliente");
        System.out.println(" ");
        System.out.println("Preencha corretamente os dados abaixo: ");
        System.out.println(" ");
        System.out.println("Digite o seu primeiro nome");
        cliente.nome = sc.nextLine();
        System.out.println(" ");
        System.out.println("Digite o seu sobrenome");
        cliente.lastName = sc.nextLine();
        System.out.println(" ");
        System.out.println("Digite a sua idade");
        cliente.age = Integer.parseInt(sc.nextLine());
        System.out.println(" ");
        System.out.println("Digite o seu endereço completo");
        cliente.address = sc.nextLine();
        System.out.println(" ");
        System.out.println("Digite o seu endereço de email");
        cliente.email = sc.nextLine();
        System.out.println(" ");
        System.out.println("Defina a sua senha");
        cliente.password = sc.nextLine();
        System.out.println(" ");
        System.out.println("Digite o seu CPF");
        cliente.cpf = sc.nextLine();
        System.out.println(" ");

        System.out.println("Cadastro de cliente realizado com sucesso:");
        System.out.println("Nome: " + cliente.nome + " " + cliente.lastName);
        System.out.println("Idade: " + cliente.age);
        System.out.println("Endereço: " + cliente.address);
        System.out.println("E-mail: " + cliente.email);
        System.out.println("CPF: " + cliente.cpf);

        rota.rotasReturn(resposta);
    }

    public static void cadastroProduto() {

        System.out.println("Bem vindo ao cadastro de produto");
        System.out.println(" ");
        System.out.println("Preencha corretamente os dados abaixo: ");
        System.out.println(" ");
        System.out.println("Digite o nome do seu produto");
        produto.pName = sc.nextLine();
        System.out.println("Digite o preço do seu produto");
        produto.pPrice = sc.nextLine();
        System.out.println("Digite a cor do seu produto");
        produto.pColor = sc.nextLine();
        System.out.println("Digite a descrição do seu produto");
        produto.pDescription = sc.nextLine();
        System.out.println("Digite a quantidade de produto");
        produto.pQuantity = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o link de img do seu produto");
        produto.img = sc.nextLine();
        System.out.println(" ");

        System.out.println("Cadastro de produto realizado com sucesso:");
        System.out.println("Nome do produto: " + produto.pName);
        System.out.println("Preço do produto: " + produto.pPrice);
        System.out.println("Cor do produto: " + produto.pColor);
        System.out.println("Descrição do produto: " + produto.pDescription);
        System.out.println("Quantidade do produto: " + produto.pQuantity);
        System.out.println("Link da imagem do produto: " + produto.img);

        rota.rotasReturn(resposta);
    }
}