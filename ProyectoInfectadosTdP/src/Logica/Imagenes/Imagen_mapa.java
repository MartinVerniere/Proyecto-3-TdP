package Logica.Imagenes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_mapa extends Imagen {
	//Atributos
	//Constructor
	public Imagen_mapa() {
		super();
		imagenes=new String[] {"/Imagenes/pixel-mapa.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		icon=new JLabel(imagen);
	}
	//Metodos
}
