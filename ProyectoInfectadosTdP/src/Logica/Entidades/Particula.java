package Logica.Entidades;

import javax.swing.JLabel;

import Logica.Juego;
import Logica.LogicaImagenes.Imagen_particula;
import Logica.Visitors.Visitor;
import Logica.Visitors.Visitor_particula;

public class Particula extends Entidad{
	//Atributos
	protected int alcancemaximo;
	protected int distanciarecorrida;
	//Constructor
	public Particula(Juego j) {
		super(j);
		this.velocidad=this.velocidad*2;
		distanciarecorrida=0;
		alcancemaximo=300;
		this.miVisitor=new Visitor_particula(this);
		this.miImagen=new Imagen_particula();
	}
	//Metodos
	public void visitar(Visitor v1) {
		v1.visit(this);
	}
	public int dañar() { return 10; }
	
	public void accionar() {
		JLabel i=this.getImagen().getJLabel();
		
		if (i.getY()+this.velocidad>this.miJuego.getGUI().getaltomapa()) {
			this.miEstado=false;
		}
		else {
			
			int nuevoX=i.getX();
			int nuevoY=i.getY()+this.velocidad;
			
			this.miImagen.mover(nuevoX, nuevoY,this.miJuego.getGUI());
			
			this.distanciarecorrida+=this.velocidad;
			if (this.distanciarecorrida>=this.alcancemaximo) {
				this.miEstado=false;
			}
		}
	}
}
