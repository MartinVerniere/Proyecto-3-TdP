package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_particula extends Visitor {
	//Atributos
	private Particula p;
	//Constructor
	public Visitor_particula(Entidad e1) {
		this.p=(Particula) e1;
	}
	//Metodos
	@Override
	public void visit(Jugador j) { 
		j.recibirdaño(this.p.dañar()); 
	}
}
