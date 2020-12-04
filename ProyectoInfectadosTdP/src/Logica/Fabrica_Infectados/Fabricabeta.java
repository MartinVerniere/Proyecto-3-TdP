package Logica.Fabrica_Infectados;

import java.util.Random;

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
		
		Random rnd=new Random();
		int randomx=rnd.nextInt(this.juego.getanchomapa()-inf.getancho());
		inf.getImagen().getJLabel().setLocation(randomx, 0);
		
		return inf;
	}
}
