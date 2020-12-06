package Logica.Fabrica_Infectados;

import Logica.Juego;
import Logica.Entidades.*;

public class Fabricaalfa extends FabricaInfectado {
	//Atributos
	//Consructor
	public Fabricaalfa(Juego j) {
		super(j);
	}
	//Metodos
	public Infectado crear() { 
		Infectado inf=new Infectado_alpha(juego);
		setpos(inf);
		
		return inf;
	}
}
