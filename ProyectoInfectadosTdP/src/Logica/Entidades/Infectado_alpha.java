package Logica.Entidades;

import Logica.Juego;
import Logica.LogicaImagenes.Imagen_infectado_alpha;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_infectado_alpha;

public class Infectado_alpha extends Infectado {
	//Atributos
	//Constructor
	public Infectado_alpha(Juego j) {
		super(j);
		this.miVisitor=new Visitor_infectado_alpha(this);
		this.miImagen=new Imagen_infectado_alpha();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public void recibirdaño(int daño) {
		super.recibirdaño(daño);
		if (this.cargaviral*100/this.cargaviraltotal<20) {
			this.velocidad=this.velocidad*2;
		}
	}

}
