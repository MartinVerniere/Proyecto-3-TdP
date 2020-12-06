package Logica.Entidades;

import javax.swing.JLabel;

import Logica.Juego;
import Logica.ImagenesLogica.Imagen_proyectil;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_proyectil;

public class Proyectil extends Entidad {
	//Atributos
	protected int da�o;
	//Constructor
	public Proyectil(Juego j, int da�o) {
		super(j);
		this.da�o=da�o;
		this.miVisitor=new Visitor_proyectil(this);
		this.miImagen=new Imagen_proyectil();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public int da�ar() { return this.da�o; }
	
	public void accionar() {
		JLabel i=this.getImagen().getJLabel();
		
		if (i.getY()-this.velocidad<0) {
			this.miEstado=false;
		}
		else {
			
			//int nuevoX=i.getX();
			int nuevoY=i.getY()-this.velocidad; //Se mueve hacia arriba
			
			//i.setLocation(nuevoX, nuevoY);
			this.getJuego().getGUI().moververtical(i, nuevoY);
		}
	}
}
