package Logica.Entidades;

import Logica.Juego;
import Logica.LogicaImagenes.Imagen_jugador;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_jugador;

public class Jugador extends Persona{
	//Atributos
	
	protected int da�o;
	//Constructor
	
	public Jugador(Juego j) {
		super(j);
		da�o=50;
		cargaviral=0;
		this.miVisitor=new Visitor_jugador(this);
		this.miImagen=new Imagen_jugador();
		
		int nuevaX=(this.miJuego.getGUI().getanchomapa()-this.getancho())/2;
		int nuevaY=this.getJuego().getGUI().getaltomapa()-this.getalto();
		
		this.miImagen.getJLabel().setLocation(nuevaX, nuevaY);
	}
	//Metodos
	
	public int getda�o() { return this.da�o; }
	public void setda�o(int da�o) { this.da�o=da�o; }
	
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public Proyectil disparar() {
		Proyectil p=new Proyectil(miJuego,da�o);
		return p;
	}
	public void recibirda�o(int da�o) {
		this.cargaviral+=da�o;
		System.out.println("CargaViral: "+this.cargaviral);
		if (this.cargaviral>99) {
			this.miEstado=false;
			System.out.println("Jugador murio");
		}
	}
}