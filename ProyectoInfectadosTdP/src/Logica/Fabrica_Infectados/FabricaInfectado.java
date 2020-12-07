package Logica.Fabrica_Infectados;

import java.util.Random;

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
	
	protected void setpos(Infectado inf) {
		Random rnd=new Random();
		int randomx=rnd.nextInt(this.juego.getGUI().getanchomapa()-inf.getancho());
		inf.getImagen().getJLabel().setLocation(randomx, 0);
	}
}
