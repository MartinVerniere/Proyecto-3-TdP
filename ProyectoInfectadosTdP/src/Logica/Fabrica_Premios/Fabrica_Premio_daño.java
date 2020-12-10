package Logica.Fabrica_Premios;

import java.awt.Point;

import Logica.Juego;
import Logica.Entidades.*;
public class Fabrica_Premio_da�o extends FabricaPremio {
	//Atributos
	//Constructor
	public Fabrica_Premio_da�o(Juego j) {
		super(j);
	}
	//Metodos
	public Premio crear(Point punto) { 
		Premio p= new Premio_multiplicar_da�o(this.miJuego); 
		int nuevaX=(int) punto.getX();
		int nuevaY=(int) punto.getY();
		p.getImagen().setPos(nuevaX, nuevaY);
		return p;
	}
}
