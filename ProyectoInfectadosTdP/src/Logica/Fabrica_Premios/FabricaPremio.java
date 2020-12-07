package Logica.Fabrica_Premios;

import java.awt.Point;

import Logica.Juego;
import Logica.Entidades.Premio;

public abstract class FabricaPremio {
	//Atributos
	protected Juego miJuego;
	//Constructor
	public FabricaPremio(Juego j) {
		this.miJuego=j;
	}
	//Metodos
	public Premio crear(Point p) {
		return null;
	}
}
