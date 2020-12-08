package Logica.Entidades;

import Logica.Juego;
import Logica.LogicaImagenes.Imagen_premio_multiplicar_da�o;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_premio_da�o;

public class Premio_multiplicar_da�o extends Premio{
	//Atributos
	//Constructor
	public Premio_multiplicar_da�o(Juego j) {
		super(j);
		this.miVisitor=new Visitor_premio_da�o(this);
		this.miImagen=new Imagen_premio_multiplicar_da�o();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	
}
