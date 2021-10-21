package main;

import main.Model.Produto;
import main.View.MenuView;
import main.View.ProdutoView;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ProdutoView produtoView = new ProdutoView();

        MenuView funcaoMenu = new MenuView();

        funcaoMenu.menu();

    }
}
