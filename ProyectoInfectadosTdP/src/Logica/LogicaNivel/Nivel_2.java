package Logica.LogicaNivel;

import Logica.Juego;
import Logica.Fabrica_Infectados.FabricaInfectado;
import Logica.Fabrica_Infectados.Fabricaalfa;
import Logica.Fabrica_Infectados.Fabricabeta;

public class Nivel_2 extends Nivel{
	//Atributos
	//Constructor
	public Nivel_2(Juego j) {
		super(j);
		siguiente = null;		
		
		misFabricas=new FabricaInfectado[2];
		misFabricas[0]=new Fabricaalfa(miJuego);
		misFabricas[1]=new Fabricabeta(miJuego);
		
		settanda(new Tanda_1(this, 10));
		
	}
	//Metodos
}
