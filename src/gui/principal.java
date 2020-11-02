package gui;

import java.util.Scanner;
import java.util.Date;

import dados.RepositorioComentarios;
import dados.RepositorioEventos;
import dados.RepositorioPessoas;
import negocio.bean.Aluno;
import negocio.bean.Comentario;
import negocio.bean.Evento;
import negocio.bean.Professor;

public class principal {

	public static void main(String[] args) {
		
		RepositorioPessoas professores = new RepositorioPessoas();
		RepositorioPessoas alunos = new RepositorioPessoas();
		RepositorioEventos eventos = new RepositorioEventos();
		
		System.out.println("Menu inicial: \n"
				+ "1 - para fazer login \n"
				+ "2 - para cadastrar novo Professor \n"
				+ "3 - para cadastrar novo Aluno \n");		
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		if (n == 1) {
			telaLogin(professores, alunos, eventos);
		} else if (n == 2) {
			System.out.println("inisra o nome: ");
			Scanner b = new Scanner(System.in);
			String nome = b.nextLine();
			System.out.println("inisra o matricula: ");
			String matricula = b.nextLine();
			System.out.println("inisra o senha: ");
			String senha = b.nextLine();
			
			Professor professor = new Professor (nome, matricula, senha);
			professores.addUsuario(professor);
			telaLogin(professores, alunos, eventos);
			
		}  else if (n == 3) {
			System.out.println("inisra o nome: ");
			Scanner b = new Scanner(System.in);
			String nome = b.nextLine();
			System.out.println("inisra o matricula: ");
			String matricula = b.nextLine();
			System.out.println("inisra o senha: ");
			String senha = b.nextLine();
			
			Aluno aluno = new Aluno (nome, matricula, senha);
			alunos.addUsuario(aluno);
			telaLogin(professores, alunos, eventos);
			
		} else {
			System.out.println("Valor invalido");
		}
		
	}
	
	//metodos que representam as telas
	
	public static void telaLogin(RepositorioPessoas professores, RepositorioPessoas alunos, RepositorioEventos eventos) {
		System.out.println("Escolha sua funcao: \n"
				+ "1 - Professor \n"
				+ "2 - Aluno \n");		
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		if (n == 1) {
			System.out.println("inisra matricula: ");
			Scanner b = new Scanner(System.in);
			String matricula = b.nextLine();
			System.out.println("inisra o senha: ");
			String senha = b.nextLine();
			Professor professor = (Professor) professores.procurarUsuario(matricula);
			principalProfessor(professores, alunos, eventos, professor);
			
		} else if (n == 2)  {
			System.out.println("inisra matricula: ");
			Scanner b = new Scanner(System.in);
			String matricula = b.nextLine();
			System.out.println("inisra o senha: ");
			String senha = b.nextLine();
			Aluno aluno = (Aluno) alunos.procurarUsuario(matricula);
			principalAluno(professores, alunos, eventos, aluno);
		
		} 
	}
	
	public static void principalProfessor(RepositorioPessoas professores, RepositorioPessoas alunos, RepositorioEventos eventos, Professor professor) {
		int n = 0;
		while (n != 5) {
			eventos.mostrarEventos();
			System.out.println("Menu Principal: \n"
					+ "1 - criar evento \n"
					+ "2 - comentar eventos \n"
					+ "3 - apagar evento \n"
					+ "4 - editar evento \n"
					+ "5 - logoff \n");		
			Scanner a = new Scanner(System.in);
			n = a.nextInt();
			if (n == 1) {
				int id = eventos.size()+1;
				Date data = new Date();
				System.out.println("insira a descricao do evento: ");
				String d = a.next();
				Evento evento = new Evento(id, professor, data, d, null);
				eventos.addEvento(evento);
			} else if (n == 2) {
				System.out.println("escreva o id do evento que voce quer comentar: ");
				int id = a.nextInt();
				eventos.procurarEvento(id).toString();
				paginaComentario(eventos, id);
			} else if (n == 3) {
				System.out.println("escreva o id do evento que voce quer apagar: ");
				int id = a.nextInt();
				eventos.removerEvento(id);
			} else if (n == 4) {
				System.out.println("escreva o id do evento que voce quer editar: ");
				int id = a.nextInt();
				Date data = new Date();
				System.out.println("insira a descricao do evento: ");
				String d = a.next();		
				Evento evento = new Evento(id, professor, data, d, null);
				eventos.editarEvento(id, evento);
			} else if (n == 5) {
				telaLogin(professores, alunos, eventos);
			}
		}
		
	}
	
	public static void principalAluno(RepositorioPessoas professores, RepositorioPessoas alunos, RepositorioEventos eventos, Aluno aluno) {
		int n = 0;
		while (n != 2) {
			eventos.mostrarEventos();
			System.out.println("Menu Principal: \n"
					+ "1 - comentar eventos \n"
					+ "2 - logoff \n");		
			Scanner a = new Scanner(System.in);
			n = a.nextInt();
			if (n == 1) {
				System.out.println("escreva o id do evento que voce quer comentar: ");
				int id = a.nextInt();
				eventos.procurarEvento(id).toString();
				paginaComentario(eventos, id);
			} else if (n == 2) {
				telaLogin(professores, alunos, eventos);
			} 
		}
		
	}
	
	public static void paginaComentario(RepositorioEventos eventos, int id) {
		Evento evento = eventos.procurarEvento(id);
		RepositorioComentarios comentarios = evento.getComentarios();
		int m =0;
		while (m != 3) {
			comentarios.toString();
			System.out.println("Menu de Comentario: \n"
					+ "1 - criar comentario \n"
					+ "2 - remover comentario \n"
					+ "3 - voltar \n");
			Scanner a = new Scanner(System.in);
			m = a.nextInt();
			if (m == 1) {
				int idc = evento.getComentarios().size()+1 ;
				System.out.println("insira a comentario: ");
				String texto = a.next();
				Comentario comentario = new Comentario(idc, evento, texto);
				comentarios.addComentario(comentario);
				evento.setComentarios(comentarios);
				
			} else if (m == 2) {
				System.out.println("escreva o id do comentario que quer apagar: ");
				int idc = a.nextInt();
				comentarios.removerComentario(idc);
				evento.setComentarios(comentarios);
				
			} else if (m == 3) {
				System.out.println("voltando");
			}
		}
	}
	
	

}
