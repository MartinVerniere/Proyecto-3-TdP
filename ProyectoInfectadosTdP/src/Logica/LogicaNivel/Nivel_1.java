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
		siguiente=new Nivel_2(juego);
		
		misFabricas=new FabricaInfectado[2];
		misFabricas[0]=new Fabricaalfa(juego);
		misFabricas[1]=new Fabricabeta(juego);
		
		settanda(new Tanda_1(this, 10));
		
	}
	//Metodos
}
