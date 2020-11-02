package dados;

import java.util.ArrayList;

import negocio.bean.Evento;
import negocio.bean.Pessoa;

public class RepositorioPessoas {

private ArrayList<Pessoa> usuarios;
	
	public RepositorioPessoas () {
		this.usuarios = new ArrayList<>();
	}
	
    public boolean addUsuario(Pessoa usuario) {
        boolean resultado = false;
        if (usuario != null) {
            String Senha = usuario.getSenha();
            boolean existeUsuarioComMatriculaIgual = false;
            for (Pessoa interna : usuarios) {
                if (interna.getSenha().equals(Senha)) {
                	existeUsuarioComMatriculaIgual = true;
                }
            }
            if (!existeUsuarioComMatriculaIgual) {
                this.usuarios.add(usuario);
                resultado = true;
            }
        }
        return resultado;
    }
    
    public boolean removerUsuario(String matricula) {
        boolean matriculaExiste = false;
        int i;
        for (i = 0; i < this.usuarios.size() && !matriculaExiste; i++) {
            Pessoa usuario = this.usuarios.get(i);
            if (usuario.getSenha().equals(matricula)) {
            	matriculaExiste = true;
            }
        }
        if (matriculaExiste) {
            this.usuarios.remove(i-1);
        }
        return matriculaExiste;
    }
    
    public Pessoa procurarUsuario(String matricula) {
    	boolean matriculaExiste = false;
    	int i = 0;
    	 for (i = 0; i < this.usuarios.size() && !matriculaExiste; i++) {
             Pessoa usuario = this.usuarios.get(i);
             if (usuario.getSenha().equals(matricula)) {
             	matriculaExiste = true;
             }
         }
    	if (matriculaExiste) {
    		Pessoa usuario = this.usuarios.get(i);
    		return usuario;
    	} else {
    		return null;
    	}
    	
    }
    
    public Pessoa login (String matricula, String senha) {
    	boolean loginsenha = false;
    	int i = 0;
    	for (i = 0; i < this.usuarios.size() && !loginsenha; i++) {
    		Pessoa usuario = this.usuarios.get(i);
    		if (usuario.getSenha().equals(matricula)) {
    			loginsenha = true;
    		}
    	}
    	if (loginsenha) {
    		Pessoa usuario = this.usuarios.get(i);
    		return usuario;
    	} else {
    		return null;
    	}
    }
    
    public String toString() { 
        String resultado = "";
        for (Pessoa usuario : this.usuarios) {
            resultado = resultado + usuario.getNome() + "  |  Matricula: " 
                            + usuario.getSenha() + "\n";
        }
        return resultado;
    }
   
    public int size() {
		// TODO Auto-generated method stub
		return this.usuarios.size();
	}
}
