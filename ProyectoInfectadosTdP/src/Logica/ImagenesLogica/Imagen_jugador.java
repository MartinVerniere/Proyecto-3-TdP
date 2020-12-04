package Logica.ImagenesLogica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_jugador extends Imagen {
	//Atributos
	//Constructor
	public Imagen_jugador() {
		imagenes=new String[] {"/Imagenes/pixel-jugador.png"};
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		icon=new JLabel(imagen);
		
		icon.setBounds(0,0,imagen.getIconWidth(), imagen.getIconHeight());
	}
	//Metodos
}
