package Logica.Entidades;

import Logica.Juego;

public abstract class Persona extends Entidad {
	//Atributos
	protected int cargaviral;
	protected int cargaviraltotal;
	//Constructor
	public Persona(Juego j) {
		super(j);
		cargaviral=100;
		cargaviraltotal=100;
	}
	//Metodos
	public int getcargaviral() { return this.cargaviral; }
	public void setcargaviral(int i) { this.cargaviral=i; }
}
