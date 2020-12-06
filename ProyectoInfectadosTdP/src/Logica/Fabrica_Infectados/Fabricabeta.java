package Logica.Fabrica_Infectados;

import Logica.Juego;
import Logica.Entidades.*;

public class Fabricabeta extends FabricaInfectado{
	//Atributos
	//Consructor
	public Fabricabeta(Juego j) {
		super(j);
	}
	//Metodos
	public Infectado crear() { 
		Infectado inf=new Infectado_beta(juego);
		setpos(inf);
		
		return inf;
	}
}
