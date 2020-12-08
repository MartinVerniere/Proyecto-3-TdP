package Logica.Entidades;

import Logica.Juego;
import Logica.LogicaImagenes.Imagen_premio_multiplicar_daño;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_premio_daño;

public class Premio_multiplicar_daño extends Premio{
	//Atributos
	//Constructor
	public Premio_multiplicar_daño(Juego j) {
		super(j);
		this.miVisitor=new Visitor_premio_daño(this);
		this.miImagen=new Imagen_premio_multiplicar_daño();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	
}
