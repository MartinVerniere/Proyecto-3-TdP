package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_infectado_beta extends Visitor {
	//Atributos
	private Infectado_beta ib;
	//Constructor
	public Visitor_infectado_beta(Entidad e1) {
		this.ib=(Infectado_beta) e1;
	}
	//Metodos
	@Override
	public void visit(Jugador j) { 
		j.recibirdaño(this.ib.dañar()); 
	}
}
