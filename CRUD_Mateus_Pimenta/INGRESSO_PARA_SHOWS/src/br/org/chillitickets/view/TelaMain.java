package br.org.chillitickets.view;
import br.org.chillitickets.dao.CrudDAO;
import br.org.chillitickets.model.Ingressos;

import java.util.Scanner;
public class TelaMain {

	public static void main(String[] args) {
		/*
		//instanciar um objeto da classe CrudDAO
		CrudDAO inserir_aluno = new CrudDAO();
		//instanciar um objeto aluno
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Marcelo");
		aluno1.setIdade(17);
		inserir_aluno.create(aluno1);
		System.out.println("Nome: " + aluno1.getNome() + " Idade: " + aluno1.getIdade());
		
		//*************************************************************************************************
		//att valores
		
		aluno1.setNome("Marcelo Vieira");
		aluno1.setIdade(32);
		aluno1.setRa(1);
		inserir_aluno.update(aluno1);
		System.out.println("Nome: " + aluno1.getNome() + " Idade: " + aluno1.getIdade());
		
		//*************************************************************************************************
		//ler tabela alunos do bd
		System.out.println("lendo a lista....");
		for(Aluno olho : inserir_aluno.read()) {
			System.out.println("dados do aluno: " + olho.getRa()+ " " + olho.getNome()+ " " + olho.getIdade());
		}
		//******************************************************************************************************
		//excluir dados
		CrudDAO remover_aluno = new CrudDAO();
		remover_aluno.delete(1);
		*/
		
		Scanner entrada = new Scanner(System.in);
		CrudDAO inserir_ingresso = new CrudDAO();
		Ingressos ingresso = new Ingressos();
		exibirMenu();
		int opcao = entrada.nextInt();
		do {
			switch(opcao) {
			case 1:
				System.out.println("categoria:");
				ingresso.setCategoria(entrada.next());
				System.out.println("forma de pagamento:");
				ingresso.setFp(entrada.next());
				System.out.println("preco:");
				ingresso.setPreco(entrada.nextFloat());
				inserir_ingresso.create(ingresso);
				System.out.println("categoria: " + ingresso.getCategoria() + " preco: " + ingresso.getPreco() + 
						" forma de pagamento: " + ingresso.getFp());
				break;
			case 2:
				System.out.println("categoria:");
				ingresso.setCategoria(entrada.next());
				System.out.println("preco");
				ingresso.setPreco(entrada.nextFloat());
				System.out.println("forma de pagamento");
				ingresso.setFp(entrada.next());
				System.out.println("Id:");
				ingresso.setId(entrada.nextInt());
				inserir_ingresso.update(ingresso);
				System.out.println("categoria: " + ingresso.getCategoria() + " preco: " + ingresso.getPreco() + " forma de pagamento: " + ingresso.getFp());
				break;
			case 3:
				for(Ingressos olho : inserir_ingresso.read()) {
					System.out.println("Dados do ingresso: " + olho.getId()+ " " + olho.getCategoria()+ " " + olho.getPreco() + " " + olho.getFp());
				}
				break;
			case 4:
				
				CrudDAO remover_ingresso = new CrudDAO();
				System.out.println("Digite o Id do ingresso que deseja excluir:");
				remover_ingresso.delete(entrada.nextInt());
			}
		}while(opcao <= 0);
	}
	public static void exibirMenu() {
	System.out.println("1- Criar Ingresso");
	System.out.println("2- Atualizar Ingresso");
	System.out.println("3- Ler a lista");
	System.out.println("4- Excluir Ingresso");
	}
}
