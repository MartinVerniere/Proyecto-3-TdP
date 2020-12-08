package Logica.Visitors;

import Logica.Entidades.*;

public abstract class Visitor {
	//Metodos
	public void visit(Infectado_alpha i) {}
	public void visit(Infectado_beta i) {}
	public void visit(Jugador j) {}
	public void visit(Premio p) {}
	public void visit(Proyectil p) {}
	public void visit(Particula p) {}
	//CONGELAR
	/*
	public void visit_congelar() {}
	public boolean visit_estado() { return false; }
	*/
}
