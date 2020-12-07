package Logica.ImagenesLogica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_infectado_beta extends Imagen {
	//Atributos
	//Constructor
	public Imagen_infectado_beta() {
		imagenes=new String[] {"/Imagenes/pixel-infectado-beta.png"};
		
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		miJLabel=new JLabel(imagen);
		
		miJLabel.setBounds(0,0,imagen.getIconWidth(), imagen.getIconHeight());
		
	}
	//Metodos
}
