package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_premio_congelar_tiempo implements Visitor_Premio{
	//Atributos
	protected Premio premio;
	//Constructor
	public Visitor_premio_congelar_tiempo(Premio p) {
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
		for (Entidad e:j.getJuego().getlistaentidades()) {
			if (e instanceof Infectado) {
				e.setvelocidad(0);
			}
		}
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
	//Metodos

	@Override
	public void visit(Particula p) {
		// TODO Auto-generated method stub
		
	}

}
