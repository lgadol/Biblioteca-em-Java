package Biblioteca;

import java.util.Scanner;

public class Biblioteca {
    // Atributo que armazena a lista de livros
    private ListaLivros listaLivros;

    // Atributo que armazena a lista de autores
    private ListaAutores listaAutores;

    // Construtor do programa
    public Biblioteca(int capacidade) {
        listaLivros = new ListaLivros(capacidade);
        listaAutores = new ListaAutores(capacidade);
    }

    // Método que exibe um menu de opções para o usuário
    public void menu() {
        // Cria um objeto da classe Scanner para ler dados do teclado
        Scanner teclado = new Scanner(System.in);
        // Variável que armazena a opção escolhida pelo usuário
        int opcao;
        // Laço que repete até que o usuário digite 0 para sair
        do {
            // Exibe as opções disponíveis
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar autor");
            System.out.println("3 - Exibir os títulos de todos os livros cadastrados em ordem alfabética");
            System.out.println("4 - Exibir os títulos dos livros de um determinado autor");
            System.out.println("5 - Exibir os títulos dos livros publicados em um determinado intervalo de anos");
            System.out.println("6 - Exibir título, autor e editora de todos os livros que contenham, em seu título, uma palavra ou frase digitada pelo usuário");
            System.out.println("0 - Sair");
            // Lê a opção digitada pelo usuário
            opcao = teclado.nextInt();
            // Chama o método correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarAutor();
                    break;
                case 3:
                    exibirTitulosOrdenados();
                    break;
                case 4:
                    exibirTitulosPorAutor();
                    break;
                case 5:
                    exibirTitulosPorAno();
                    break;
                case 6:
                    exibirTitulosPorPalavra();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        // Fecha o objeto Scanner
        teclado.close();
    }

    // Método que cadastra um livro na lista
    public void cadastrarLivro() {
        try (// Cria um objeto da classe Scanner para ler dados do teclado
		Scanner teclado = new Scanner(System.in)) {
			// Solicita os dados do livro ao usuário
			System.out.println("Digite o título do livro:");
			String titulo = teclado.nextLine();
			System.out.println("Digite o ISBN do livro:");
			String isbn = teclado.nextLine();
			System.out.println("Digite o nome do autor do livro:");
			String nomeAutor = teclado.nextLine();
			System.out.println("Digite o país de origem do autor do livro:");
			String paisAutor = teclado.nextLine();
			System.out.println("Digite a editora do livro:");
			String editora = teclado.nextLine();
			System.out.println("Digite o ano de publicação do livro:");
			int ano = teclado.nextInt();
			// Cria um objeto da classe Autor com os dados informados
			Autor autor = new Autor(nomeAutor, paisAutor);
			// Cria um objeto da classe Livro com os dados informados
			Livro livro = new Livro(titulo, isbn, autor, editora, ano);
			// Inclui o livro na lista de livros
			listaLivros.incluirNoFim(livro);
		}
        // Exibe uma mensagem de confirmação
        System.out.println("Livro cadastrado com sucesso!");
    }

    // Método que cadastra um autor na lista
    public void cadastrarAutor() {
        try (// Cria um objeto da classe Scanner para ler dados do teclado
		Scanner teclado = new Scanner(System.in)) {
			// Solicita os dados do autor ao usuário
			    System.out.println("Digite o nome do autor:");
			    String nome = teclado.nextLine();
			    System.out.println("Digite o país de origem do autor:");
			    String pais = teclado.nextLine();
			    // Cria um objeto da classe Autor com os dados informados
			    Autor autor = new Autor(nome, pais);
			    // Inclui o autor na lista de autores
			    listaAutores.incluirNoFim(autor);
		}
     // Exibe uma mensagem de confirmação
        System.out.println("Autor cadastrado com sucesso!");
    }

    // Método que exibe os títulos de todos os livros cadastrados em ordem alfabética
    public void exibirTitulosOrdenados() {
        // Ordena a lista de livros
        listaLivros.ordenar();
        // Exibe um cabeçalho
        System.out.println("Títulos dos livros cadastrados em ordem alfabética:");
        // Percorre a lista de livros e exibe o título de cada um
        for (int i = 0; i < listaLivros.tamanho(); i++) {
            Livro livro = listaLivros.get(i);
            System.out.println(livro.getTitulo());
        }
    }

    // Método que exibe os títulos dos livros de um determinado autor
    public void exibirTitulosPorAutor() {
        try (// Cria um objeto da classe Scanner para ler dados do teclado
		Scanner teclado = new Scanner(System.in)) {
			// Solicita o nome do autor ao usuário
			System.out.println("Digite o nome do autor:");
			String nomeAutor = teclado.nextLine();
			// Exibe um cabeçalho
			System.out.println("Títulos dos livros do autor " + nomeAutor + ":");
			// Percorre a lista de livros e verifica se o autor é o mesmo informado pelo usuário
			for (int i = 0; i < listaLivros.tamanho(); i++) {
			    Livro livro = listaLivros.get(i);
			    if (livro.getAutor().getNome().equals(nomeAutor)) {
			        // Se for, exibe o título do livro
			        System.out.println(livro.getTitulo());
			    }
			}
		}
    }

    // Método que exibe os títulos dos livros publicados em um determinado intervalo de anos
    public void exibirTitulosPorAno() {
        try (// Cria um objeto da classe Scanner para ler dados do teclado
		Scanner teclado = new Scanner(System.in)) {
			// Solicita o ano inicial e o ano final ao usuário
			System.out.println("Digite o ano inicial:");
			int anoInicial = teclado.nextInt();
			System.out.println("Digite o ano final:");
			int anoFinal = teclado.nextInt();
			// Exibe um cabeçalho
			System.out.println("Títulos dos livros publicados entre " + anoInicial + " e " + anoFinal + ":");
			// Percorre a lista de livros e verifica se o ano de publicação está no intervalo informado pelo usuário
			for (int i = 0; i < listaLivros.tamanho(); i++) {
			    Livro livro = listaLivros.get(i);
			    if (livro.getAno() >= anoInicial && livro.getAno() <= anoFinal) {
			        // Se estiver, exibe o título do livro
			        System.out.println(livro.getTitulo());
			    }
			}
		}
    }

    // Método que exibe título, autor e editora de todos os livros que contenham, em seu título, uma palavra ou frase digitada pelo usuário
    public void exibirTitulosPorPalavra() {
        try (// Cria um objeto da classe Scanner para ler dados do teclado
		Scanner teclado = new Scanner(System.in)) {
			// Solicita a palavra ou frase ao usuário
			System.out.println("Digite a palavra ou frase que deseja buscar no título dos livros:");
			String palavra = teclado.nextLine();
    // Exibe um cabeçalho
			System.out.println("Livros que contêm '" + palavra + "' no título:");
			// Percorre a lista de livros e verifica se o título contém a palavra ou frase informada pelo usuário
			for (int i = 0; i < listaLivros.tamanho(); i++) {
			    Livro livro = listaLivros.get(i);
			    if (livro.getTitulo().contains(palavra)) {
			        // Se contiver, exibe o título, o autor e a editora do livro
			        System.out.println("Título: " + livro.getTitulo());
			        System.out.println("Autor: " + livro.getAutor().getNome());
			        System.out.println("Editora: " + livro.getEditora());
			        System.out.println();
			    }
			}
		}
    }

    // Método principal que cria um objeto da classe Biblioteca e chama o método menu
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(100); // Cria uma biblioteca com capacidade para 100 livros e 100 autores
        biblioteca.menu(); // Chama o método menu
    }
}
	    