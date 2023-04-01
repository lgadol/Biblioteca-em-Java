package Biblioteca;

public class ListaLivros {
    // Atributo que armazena os livros em um vetor
    private Livro[] livros;

    // Atributo que indica a quantidade de livros na lista
    private int quantidade;

    // Construtor da lista de livros
    public ListaLivros(int capacidade) {
        livros = new Livro[capacidade];
        quantidade = 0;
    }

    // Método que inclui um livro no início da lista
    public void incluirNoInicio(Livro livro) {
        // Verifica se a lista está cheia
        if (quantidade == livros.length) {
            System.out.println("Lista cheia!");
            return;
        }
        // Desloca os livros para a direita
        for (int i = quantidade; i > 0; i--) {
            livros[i] = livros[i-1];
        }
        // Insere o livro na primeira posição
        livros[0] = livro;
        // Incrementa a quantidade de livros na lista
        quantidade++;
    }

    // Método que inclui um livro no final da lista
    public void incluirNoFim(Livro livro) {
        // Verifica se a lista está cheia
        if (quantidade == livros.length) {
            System.out.println("Lista cheia!");
            return;
        }
        // Insere o livro na última posição livre
        livros[quantidade] = livro;
        // Incrementa a quantidade de livros na lista
        quantidade++;
    }

    // Método que ordena os livros na lista em ordem alfabética de título
    public void ordenar() {
        // Usa o algoritmo de seleção para ordenar o vetor de livros
        for (int i = 0; i < quantidade - 1; i++) {
            // Encontra o índice do menor título a partir da posição i
            int indiceMenor = i;
            for (int j = i + 1; j < quantidade; j++) {
                if (livros[j].getTitulo().compareTo(livros[indiceMenor].getTitulo()) < 0) {
                    indiceMenor = j;
                }
            }
            // Troca o livro da posição i com o livro da posição indiceMenor
            Livro aux = livros[i];
            livros[i] = livros[indiceMenor];
            livros[indiceMenor] = aux;
        }
    }

    // Método que remove um livro do final da lista e o retorna
    public Livro removerDoFim() {
        // Verifica se a lista está vazia
        if (quantidade == 0) {
            System.out.println("Lista vazia!");
            return null;
        }
        // Decrementa a quantidade de livros na lista
        quantidade--;
        // Retorna o livro removido
        return livros[quantidade];
    }

    // Método que retorna a quantidade de livros na lista
    public int tamanho() {
        return quantidade;
    }

    // Método que retorna o livro que está na posição da lista indicada no argumento
    public Livro get(int posicao) {
        // Verifica se a posição é válida
        if (posicao < 0 || posicao >= quantidade) {
            System.out.println("Posição inválida!");
            return null;
        }
        // Retorna o livro na posição indicada
        return livros[posicao];
    }
}