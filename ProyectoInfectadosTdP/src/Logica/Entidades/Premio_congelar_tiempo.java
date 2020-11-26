package Logica.Entidades;

import Logica.Juego;
import Logica.Imagenes.Imagen_premio_congelar_tiempo;
import Logica.Visitors.Visitor;

public class Premio_congelar_tiempo extends Premio{
	//Atributos
	//Constructor
	public Premio_congelar_tiempo(Juego j) {
		super(j);
		this.miImagen=new Imagen_premio_congelar_tiempo();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
}
