package Logica.LogicaImagenes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_proyectil extends Imagen {
	//Atributos
	//Constructor
	public Imagen_proyectil() {
		imagenes=new String[] {"/Imagenes/pixel-proyectil.png"};
		
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		miJLabel=new JLabel(imagen);
		
		miJLabel.setBounds(0,0,imagen.getIconWidth(), imagen.getIconHeight());
	}
	//Metodos
}
