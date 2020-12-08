package Logica.Entidades;

import Logica.Juego;
import Logica.LogicaImagenes.Imagen_infectado_beta;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_infectado_beta;

public class Infectado_beta extends Infectado {
	//Atributos
	//Constructor
	public Infectado_beta(Juego j) {
		super(j);
		this.miVisitor=new Visitor_infectado_beta(this);
		this.miImagen=new Imagen_infectado_beta();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public void recibirdaño(int daño) {
		super.recibirdaño(daño/2);
	}
}
