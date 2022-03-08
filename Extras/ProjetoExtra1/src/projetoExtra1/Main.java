package projetoExtra1;

import java.util.Arrays;
import utilizador.Cliente;
import utilizador.Programador;

public class Main {

	public static void main(String[] args) {
		
		// Registar novos utilizadores.
		Programador programador1 = new Programador("Juan", 22);
		Programador programador2 = new Programador("Ligia", 22);
		Cliente cliente1 = new Cliente("Jessica", 25, 500);
		Cliente cliente2 = new Cliente("Ligia", 25 , 800);

		// Criar AppStore
		AppStore playStore = new AppStore("PlayStore");

		// Criar Aplicaçoes
		Aplicacao fruitNinja = programador1.desenvolverAplicacao("Fruit Ninja", 50, TipoAplicacao.Games);
		Aplicacao clashOfClans = programador2.desenvolverAplicacao("Clash of clans", 70, TipoAplicacao.Games);
		Aplicacao callOfDuty = programador1.desenvolverAplicacao("Call Of Duty", 60, TipoAplicacao.Games);

		// Criar Compra

		Compra compra1 = new Compra(cliente1, Arrays.asList(fruitNinja, clashOfClans));
		Compra compra2 = new Compra(cliente2, Arrays.asList(fruitNinja));

		// atribuir ao programador apps
		programador2.atribuirApp(fruitNinja);
		programador1.atribuirApp(clashOfClans);
		programador1.atribuirApp(callOfDuty);
		
		// adicionar utilizadores a playStore
		playStore.adicionaUtilizador(cliente1);
		playStore.adicionaUtilizador(cliente2);
		playStore.adicionaUtilizador(programador1);
		playStore.adicionaUtilizador(programador2);

		// adicionar apps a playStore
		playStore.adicionaApp(fruitNinja);
		playStore.adicionaApp(clashOfClans);

		// compra do cliente
		cliente1.adicionaCompra(compra1);
		cliente2.adicionaCompra(compra2);
		playStore.adicionarCompra(compra1);
		playStore.adicionarCompra(compra2);

		// criar avaliaçoes
		Avaliacao avaliacao1 = new Avaliacao(cliente1.getId(), 9, "bom jogo");
		Avaliacao avaliacao2 = new Avaliacao(4); // construtor para avaliaçao anonima
		Avaliacao avaliacao3 = new Avaliacao(cliente1.getId(), 2, "bom jogo");
		Avaliacao avaliacao4 = new Avaliacao(cliente1.getId(), 4, "bom jogo");

		// adicionar avaliaçao a aplicaçoes
		fruitNinja.adicionaAvaliacao(avaliacao1);
		fruitNinja.adicionaAvaliacao(avaliacao2);
		fruitNinja.adicionaAvaliacao(avaliacao3);
		fruitNinja.adicionaAvaliacao(avaliacao4);
		clashOfClans.adicionaAvaliacao(avaliacao1);
		clashOfClans.adicionaAvaliacao(avaliacao2);

		// Fazer listagens seletivas das apps por categoria

		linha();
		titulo("Listagens seletivas das apps por categoria (Games)");
		System.out.println(playStore.getAplicacoesPorCategoria(TipoAplicacao.Games));

		// Fazer listagens seletivas por classificação dos utilizadores.

		linha();
		titulo("listagens seletivas por classificação dos utilizadores >3: "
				+ playStore.getAplicacoesPorClassificacao(3));

		// Fazer listagens ordenadas das apps por nome.

		linha();
		titulo("Listagens ordenadas das apps por nome : " + playStore.listarPorNome());

		// Fazer listagens ordenadas das apps por número de vendas

		linha();
		titulo("Aplicaçoes ordenadas por numero de vendas :" + playStore.listarPorVendas());

		// Fazer listagens ordenadas por classificação dos utilizadores.

		linha();
		titulo("listagens ordenadas por classificação dos utilizadores" + playStore.listarPorClassificacao());

		// Listar as classificações e comentários (se houver) de uma aplicação em
		// concreto.

		linha();
		titulo("Listar as classificações e comentários (se houver) de uma aplicaçãoem concreto (Fruit Ninja)."
				+ fruitNinja.getAvaliacoes());

		// Listar as aplicações de um utilizador em concreto (independentemente de ser
		// cliente ou programador).

		linha();
		titulo("Listar as aplicações de um utilizador em concreto (cliente)\n"
				+ cliente1.getAplicacoes() +"\n");
		titulo("Listar as aplicações de um utilizador em concreto (programador)\n"
				+ programador1.getAplicacoes());

		// Imprimir o valor total que a App Store recebeu do conjunto dos seus
		// utilizadores.
		linha();
		titulo("Valor total que a App Store recebeu do conjunto dos seus utilizadores: " + playStore.getLucro() + "€");

		// Imprimir o valor total que cada programador recebeu do conjunto das suas apps
		linha();
		titulo("Valor total que cada programador recebeu do conjunto das suas apps: " + programador1.getLucro() + "€");

	}

	public static void linha() {
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------");
	}

	public static void titulo(String titulo) {
		System.out.println(titulo);
	}
}