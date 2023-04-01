package Biblioteca;

public class Livro {
    // Atributos do livro
    private String titulo;
    private String isbn;
    private Autor autor;
    private String editora;
    private int ano;

    // Construtor do livro
    public Livro(String titulo, String isbn, Autor autor, String editora, int ano) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
    }

    // Métodos de acesso aos atributos do livro
    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }

    // Método que retorna uma representação textual do livro
    public String toString() {
        return "Título: " + titulo + "\nISBN: " + isbn + "\nAutor: " + autor + "\nEditora: " + editora + "\nAno: " + ano;
    }
}