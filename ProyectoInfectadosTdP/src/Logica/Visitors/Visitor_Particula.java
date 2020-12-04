package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_particula implements Visitor {
	//Atributos
	private Particula p;
	//Constructor
	public Visitor_particula(Entidad e1) {
		this.p=(Particula) e1;
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
		j.recibirdaño(this.p.dañar()); 
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
