package Logica.Imagenes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_proyectil extends Imagen{
	//Atributos
	//Constructor
	public Imagen_proyectil() {
		super();
		imagenes=new String[] {"/Imagenes/pixel-proyectil.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		icon=new JLabel(imagen);
	}
	//Metodos
}
