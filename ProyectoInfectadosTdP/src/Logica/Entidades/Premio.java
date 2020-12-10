package Logica.Entidades;

import javax.swing.JLabel;

import Logica.Juego;

public abstract class Premio extends Entidad {
	//Atributos
	//Constructor
	public Premio(Juego j) {
		super(j);
	}
	//Metodos
	public void accionar(){
		JLabel i=this.getImagen().getJLabel();
		
		if (i.getY()+this.velocidad>this.miJuego.getGUI().getaltomapa()) {
			this.miEstado=false;
		}
		else {
			
			int nuevoX=i.getX();
			int nuevoY=i.getY()+this.velocidad;
			
			this.miImagen.mover(nuevoX, nuevoY,this.miJuego.getGUI());
		}
	}
}
