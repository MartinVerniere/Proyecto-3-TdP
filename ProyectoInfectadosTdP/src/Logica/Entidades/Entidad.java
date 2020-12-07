package Logica.Entidades;

import Logica.Juego;
import Logica.ImagenesLogica.*;
import Logica.Visitors.Visitor;

public abstract class Entidad {
	//Atributos
	protected int velocidad;
	protected boolean miEstado;
	protected Juego miJuego;
	protected Imagen miImagen;
	protected Visitor miVisitor;
	//Constructor
	public Entidad(Juego j){
		this.miEstado=true;
		this.miJuego=j;
		this.velocidad=50;
	}
	//Metodos
	public void colision(Entidad e1) {
		e1.visitar(this.miVisitor);
	}
	public void visitar(Visitor v1) {}
	
	public boolean getEstado() { return this.miEstado; }
	public void setEstado(boolean estado) { this.miEstado=estado; }
	
	public void setImagen(Imagen i) { this.miImagen=i; }
	public Imagen getImagen() { return this.miImagen; }
	
	public Juego getJuego() { return this.miJuego; }
	public Visitor getVisitor() { return this.miVisitor; }
	
	public int getvelocidad() { return this.velocidad; }
	public void setvelocidad(int i) { this.velocidad=i; }
	
	public int getalto() { return this.miImagen.getJLabel().getHeight(); }
	public int getancho() { return this.miImagen.getJLabel().getWidth(); }
	
	public void accionar() {}
}
