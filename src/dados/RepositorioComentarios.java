package dados;

import java.util.ArrayList;
import negocio.bean.Comentario;

public class RepositorioComentarios {

private ArrayList<Comentario> comentarios;
	
	public RepositorioComentarios() {
		this.comentarios = new ArrayList<>();
	}
	
    public boolean addComentario(Comentario comentario) {
        boolean resultado = false;
        if (comentario != null) {
            int id = comentario.getId();
            boolean existeComentarioComIdIgual = false;
            for (Comentario interna : comentarios) {
                if (interna.getId() == id) {
                	existeComentarioComIdIgual = true;
                }
            }
            if (!existeComentarioComIdIgual) {
                this.comentarios.add(comentario);
                resultado = true;
            }
        }
        return resultado;
    }
    
    public boolean removerComentario(int id) {
        boolean idExiste = false;
        int i;
        for (i = 0; i < this.comentarios.size() && !idExiste; i++) {
            Comentario comentario = this.comentarios.get(i);
            if (comentario.getId() == id) {
            	idExiste = true;
            }
        }
        if (idExiste) {
            this.comentarios.remove(i-1);
        }
        return idExiste;
    }
    
    public Comentario procurarComentarios(int id) {
    	boolean idExiste = false;
        int i;
        for (i = 0; i < this.comentarios.size() && !idExiste; i++) {
            Comentario comentario = this.comentarios.get(i);
            if (comentario.getId() == id) {
            	idExiste = true;
            }
        }
        if (idExiste) {
        	Comentario comentario = this.comentarios.get(id);
        	return comentario;
        } else {
        	return null;
        }
    }
    
    public String toString() { 
        String resultado = "";
        for (Comentario comentario : this.comentarios) {
            resultado = resultado + comentario.getId() + "  |  Comentario: " 
                            + comentario.getComentario() + "\n";
        }
        return resultado;
    }
    public void mostrarEventos() {
    	for(int i=0;i<comentarios.size();i++){
    		System.out.println(comentarios.get(i).toString()); }
    }

	public int size() {
		// TODO Auto-generated method stub
		return this.comentarios.size();
	}
	
}
