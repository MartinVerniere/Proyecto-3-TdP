package Logica.Fabrica_Infectados;

import Logica.Juego;
import Logica.Entidades.*;

public class Fabricabeta extends FabricaInfectado{
	public Fabricabeta(Juego j) {
		super(j);
	}
	public Infectado crear() { return new Infectado_beta(juego); }
}
