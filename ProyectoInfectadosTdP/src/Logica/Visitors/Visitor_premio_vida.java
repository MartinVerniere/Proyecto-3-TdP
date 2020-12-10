package Logica.Visitors;

import Logica.Entidades.*;
public class Visitor_premio_vida extends Visitor_premio {
	//Atributos
	//Constructor
	public Visitor_premio_vida(Premio p) {
		super(p);
	}
	//Metodos
	
	@Override
	public void visit(Jugador j) {
		j.setcargaviral(0);
		this.miPremio.setEstado(false);
	}
}
