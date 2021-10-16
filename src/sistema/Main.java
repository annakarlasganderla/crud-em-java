package sistema;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner leitor = new Scanner(System.in).useDelimiter("\n");
        leitor.useLocale(Locale.US);

        ArrayList<Produto> produtos = new ArrayList<Produto>();

        FileWriter arquivoTxt = new FileWriter("C:\\Users\\sgand\\listaDeProdutos.txt",true);

        PrintWriter gravaArq = new PrintWriter(arquivoTxt);

        FileReader arquivoTxt1 = new FileReader("C:\\Users\\sgand\\listaDeProdutos.txt");

        BufferedReader lerArq = new BufferedReader(arquivoTxt1);

        char controle = 's';
        int op;

        do {

            do {
                System.out.println("--------------------");
                System.out.println("0 - Sair");
                System.out.println("1 - Cadastrar produto");
                System.out.println("2 - Visualizar produtos cadastrados");
                System.out.println("3 - Editar produto");
                System.out.println("4 - Deletar produto");
                System.out.println("--------------------");
                System.out.print("Digite aqui sua opção: ");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {
                case 0:
                    break;

                case 1:
                    do {
                        System.out.println("Digite o Id do prduto: ");
                        long id2 = leitor.nextLong();

                        System.out.println("Digite o nome do produto: ");
                        String prod = leitor.next();

                        System.out.println("Digite o preço do produto: ");
                        Double price2 = leitor.nextDouble();

                        Produto produto = new Produto(id2, prod, price2);
                        produtos.add(produto);

                        gravaArq.println(produtos);

                        System.out.println("Deseja cadastrar outro produto? s ou S para sim");
                        controle = leitor.next().charAt(0); // pesquisar sobre o charAt

                    } while (controle == 's' || controle == 'S');

                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    System.out.println("---- Produtos cadastrados ----");
                        for (Produto i: produtos) {
                            System.out.println(i);
                        }
                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    System.out.println("Editar");
                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    System.out.println("Deletar");
                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();
                    break;

                default:
                    System.out.println("Opção invalida");
                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();

            }



        } while (op != 0);

        gravaArq.flush();
        arquivoTxt.close();
        gravaArq.close();

    }
}
