package Logica.Entidades;

import Logica.Juego;
import Logica.Imagenes.Imagen_premio_multiplicar_da�o;
import Logica.Visitors.Visitor;

public class Premio_multiplicar_da�o extends Premio{
	//Atributos
	//Constructor
	public Premio_multiplicar_da�o(Juego j) {
		super(j);
		this.miImagen=new Imagen_premio_multiplicar_da�o();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	
}
