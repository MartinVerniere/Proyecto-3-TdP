package Logica.Imagenes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_premio_multiplicar_daño extends Imagen{
	//Atributos
	//Constructor
	public Imagen_premio_multiplicar_daño() {
		super();
		imagenes=new String[] {"/Imagenes/pixel-premio-multiplicar-daño.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		icon=new JLabel(imagen);
	}
	//Metodos
}
