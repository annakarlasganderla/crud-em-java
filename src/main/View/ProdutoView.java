package main.View;

import main.Controller.ProdutoController;
import main.Model.Produto;

import java.io.*;
import java.util.*;

public class ProdutoView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public void cadastraProduto() throws IOException {

        System.out.println("Digite o Id do prduto: ");
        long id2 = leitor.nextLong();

        System.out.println("Digite o nome do produto: ");
        String prod = leitor.next();

        System.out.println("Digite o preço do produto: ");
        Double price2 = leitor.nextDouble();

        Produto produto = new Produto(id2, prod, price2);

        ProdutoController produtoController = new ProdutoController();
        produtoController.cadastrarProduto(produto);

    }

    public void mostraProduto() throws IOException {

        ProdutoController pc = new ProdutoController();
        List<Produto> listaDeProdutos = pc.mostraListaProduto();
        for(int i = 0; i < listaDeProdutos.size(); i++) {
            System.out.println(listaDeProdutos.get(i));
        }

    }

    public void editaProduto() throws IOException {

        ProdutoController produtoController = new ProdutoController();

        List<Produto> listaProdutos = produtoController.mostraListaProduto();

        // mostro a lista de produtos
        for (int i = 0; i < listaProdutos.size(); i++) {
            System.out.println(listaProdutos.get(i));
        }

        System.out.println("Escolha qual produto você quer editar: ");

        int opProduto = leitor.nextInt();
        System.out.println(" 1 - Nome");
        System.out.println(" 2 - Preço");

        int opAtributo = leitor.nextInt();

        switch (opAtributo) {
            case 1:
                listaProdutos.get(opProduto - 1).setNome(leitor.next());
                break;

            case 2:
                listaProdutos.get(opProduto - 1).setPrice(leitor.nextDouble());
                break;

            default:
                System.out.println("Opção inválida");
        }

        produtoController.editaProduto(listaProdutos);

    }

    public void deletaProduto() throws IOException {

        ProdutoController produtoController = new ProdutoController();

        List<Produto> listaProdutos = produtoController.mostraListaProduto();

        // mostro a lista de produtos
        for (int i = 0; i < listaProdutos.size(); i++) {
            System.out.println(listaProdutos.get(i));
        }

        System.out.println("Escolha qual produto você quer deletar: ");
        int opDelete = leitor.nextInt();

        listaProdutos.remove(opDelete - 1);

        produtoController.deletaProduto(listaProdutos);

    }


}
