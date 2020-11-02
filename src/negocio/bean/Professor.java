package negocio.bean;

public class Professor extends Pessoa {
	
	public Professor() {
		
	}

	public Professor(String nome, String matricula, String senha) {
		super(nome, matricula, senha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + ", Matricula: " + getMatricula() + "]";
	}

}
