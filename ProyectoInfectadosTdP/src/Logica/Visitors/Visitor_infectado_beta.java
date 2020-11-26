package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_infectado_beta implements Visitor {
	//Atributos
	private Infectado_beta ib;
	//Constructor
	public Visitor_infectado_beta(Entidad e1) {
		this.ib=(Infectado_beta) e1;
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
		j.recibirdaño(this.ib.dañar()); 
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
