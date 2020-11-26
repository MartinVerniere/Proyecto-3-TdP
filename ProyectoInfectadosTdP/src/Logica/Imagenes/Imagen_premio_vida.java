package Logica.Imagenes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_premio_vida extends Imagen {
	//Atributos
	//Constructor
	public Imagen_premio_vida() {
		super();
		imagenes=new String[] {"/Imagenes/pixel-premio-vida.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		icon=new JLabel(imagen);
	}
	//Metodos
}
