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
		JLabel i=this.getImagen().getIcon();
		if (i.getY()-this.velocidad<1) {
			i.setLocation(i.getX(), this.getJuego().getDimension().height);
		}
		else {
			this.miEstado=false;
		}
	}
}
