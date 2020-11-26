package Logica.Imagenes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_infectado_alpha extends Imagen{
	//Atributos
	//Constructor
	public Imagen_infectado_alpha() {
		super();
		imagenes=new String[] {"/Imagenes/pixel-infectado-alpha.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		icon=new JLabel(imagen);
	}
	//Metodos

}
