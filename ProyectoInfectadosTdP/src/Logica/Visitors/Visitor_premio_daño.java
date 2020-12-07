package Logica.Visitors;

import Logica.Entidades.*;
public class Visitor_premio_da�o extends Visitor_premio{
	//Atributos
	//Constructor
	public Visitor_premio_da�o(Premio p) {
		super(p);
	}
	//Metodos

	@Override
	public void visit(Jugador j) { 
		j.setda�o(2*j.getda�o());
		System.out.println("Premio da�o activado");
		this.miPremio.setEstado(false);
	}
}
