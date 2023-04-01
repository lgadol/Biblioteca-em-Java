package Biblioteca;

public class ListaAutores {
    // Atributo que armazena os autores em um vetor
    private Autor[] autores;

    // Atributo que indica a quantidade de autores na lista
    private int quantidade;

    // Construtor da lista de autores
    public ListaAutores(int capacidade) {
        autores = new Autor[capacidade];
        quantidade = 0;
    }

    // Método que inclui um autor no início da lista
    public void incluirNoInicio(Autor autor) {
        // Verifica se a lista está cheia
        if (quantidade == autores.length) {
            System.out.println("Lista cheia!");
            return;
        }
        // Desloca os autores para a direita
        for (int i = quantidade; i > 0; i--) {
            autores[i] = autores[i-1];
        }
        // Insere o autor na primeira posição
        autores[0] = autor;
        // Incrementa a quantidade de autores na lista
        quantidade++;
    }

    // Método que inclui um autor no final da lista
    public void incluirNoFim(Autor autor) {
        // Verifica se a lista está cheia
        if (quantidade == autores.length) {
            System.out.println("Lista cheia!");
            return;
        }
        // Insere o autor na última posição livre
        autores[quantidade] = autor;
        // Incrementa a quantidade de autores na lista
        quantidade++;
    }

    // Método que ordena os autores na lista em ordem alfabética de nome
    public void ordenar() {
        // Usa o algoritmo de seleção para ordenar o vetor de autores
        for (int i = 0; i < quantidade - 1; i++) {
            // Encontra o índice do menor nome a partir da posição i
            int indiceMenor = i;
            for (int j = i + 1; j < quantidade; j++) {
                if (autores[j].getNome().compareTo(autores[indiceMenor].getNome()) < 0) {
                    indiceMenor = j;
                }
            }
            // Troca o autor da posição i com o autor da posição indiceMenor
            Autor aux = autores[i];
            autores[i] = autores[indiceMenor];
            autores[indiceMenor] = aux;
        }
    }

    // Método que remove um autor do final da lista e o retorna
    public Autor removerDoFim() {
        // Verifica se a lista está vazia
        if (quantidade == 0) {
            System.out.println("Lista vazia!");
            return null;
        }
        // Decrementa a quantidade de autores na lista
        quantidade--;
        // Retorna o autor removido
        return autores[quantidade];
    }

    // Método que retorna a quantidade de autores na lista
    public int tamanho() {
        return quantidade;
    }

    // Método que retorna o autor que está na posição da lista indicada no argumento
    public Autor get(int posicao) {
        // Verifica se a posição é válida
        if (posicao < 0 || posicao >= quantidade) {
            System.out.println("Posição inválida!");
            return null;
        }
     // Retorna o autor na posição indicada
        return autores[posicao];
    }
}
