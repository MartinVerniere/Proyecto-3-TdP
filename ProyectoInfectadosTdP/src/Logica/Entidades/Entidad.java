package Logica.Entidades;

import java.awt.Dimension;

import Logica.Juego;
import Logica.Imagenes.*;
import Logica.Visitors.Visitor;

public abstract class Entidad {
	//Atributos
	protected int velocidad;
	protected Juego miJuego;
	protected Imagen miImagen;
	protected Visitor miVisitor;
	protected boolean miEstado;
	//Constructor
	public Entidad(Juego j){
		this.miEstado=true;
		this.miJuego=j;
		this.velocidad=5;
	}
	//Metodos
	public void colision(Entidad e1) {}
	
	public boolean getEstado() { return this.miEstado; }
	public void setEstado(boolean estado) { this.miEstado=estado; }
	
	public void setImagen(Imagen i) { this.miImagen=i; }
	public Imagen getImagen() { return this.miImagen; }
	public Juego getJuego() { return this.miJuego; }
	public Visitor getVisitor() { return this.miVisitor; }
	
	public int getvelocidad() { return this.velocidad; }
	public void setvelocidad(int i) { this.velocidad=i; }
	
	public Dimension gettamaño() { return this.miImagen.getIcon().getSize(); }
	public void accionar() {}
}
