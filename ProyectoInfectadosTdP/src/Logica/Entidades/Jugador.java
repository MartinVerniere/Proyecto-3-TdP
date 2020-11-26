package Logica.Entidades;

import Logica.Juego;
import Logica.Imagenes.Imagen_jugador;
import Logica.Visitors.Visitor;

public class Jugador extends Persona{
	//Atributos
	protected int daño;
	//Constructor
	public Jugador(Juego j) {
		super(j);
		daño=50;
		this.miImagen=new Imagen_jugador();
	}
	//Metodos
	public int getdaño() { return this.daño; }
	public void setdaño(int daño) { this.daño=daño; }
	
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public Proyectil disparar() {
		return new Proyectil(miJuego, daño);
	}
	public void recibirdaño(int daño) {
		this.cargaviral=-daño;
		if (this.cargaviral<1) {
			this.miEstado=false;
		}
	}
}