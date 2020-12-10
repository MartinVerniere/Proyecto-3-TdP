package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_premio_congelar_tiempo extends Visitor_premio{
	//Atributos
	protected Visitor visitor_p;
	//Constructor
	public Visitor_premio_congelar_tiempo(Premio p) {
		super(p);
		visitor_p=new Visitor_congelar();
	}
	//Metodos
	@Override
	public void visit(Jugador j) {
		for( int i=0; i<j.getJuego().getcantentidades();i++) {
			j.getJuego().getlistaentidades()[i].visitar(visitor_p);
		}
		this.miPremio.setEstado(false);
	}
}
