package Logica.Entidades;

import Logica.Juego;
import Logica.Imagenes.Imagen_jugador;
import Logica.Visitors.Visitor;

public class Jugador extends Persona{
	//Atributos
	protected int da�o;
	//Constructor
	public Jugador(Juego j) {
		super(j);
		da�o=50;
		this.miImagen=new Imagen_jugador();
	}
	//Metodos
	public int getda�o() { return this.da�o; }
	public void setda�o(int da�o) { this.da�o=da�o; }
	
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public Proyectil disparar() {
		return new Proyectil(miJuego, da�o);
	}
	public void recibirda�o(int da�o) {
		this.cargaviral=-da�o;
		if (this.cargaviral<1) {
			this.miEstado=false;
		}
	}
}