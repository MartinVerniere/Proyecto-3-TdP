package Logica.Visitors;

import Logica.Entidades.*;

public class Visitor_premio_congelar_tiempo extends Visitor_premio{
	//Atributos
	//Constructor
	public Visitor_premio_congelar_tiempo(Premio p) {
		super(p);
	}
	//Metodos
	@Override
	public void visit(Jugador j) {
		for (Entidad e:j.getJuego().getlistaentidades()) {
			if (e instanceof Infectado) {                                                                                            //MAL
				e.setvelocidad(0);
			}
			//e.visitar_congelar();
		}
		System.out.println("Premio congelar activado");
		this.miPremio.setEstado(false);
	}
}
