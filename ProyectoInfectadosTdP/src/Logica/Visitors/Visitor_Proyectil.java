package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_proyectil implements Visitor{
	//Atributos
	private Proyectil p;
	//Constructor
	public Visitor_proyectil(Entidad e1) {
		this.p=(Proyectil) e1;
	}
	//Metodos
	@Override
	public void visit(Infectado_alpha i) { 
		i.recibirda�o(this.p.da�ar());
		this.p.setEstado(false);
	}
	@Override
	public void visit(Infectado_beta i) {
		i.recibirda�o(this.p.da�ar());
		this.p.setEstado(false);
	}
	@Override
	public void visit(Jugador j) {
		// TODO Auto-generated method stub
		
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
