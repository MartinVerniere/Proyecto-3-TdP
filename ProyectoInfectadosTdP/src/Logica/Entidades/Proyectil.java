package Logica.Entidades;

import javax.swing.JLabel;

import Logica.Juego;
import Logica.Imagenes.Imagen_proyectil;
import Logica.Visitors.Visitor;

public class Proyectil extends Entidad {
	//Atributos
	protected int da�o;
	//Constructor
	public Proyectil(Juego j, int da�o) {
		super(j);
		this.da�o=da�o;
		this.miImagen=new Imagen_proyectil();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public int da�ar() { return this.da�o; }
	
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
