package Logica.LogicaNivel;

import Logica.Juego;
import Logica.Fabrica_Infectados.FabricaInfectado;
import Logica.Fabrica_Infectados.Fabricaalfa;
import Logica.Fabrica_Infectados.Fabricabeta;

public class Nivel_1 extends Nivel {
	//Atributos
	
	//Constructor
	
	public Nivel_1(Juego j) {
		super(j);
		siguiente=new Nivel_2(miJuego);
		
		misFabricas=new FabricaInfectado[2];
		misFabricas[0]=new Fabricaalfa(miJuego);
		misFabricas[1]=new Fabricabeta(miJuego);
		
		settanda(new Tanda_1(this, 10));
		
	}
	//Metodos
}
