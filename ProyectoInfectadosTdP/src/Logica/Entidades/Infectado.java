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
	public int da�ar() {
		return 10;
	}
	public Particula desprenderparticula() {
		Random rnd=new Random();
		int i=rnd.nextInt(9);
		if (i==1) {
			Particula p=new Particula(miJuego);
			p.miImagen.getIcon().setLocation(this.miImagen.getIcon().getLocation());
			return p;
		}
		else {
			return null;
		}
	}
	public Premio soltarpremio(Point p) {
		Random rnd=new Random();
		int i=rnd.nextInt(19);
		if (i==1) {
			return this.miJuego.crearpremio(p);
		}
		else {
			return null;
		}
	}
	public void recibirda�o(int da�o) {
		this.cargaviral=-da�o;
		if (this.cargaviral<1) {
			this.miEstado=false;
			Premio pre=this.soltarpremio(this.miImagen.getIcon().getLocation());
			if (pre!=null) {;
				this.miJuego.a�adir(pre);
			}
		}
	}
	public void accionar() {
		JLabel i=this.getImagen().getIcon();
		if (i.getY()-this.velocidad<1) {
			i.setLocation(i.getX(), this.getJuego().getDimension().height);
		}
		else {
			i.setLocation(i.getX(), i.getY()-this.velocidad);
		}
		Particula par=desprenderparticula();
		if (par!=null) {
			this.miJuego.a�adir(par);
		}
	}
}
