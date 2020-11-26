
package Logica.Entidades;

import Logica.Juego;
import Logica.Imagenes.Imagen_premio_vida;
import Logica.Visitors.Visitor;

public class Premio_vida extends Premio {
	//Atributos
	//Constructor
	public Premio_vida(Juego j) {
		super(j);
		this.miImagen=new Imagen_premio_vida();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
}
