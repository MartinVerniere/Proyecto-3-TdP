package Logica.Fabrica_Infectados;

import java.util.Random;

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
		
		Random rnd=new Random();
		int randomx=rnd.nextInt(this.juego.getanchomapa()-inf.getancho());
		inf.getImagen().getJLabel().setLocation(randomx, 0);
		
		return inf;
	}
}
