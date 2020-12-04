package Logica.Entidades;

import Logica.Juego;
import Logica.ImagenesLogica.Imagen_premio_congelar_infectados;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_premio_congelar_tiempo;

public class Premio_congelar_tiempo extends Premio{
	//Atributos
	//Constructor
	public Premio_congelar_tiempo(Juego j) {
		super(j);
		this.miVisitor=new Visitor_premio_congelar_tiempo(this);
		this.miImagen=new Imagen_premio_congelar_infectados();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
}
