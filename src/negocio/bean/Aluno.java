package negocio.bean;

public class Aluno extends Pessoa  {
	
	public Aluno() {
		
	}

	public Aluno(String nome, String matricula, String senha) {
		super(nome, matricula, senha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Aluno [Nome: " + getNome() + ", Matricula: " + getMatricula()+"]";
	}

}
