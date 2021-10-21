package main.Dao;

import main.Model.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    public void gravaArquivo(Produto produto) throws IOException {

        FileWriter arquivoTxt = new FileWriter("C:\\Users\\sgand\\listaDeProdutos.txt",true);
        PrintWriter gravaArq = new PrintWriter(arquivoTxt);

        gravaArq.print(produto.getId() + ";");
        gravaArq.print(produto.getNome() + ";");
        gravaArq.println(produto.getPrice());

        gravaArq.flush();
        arquivoTxt.close();
        gravaArq.close();
    }

    public List<Produto> mostraProdutos() throws IOException {

        FileReader arquivoTxt1 = new FileReader("C:\\Users\\sgand\\listaDeProdutos.txt");
        BufferedReader lerArq = new BufferedReader(arquivoTxt1);

        List<String> result = new ArrayList();

        List<Produto> produtos = new ArrayList<>();

        String linha = " ";

        while  ((linha = lerArq.readLine()) != null) {
            if (linha != null) {
                result.add(linha);
            }
        }

        arquivoTxt1.close();
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
        return produtos;
    }

    public void editaProduto() {

    }

}
