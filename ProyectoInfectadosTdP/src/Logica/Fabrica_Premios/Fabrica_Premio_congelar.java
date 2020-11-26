package Logica.Fabrica_Premios;

import java.awt.Point;

import Logica.Juego;
import Logica.Entidades.*;

public class Fabrica_Premio_congelar extends FabricaPremio {
	//Atributos
	//Constructor
	public Fabrica_Premio_congelar(Juego j) {
		super(j);
	}
	//Metodos
	public Premio crear(Point punto) { 
		Premio p= new Premio_congelar_tiempo(juego); 
		p.getImagen().getIcon().setLocation(punto);
		return p;
	}
}
