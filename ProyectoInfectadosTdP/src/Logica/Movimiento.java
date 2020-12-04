package Logica;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import Logica.Entidades.*;

public class Movimiento {
	public void input(Jugador j, KeyEvent i)  {
		JLabel imagenlabel = j.getImagen().getJLabel();
		
		if (i.getKeyCode()==KeyEvent.VK_RIGHT && permitidoderecha(imagenlabel, j) ) {
			
			int nuevoX=imagenlabel.getX()+j.getvelocidad();
			int nuevoY=imagenlabel.getY();
			
			imagenlabel.setLocation(nuevoX, nuevoY);
		}
		
		if (i.getKeyCode()==KeyEvent.VK_LEFT && permitidoizquierda(imagenlabel, j) ) {
			
			int nuevoX=imagenlabel.getX()-j.getvelocidad();
			int nuevoY=imagenlabel.getY();
			
			imagenlabel.setLocation(nuevoX, nuevoY);
		}
		
		if (i.getKeyCode()==KeyEvent.VK_SPACE) {
			Proyectil p = j.disparar();
			
			int nuevoX=imagenlabel.getX()+imagenlabel.getWidth()/2;
			int nuevoY=imagenlabel.getY()+imagenlabel.getHeight()/2;
			
			p.getImagen().getJLabel().setLocation(nuevoX, nuevoY);
			j.getJuego().añadir(p);
		}
	}
	
	private boolean permitidoderecha(JLabel icono, Jugador j) {
		return (icono.getX()+j.getvelocidad())<j.getJuego().getanchomapa()-j.getancho();
	}
	private boolean permitidoizquierda(JLabel icono, Jugador j) {
		return (icono.getX()-j.getvelocidad())>=0;
	}
	
}