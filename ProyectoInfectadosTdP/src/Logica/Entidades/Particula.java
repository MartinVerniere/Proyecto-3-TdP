package Logica.Entidades;

import javax.swing.JLabel;

import Logica.Juego;
import Logica.Imagenes.Imagen_particula;
import Logica.Visitors.Visitor;

public class Particula extends Entidad{
	//Atributos
	protected int alcancemaximo;
	protected int distanciarecorrida;
	//Constructor
	public Particula(Juego j) {
		super(j);
		this.velocidad=this.velocidad*2;
		distanciarecorrida=0;
		alcancemaximo=30;
		this.miImagen=new Imagen_particula();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public int dañar() { return 10; }
	public void aumentardistanciarecorrida() {
		distanciarecorrida+=this.velocidad;
	}
	
	public void accionar() {
		JLabel i=this.getImagen().getIcon();
		if (i.getY()-this.velocidad<1) {
			i.setLocation(i.getX(), this.getJuego().getDimension().height);
		}
		else {
			this.miEstado=false;
		}
	}
}
