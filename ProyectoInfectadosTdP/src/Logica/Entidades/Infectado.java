package Logica.Entidades;

import java.awt.Point;
import java.util.Random;

import javax.swing.JLabel;

import Logica.Juego;

public abstract class Infectado extends Persona {
	//Atributos
	//Constructor
	public Infectado(Juego j) {
		super(j);
	}
	//Metodos
	public int dañar() {
		return 10;
	}
	
	public void recibirdaño(int daño) {
		this.cargaviral=-daño;
		if (this.cargaviral<1) {
			this.miEstado=false;
			this.getJuego().addpuntaje(10);
			Premio pre=this.soltarpremio(this.miImagen.getJLabel().getLocation());
			if (pre!=null) {;
				this.miJuego.añadir(pre);
			}
		}
	}
	
	public void accionar() {
		JLabel i=this.miImagen.getJLabel();
		
		if (i.getY()+this.velocidad>this.miJuego.getGUI().getaltomapa()) {
			
			int nuevoX=i.getX();
			int nuevoY=0;
			
			this.miImagen.setPos(nuevoX,nuevoY);
			
		}
		else {
			int nuevoX=i.getX();
			int nuevoY=i.getY()+this.velocidad;
			
			this.miImagen.mover(nuevoX,nuevoY, this.miJuego.getGUI());
		}
		Particula par=desprenderparticula();
		if (par!=null) {
			this.miJuego.añadir(par);
		}
	}
	
	private Premio soltarpremio(Point p) {
		Random rnd=new Random();
		int i=rnd.nextInt(19);
		if (i==1) {
			return this.miJuego.crearpremio(p);
		}
		else {
			return null;
		}
	}
	
	private Particula desprenderparticula() {
		Random rnd=new Random();
		int i=rnd.nextInt(25);
		if (i==1) {
			Particula p=new Particula(miJuego);
			p.miImagen.getJLabel().setLocation(this.miImagen.getJLabel().getLocation());
			return p;
		}
		else {
			return null;
		}
	}
}
