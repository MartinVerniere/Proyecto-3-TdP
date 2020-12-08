package Logica.LogicaImagenes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen_premio_congelar_infectados extends Imagen {
	//Atributos
	//Constructor
	public Imagen_premio_congelar_infectados() {
		imagenes=new String[] {"/Imagenes/pixel-premio-congelar-infectados.png"};
		
		ImageIcon imagen= new ImageIcon(this.getClass().getResource(imagenes[0]));
		miJLabel=new JLabel(imagen);
		
		miJLabel.setBounds(0,0,imagen.getIconWidth(), imagen.getIconHeight());
	}
	//Metodos
}
