package Biblioteca;

public class Autor {
    // Atributos do autor
    private String nome;
    private String pais;

    // Construtor do autor
    public Autor(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    // Métodos de acesso aos atributos do autor
    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    // Método que retorna uma representação textual do autor
    public String toString() {
        return "Nome: " + nome + "\nPaís: " + pais;
    }
}
