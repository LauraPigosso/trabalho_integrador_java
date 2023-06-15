package org.example;

public class Produto {
    private String nome;    //  armazenar o nome do produto
    private double preco;   // armazenar o preço do produto

    public Produto() { }    // Construtor vazio

    // inicializa os atributos nome, marca e preco
    public Produto(String nome, double preco) {
        super();
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;    // Retorna o nome do produto
    }

    public void setNome(String nome) {
        this.nome = nome;   // Define o nome do produto com base no valor passado do excel
    }

    public double getPreco() {
        return preco;   // Retorna o preço do produto
    }

    public void setPreco(double preco) {
        this.preco = preco; //preço do produto com base no valor passado do excel
    }
}
