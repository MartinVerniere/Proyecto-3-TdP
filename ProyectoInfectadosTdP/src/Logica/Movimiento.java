package Logica;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import Logica.Entidades.*;

public class Movimiento {
	public void input(Jugador j, KeyEvent i)  {
		JLabel imagenlabel = j.getImagen().getJLabel();
		
		if (i.getKeyCode()==KeyEvent.VK_RIGHT ) {
			
			int nuevoX=imagenlabel.getX()+j.getvelocidad();
			int nuevoY=imagenlabel.getY();
			
			j.getImagen().mover(nuevoX,nuevoY,j.getJuego().getGUI());
		}
		
		if (i.getKeyCode()==KeyEvent.VK_LEFT ) {
			
			int nuevoX=imagenlabel.getX()-j.getvelocidad();
			int nuevoY=imagenlabel.getY();
			
			j.getImagen().mover(nuevoX,nuevoY,j.getJuego().getGUI());
		}
		
		if (i.getKeyCode()==KeyEvent.VK_SPACE) {
			Proyectil p = j.disparar();
			
			int nuevoX=imagenlabel.getX()+imagenlabel.getWidth()/2;
			int nuevoY=imagenlabel.getY()-p.getalto();
			
			p.getImagen().setPos(nuevoX, nuevoY);
			j.getJuego().añadir(p);
		}
	}
	
}