package Logica.Fabrica_Infectados;

import Logica.Juego;
import Logica.Entidades.*;

public class Fabricaalfa extends FabricaInfectado {
	//Atributos
	//Consructor
	public Fabricaalfa(Juego j) {
		super(j);
	}
	//Metodo
	public Infectado crear() { return new Infectado_alpha(juego); }
}
