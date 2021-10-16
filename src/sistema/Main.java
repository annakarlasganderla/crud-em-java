package sistema;

import java.io.*;
import java.util.*;

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
                System.out.println("-------------------------------------------");
                System.out.println("|  0 - Sair                               |");
                System.out.println("|  1 - Cadastrar produto                  |");
                System.out.println("|  2 - Visualizar produtos cadastrados    |");
                System.out.println("|  3 - Editar produto                     |");
                System.out.println("|  4 - Deletar produto                    |");
                System.out.println("-------------------------------------------");
                System.out.println("|        Digite aqui sua opção:           |");
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
                        //produtos.add(produto);

                        gravaArq.println(produto);

                        System.out.println("Deseja cadastrar outro produto? s ou S para sim");
                        controle = leitor.next().charAt(0); // pesquisar sobre o charAt

                    } while (controle == 's' || controle == 'S');

                    gravaArq.flush();
                    arquivoTxt.close();
                    gravaArq.close();

                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    System.out.println("---- Produtos cadastrados ----");

                    arquivoTxt1 = new FileReader("C:\\Users\\sgand\\listaDeProdutos.txt");
                    lerArq = new BufferedReader(arquivoTxt1);

                    String linha = "";  // variável para conferir se tem coisa na linha

                    while  ((linha = lerArq.readLine()) != null) {
                        if (linha != null) {
                            System.out.println(linha);
                        }
                    }

                    arquivoTxt.close();
                    lerArq.close();

                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    List<String> result = new ArrayList();

                    arquivoTxt1 = new FileReader("C:\\Users\\sgand\\listaDeProdutos.txt");
                    lerArq = new BufferedReader(arquivoTxt1);

                    while  ((linha = lerArq.readLine()) != null) {
                        if (linha != null) {
                            result.add(linha);
                            System.out.println(linha);
                        }
                    }

                    arquivoTxt.close();
                    lerArq.close();

                    for (String i: result) {  // o arquivo le como se fosse uma String
                        String[] prod = i.split(";");
                        Produto produto2 = new Produto();

                        // gambis pra criar o objeto | retornar a variável ao tipo inicial
                        produto2.setId(Long.valueOf(prod[0])); // tipo long
                        produto2.setNome(prod[1]);  // aq ja era string
                        produto2.setPrice(Double.valueOf(prod[2])); // tipo double

                        produtos.add(produto2);
                    }

                    System.out.println("Escolha um produto para editar: ");
                    int opProduto = leitor.nextInt();  // usuário escolhe o produto

                    System.out.println(produtos.get(opProduto));

                    System.out.println("1 - Nome");
                    System.out.println("2 - Preço");

                    int opAtributo = leitor.nextInt();

                    switch (opAtributo) {
                        case 1:
                            produtos.get(opProduto - 1).setNome(leitor.next());
                            break;

                        case 2:
                            produtos.get(opProduto - 1).setPrice(leitor.nextDouble());
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }

                    arquivoTxt = new FileWriter("C:\\Users\\sgand\\listaDeProdutos.txt",false);
                    gravaArq = new PrintWriter(arquivoTxt);

                    for (int list = 0; list < produtos.size(); list++) {
                        gravaArq.println(produtos.get(list));
                    }

                    gravaArq.flush();
                    arquivoTxt.close();
                    gravaArq.close();

                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();

                    break;

                case 4:
                    System.out.println("Opção em andamento");
                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();
                    break;

                default:
                    System.out.println("Opção invalida");
                    System.out.println("4 - Voltar");
                    op = leitor.nextInt();

            }

        } while (op != 0);
    }
}
