package main.Controller;

import main.Dao.ProdutoDao;
import main.Model.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    public void cadastrarProduto(Produto produto) throws IOException {
        ProdutoDao prodDao = new ProdutoDao();
        prodDao.gravaArquivo(produto);
    }

    public List<Produto> mostraListaProduto() throws IOException {

        ProdutoDao prodDao = new ProdutoDao();
        List<Produto> prods = prodDao.mostraProdutos();
        return prods;
    }

    public void editaProduto(List<Produto> listaDeProduto) throws IOException {

        ProdutoDao prodDao = new ProdutoDao();
        prodDao.editaProduto(listaDeProduto);

    }

    public void deletaProduto(List<Produto> listaDeProduto) throws IOException {
        ProdutoDao prodDao = new ProdutoDao();
        prodDao.deletaProduto(listaDeProduto);
    }

}
