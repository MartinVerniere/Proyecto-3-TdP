package Logica.LogicaImagenes;

import javax.swing.JLabel;

import Grafica.GUI;

public abstract class Imagen {
	//Atributos
	protected JLabel miJLabel;
	protected String[] imagenes;
	//Constructor
	public Imagen() {}
	//Metodos
	public void setJLabel(JLabel i) { this.miJLabel=i; }
	public JLabel getJLabel() { return this.miJLabel; }
	
	public void setPos(int nuevoX, int nuevoY) {
		// TODO Auto-generated method stub
		this.miJLabel.setLocation(nuevoX, nuevoY);
	}
	
	public void mover(int nuevoX, int nuevoY, GUI g) {
		if (this.miJLabel.getX()<nuevoX) { moverderecha(nuevoX,g); }
		else { 
			if (this.miJLabel.getX()>nuevoX) { moverizquierda(nuevoX,g); }
		}
		
		if (this.miJLabel.getY()<nuevoY) { moverabajo(nuevoY,g); }
		else { 
			if (this.miJLabel.getY()>nuevoY) { moverarriba(nuevoY,g); }
		}
	}
	
	private void moverderecha(int desX,GUI g) {
		// TODO Auto-generated method stub
		int i=this.miJLabel.getX();
		while (i<desX && i<g.getanchomapa()-this.miJLabel.getWidth()) {
			i++;
			this.miJLabel.setLocation(i, this.miJLabel.getY());
			g.repaint();
		}
	}
	private void moverizquierda(int desX,GUI g) {
		// TODO Auto-generated method stub
		int i=this.miJLabel.getX();
		while (i>desX && i>0) {
			i--;
			this.miJLabel.setLocation(i, this.miJLabel.getY());
			g.repaint();
		}
	}
	
	private void moverabajo(int desY,GUI g) {
		// TODO Auto-generated method stub
		int i=this.miJLabel.getY();
		while (i<desY && i<g.getaltomapa()) {
			i++;
			this.miJLabel.setLocation(this.miJLabel.getX(), i);
			g.repaint();
		}
	}
	private void moverarriba(int desY,GUI g) {
		// TODO Auto-generated method stub
		int i=this.miJLabel.getY();
		while (i>desY && i>0) {
			i--;
			this.miJLabel.setLocation(this.miJLabel.getX(), i);
			g.repaint();
		}
	}
	
}
