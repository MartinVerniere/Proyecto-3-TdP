package Logica.Fabrica_Infectados;

import Logica.Juego;
import Logica.Entidades.*;

public abstract class FabricaInfectado {
	//Atributos
	protected Juego juego;
	//Constructor
	public FabricaInfectado(Juego j) {
		this.juego=j;
	}
	//Metodos
	public Infectado crear() {
		return null;
	}
}
