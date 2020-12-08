package Logica.Entidades;

import Logica.Juego;
import Logica.LogicaImagenes.*;
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
	//public void visitar_congelar() { this.miVisitor.visit_congelar(); }
	//public boolean visitar_estado() { return this.miVisitor.visit_estado(); }
	
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
	
	/*
	public void eliminar() {
		// TODO Auto-generated method stub
		this.miEstado=false;
		this.miImagen.eliminar();
		this.miImagen=null;
		this.miJuego=null;
		this.miVisitor=null;;
		this.velocidad=0;
	}
	*/
}
