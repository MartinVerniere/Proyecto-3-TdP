package Logica.ImagenesLogica;

import javax.swing.JLabel;

public abstract class Imagen {
	//Atributos
	protected JLabel icon;
	//protected ImageIcon im;
	protected String[] imagenes;
	//Constructor
	public Imagen() {}
	//Metodos
	public void setIcon(JLabel i) { this.icon=i; }
	public JLabel getJLabel() { return this.icon; }
	
	public void mover() {}

	public void actualizar() {}
}
