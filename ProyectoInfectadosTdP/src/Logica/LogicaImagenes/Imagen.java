package Logica.LogicaImagenes;

import javax.swing.JLabel;

public abstract class Imagen {
	//Atributos
	protected JLabel miJLabel;
	protected String[] imagenes;
	//Constructor
	public Imagen() {}
	//Metodos
	public void setJLabel(JLabel i) { this.miJLabel=i; }
	public JLabel getJLabel() { return this.miJLabel; }
	
	/*
	public void eliminar() {
		// TODO Auto-generated method stub
		this.miJLabel=null;
		this.imagenes=null;
	}
	*/
}
