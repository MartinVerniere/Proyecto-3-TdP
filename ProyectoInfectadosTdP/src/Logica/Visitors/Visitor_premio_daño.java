package Logica.Visitors;

import Logica.Entidades.*;
public class Visitor_premio_da�o implements Visitor_premio{
	//Atributos
	protected Premio premio;
	//Constructor
	public Visitor_premio_da�o(Premio p) {
		this.premio=p;
	}
	//Metodos

	@Override
	public void visit(Infectado_alpha i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Infectado_beta i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Jugador j) { 
		j.setda�o(2*j.getda�o());
		this.premio.setEstado(false);
	}

	@Override
	public void visit(Premio p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Proyectil p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Particula p) {
		// TODO Auto-generated method stub
		
	}

}
