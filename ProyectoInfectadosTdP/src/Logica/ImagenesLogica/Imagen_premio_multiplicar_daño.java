package Logica.ImagenesLogica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_premio_multiplicar_da�o extends Imagen{
	//Atributos
	//Constructor
	public Imagen_premio_multiplicar_da�o() {
		imagenes=new String[] {"/Imagenes/pixel-premio-multiplicar-da�o.png"};
		
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		icon=new JLabel(imagen);
		
		icon.setBounds(0,0,imagen.getIconWidth(), imagen.getIconHeight());
	}
	//Metodos
}
