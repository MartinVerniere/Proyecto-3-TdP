package Logica.Entidades;

import javax.swing.JLabel;

import Logica.Juego;
import Logica.Imagenes.Imagen_proyectil;
import Logica.Visitors.Visitor;

public class Proyectil extends Entidad {
	//Atributos
	protected int daño;
	//Constructor
	public Proyectil(Juego j, int daño) {
		super(j);
		this.daño=daño;
		this.miImagen=new Imagen_proyectil();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public int dañar() { return this.daño; }
	
	public void accionar() {
		JLabel i=this.getImagen().getIcon();
		if (i.getY()+this.velocidad>this.getJuego().getDimension().height) {
			this.miEstado=false;
		}
		else {
			i.setLocation(i.getX(), i.getY()+this.velocidad);
		}
	}
}
