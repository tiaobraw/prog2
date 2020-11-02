package dados;

import java.util.ArrayList;
import negocio.bean.Evento;

public class RepositorioEventos {

	private ArrayList<Evento> eventos;
	//private int proxima;
	
	public RepositorioEventos() {
		this.eventos = new ArrayList<>();
	//	this.proxima = 0;
	}
	
    public boolean addEvento(Evento evento) {
        boolean resultado = false;
        if (evento != null) {
            int id = evento.getId();
            boolean existeEventoComIdIgual = false;
            for (Evento interna : eventos) {
                if (interna.getId() == id) {
                	existeEventoComIdIgual = true;
                }
            }
            if (!existeEventoComIdIgual) {
                this.eventos.add(evento);
                resultado = true;
            }
        }
        return resultado;
    }
    
    public boolean removerEvento(int id) {
        boolean idExiste = false;
        int i;
        for (i = 0; i < this.eventos.size() && !idExiste; i++) {
            Evento evento = this.eventos.get(i);
            if (evento.getId() == id) {
            	idExiste = true;
            }
        }
        if (idExiste) {
            this.eventos.remove(i-1);
        }
        return idExiste;
    }
    
    public Evento procurarEvento(int id) {
    	boolean achou = false;
    	int i = 0;
    	for (i = 0; i < this.eventos.size() && !achou; i++) {
    		Evento evento = this.eventos.get(i);
            if (evento.getId() == id) {
            	achou = true;
            }
    	}
    	if (achou) {
    		Evento evento = this.eventos.get(id);
    		return evento;
    	} else {
    		return null;
    	}
    }
    
    public String toString() {
    	String resultado = "";
        for (Evento evento : this.eventos) {
            resultado = resultado + evento.getId() + "  |  Comentario: "
                			+ "\n";
        }
        return resultado;
    }
    
    public void mostrarEventos() {
    	for(int i = 0 ; i < this.eventos.size() ; i++ ){
    		System.out.println(this.eventos.get(i).toString()); }
    }

	public int size() {
		// TODO Auto-generated method stub
		return this.eventos.size();
	}
	
	public boolean editarEvento(int id, Evento evento) {
		boolean resultado = false;
        if (evento != null) {
            id = evento.getId();
            boolean existeEventoComIdIgual = false;
            for (Evento interna : eventos) {
                if (interna.getId() == id) {
                	existeEventoComIdIgual = true;
                }
            }
            if (existeEventoComIdIgual) {
            	this.eventos.add(evento);
                resultado = true;
            }
        }
        return resultado;
    }
	
}
