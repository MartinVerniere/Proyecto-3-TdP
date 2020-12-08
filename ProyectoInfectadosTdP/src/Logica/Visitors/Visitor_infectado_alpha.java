package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_infectado_alpha extends Visitor{
	//Atributos
	private Infectado_alpha ia;
	//Constructor
	public Visitor_infectado_alpha(Entidad e1) {
		this.ia=(Infectado_alpha) e1;
	}
	//Metodos
	@Override
	public void visit(Jugador j) { 
		j.recibirdaño(this.ia.dañar()); 
	}
	//CONGELAR
	/*
	public void visit_congelar() {
		this.ia.setvelocidad(0);
	}
	*/
}
