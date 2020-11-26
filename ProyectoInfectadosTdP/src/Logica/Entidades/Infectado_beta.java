package Logica.Entidades;

import Logica.Juego;
import Logica.Imagenes.Imagen_infectado_beta;
import Logica.Visitors.Visitor;

public class Infectado_beta extends Infectado {
	//Atributos
	//Constructor
	public Infectado_beta(Juego j) {
		super(j);
		this.miImagen=new Imagen_infectado_beta();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public void recibirda�o(int da�o) {
		super.recibirda�o(da�o/2);
	}
}
