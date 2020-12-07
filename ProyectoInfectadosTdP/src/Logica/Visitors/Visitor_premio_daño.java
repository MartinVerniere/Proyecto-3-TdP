package Logica.Visitors;

import Logica.Entidades.*;
public class Visitor_premio_daño extends Visitor_premio{
	//Atributos
	//Constructor
	public Visitor_premio_daño(Premio p) {
		super(p);
	}
	//Metodos

	@Override
	public void visit(Jugador j) { 
		j.setdaño(2*j.getdaño());
		System.out.println("Premio daño activado");
		this.miPremio.setEstado(false);
	}
}
