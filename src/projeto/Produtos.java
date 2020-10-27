package projeto;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Produtos {

    String dados = "";

    ArrayList<Itens> Produtos = new ArrayList<Itens>();

    public void cadastrarProdutos(String codigo, String descricao,
                                  double preco, String data) {

        Itens novoProduto = new Itens();
        novoProduto.codigo = codigo;
        novoProduto.descricao = descricao;
        novoProduto.preco = preco;
        novoProduto.data = data;
        Produtos.add(novoProduto);

        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.",
                "Bomboniere XYZ", JOptionPane.INFORMATION_MESSAGE);
    }

    public String mostrarProdutos() {
        for (Itens produtos : Produtos) {
            dados += " Código do produto: " + produtos.codigo
                    + " Descrição do produto: " + produtos.descricao
                    + " Preço do produto: R$: " + produtos.preco
                    + " Data do cadastro: " + produtos.data + "\n";
        }
        return dados;
    }

    public void imprimirDados() {

        try {
            BufferedWriter texto = new BufferedWriter(new FileWriter("Bomboniere XYZ.txt", true));
            texto.newLine();
            texto.write("Bomboniere XYZ - Cadastro de produtos: ");
            texto.newLine();
            texto.write("===============================================");
            texto.newLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            texto.write(sdf.format(new Date()));
            texto.newLine();
            texto.newLine();

            for (Itens produtos : Produtos) {
                texto.write(("Código do produto: " + produtos.codigo
                        + " Descrição do produto: " + produtos.descricao
                        + " Preço do produto: R$: " + produtos.preco
                        + " Data do cadastro: " + produtos.data + "\n")
                        .replaceAll("\n", "\r\n"));
            }
            texto.newLine();
            texto.flush();
            texto.close();
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso.",
                    "Bomboniere XYZ", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erro ao salvar o documento!",
                    "Cadastro De Produtos: Bomboniere XYZ",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    public void imprimir() {

        if (!Produtos.isEmpty()) {
            File arquivo = new File(System.getProperty("user.dir")
                    + "Bomboniere XYZ.txt");
            PrintWriter imprimir = null;

            try {

                imprimir = new PrintWriter(arquivo);
                imprimir.println("Bomboniere XYZ - Cadastro de produtos: ");
                imprimir.println("============================================");
                imprimir.println(" ");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                imprimir.println(sdf.format(new Date()));
                imprimir.println(" ");

                for (Itens produtos : Produtos) {
                    imprimir.println("Código do produto: " + produtos.codigo
                            + " Descrição do produto: " + produtos.descricao
                            + " Preço do produto: R$: " + produtos.preco
                            + " Data do cadastro: " + produtos.data);
                }
                Desktop.getDesktop().print(arquivo);

            } catch (Exception e) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "Erro ao imprimir o documento!",
                        "Cadastro De Produtos: Bomboniere XYZ",
                        JOptionPane.ERROR_MESSAGE);
            } finally {

                if (imprimir != null) {
                    imprimir.close();
                    arquivo.deleteOnExit();
                }
            }

        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados!",
                    "Cadastro De Produtos: Bomboniere XYZ",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    class Itens {
        private String codigo;
        private String descricao;
        private double preco;
        private String data;
    }
}