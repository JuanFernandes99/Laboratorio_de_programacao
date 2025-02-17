package projetoExtra1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MenuStore menu = new MenuStore();

		// atribuir ao programador apps
		// programador2.atribuirApp(fruitNinja);
		// programador1.atribuirApp(clashOfClans);
		// programador1.atribuirApp(callOfDuty);

		System.out.println("Bem-vindo � appStore!");
		while (true) {
			menu.menu();
			try {
				int opcao = sc.nextInt();
				sc.nextLine();
				switch (opcao) {

				case 1:
					menu.registarUtilizador();
					break;

				case 2:
					System.out.println("Op��o dispon�vel s� para programadores, deve autenticar-se");
					menu.sairAutenticacaoProg();

					break;

				case 3:
					menu.listarUtilizador();

					break;

				case 4:

					menu.realizarCompras();

					break;

				case 5:

					// System.out.println("Vezes recarregada: " + Lampada.getVezesRecarregada());

					break;

				default:
					System.out.println("S� s�o permitidos n�meros entre 1 a 5 , tente de novo.");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"Erro fatal (448): Digite um n�mero inteiro de 1 at� 2147483647. Os caracteres tamb�m n�o s�o permitidos. Tente novamente :)");
				sc.nextLine(); // Limpar consola
			}
		}
		/*
		 * 
		 * // Criar Compra
		 * 
		 * Compra compra1 = new Compra(cliente1,
		 * Arrays.asList(fruitNinja,clashOfClans)); Compra compra2 = new
		 * Compra(cliente2,Arrays.asList(fruitNinja));
		 * 
		 * 
		 * 
		 * // adicionar utilizadores a playStore playStore.adicionaUtilizador(cliente1);
		 * playStore.adicionaUtilizador(cliente2);
		 * playStore.adicionaUtilizador(programador1);
		 * playStore.adicionaUtilizador(programador2);
		 * 
		 * // compra do cliente cliente1.adicionaCompra(compra1);
		 * cliente2.adicionaCompra(compra2); playStore.adicionarCompra(compra1);
		 * playStore.adicionarCompra(compra2);
		 * 
		 * // criar avalia�oes Avaliacao avaliacao1 = new Avaliacao(cliente1.getId(), 9,
		 * "bom jogo"); Avaliacao avaliacao2 = new Avaliacao(4); // construtor para
		 * avalia�ao anonima Avaliacao avaliacao3 = new Avaliacao(cliente1.getId(), 2,
		 * "bom jogo"); Avaliacao avaliacao4 = new Avaliacao(cliente1.getId(), 4,
		 * "bom jogo");
		 * 
		 * // adicionar avalia�ao a aplica�oes fruitNinja.adicionaAvaliacao(avaliacao1);
		 * fruitNinja.adicionaAvaliacao(avaliacao2);
		 * fruitNinja.adicionaAvaliacao(avaliacao3);
		 * fruitNinja.adicionaAvaliacao(avaliacao4);
		 * clashOfClans.adicionaAvaliacao(avaliacao1);
		 * clashOfClans.adicionaAvaliacao(avaliacao2);
		 * 
		 * // Fazer listagens seletivas das apps por categoria
		 * 
		 * linha(); titulo("Listagens seletivas das apps por categoria (Games)");
		 * System.out.println(playStore.getAplicacoesPorCategoria(TipoAplicacao.Games));
		 * 
		 * // Fazer listagens seletivas por classifica��o dos utilizadores.
		 * 
		 * linha(); titulo("listagens seletivas por classifica��o dos utilizadores >3: "
		 * + playStore.getAplicacoesPorClassificacao(3));
		 * 
		 * // Fazer listagens ordenadas das apps por nome.
		 * 
		 * linha(); titulo("Listagens ordenadas das apps por nome : " +
		 * playStore.listarPorNome());
		 * 
		 * // Fazer listagens ordenadas das apps por n�mero de vendas
		 * 
		 * linha(); titulo("Aplica�oes ordenadas por numero de vendas :" +
		 * playStore.listarPorVendas());
		 * 
		 * // Fazer listagens ordenadas por classifica��o dos utilizadores.
		 * 
		 * linha(); titulo("listagens ordenadas por classifica��o dos utilizadores" +
		 * playStore.listarPorClassificacao());
		 * 
		 * // Listar as classifica��es e coment�rios (se houver) de uma aplica��o em //
		 * concreto.
		 * 
		 * linha();
		 * titulo("Listar as classifica��es e coment�rios (se houver) de uma aplica��oem concreto (Fruit Ninja)."
		 * + fruitNinja.getAvaliacoes());
		 * 
		 * // Listar as aplica��es de um utilizador em concreto (independentemente de
		 * ser // cliente ou programador).
		 * 
		 * linha();
		 * titulo("Listar as aplica��es de um utilizador em concreto (cliente)\n" +
		 * cliente1.getAplicacoes() +"\n");
		 * titulo("Listar as aplica��es de um utilizador em concreto (programador)\n" +
		 * programador1.getAplicacoes());
		 * 
		 * // Imprimir o valor total que a App Store recebeu do conjunto dos seus //
		 * utilizadores. linha();
		 * titulo("Valor total que a App Store recebeu do conjunto dos seus utilizadores: "
		 * + playStore.getLucro() + "�");
		 * 
		 * // Imprimir o valor total que cada programador recebeu do conjunto das suas
		 * apps linha();
		 * titulo("Valor total que cada programador recebeu do conjunto das suas apps: "
		 * + programador1.getLucro() + "�");
		 */
	}

	public static void linha() {
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------");
	}

	public static void titulo(String titulo) {
		System.out.println(titulo);
	}

}