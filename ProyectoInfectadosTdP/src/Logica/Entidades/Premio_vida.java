
package Logica.Entidades;

import Logica.Juego;
import Logica.ImagenesLogica.Imagen_premio_vida;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_premio_vida;

public class Premio_vida extends Premio {
	//Atributos
	//Constructor
	public Premio_vida(Juego j) {
		super(j);
		this.miVisitor=new Visitor_premio_vida(this);
		this.miImagen=new Imagen_premio_vida();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
}
