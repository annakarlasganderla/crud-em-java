package main.View;

import main.Controller.ProdutoController;
import main.Model.Produto;

import java.io.IOException;
import java.util.*;


public class ProdutoView {

    Scanner leitor = new Scanner(System.in);

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

    public void editaProduto() {

        System.out.println("Escolha um produto para editar: ");
        int opProduto = leitor.nextInt();  // usuário escolhe o produto

    }

    public void deletaProduto() {

        System.out.println("Escolha um produto para deletar: ");
        int opDelete = leitor.nextInt();  // usuário escolhe o produto

    }
}
