package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_infectado_alpha implements Visitor{
	//Atributos
	private Infectado_alpha ia;
	//Constructor
	public Visitor_infectado_alpha(Entidad e1) {
		this.ia=(Infectado_alpha) e1;
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
		j.recibirdaño(this.ia.dañar()); 
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
