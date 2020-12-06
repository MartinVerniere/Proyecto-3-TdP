package Logica;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import Logica.Entidades.*;

public class Movimiento {
	public void input(Jugador j, KeyEvent i)  {
		JLabel imagenlabel = j.getImagen().getJLabel();
		
		if (i.getKeyCode()==KeyEvent.VK_RIGHT && permitidoderecha(imagenlabel, j) ) {
			
			int nuevoX=imagenlabel.getX()+j.getvelocidad();
			//int nuevoY=imagenlabel.getY();
			
			//imagenlabel.setLocation(nuevoX, nuevoY);
			
			j.getJuego().getGUI().moverhorizontal(imagenlabel, nuevoX);
		}
		
		if (i.getKeyCode()==KeyEvent.VK_LEFT && permitidoizquierda(imagenlabel, j) ) {
			
			int nuevoX=imagenlabel.getX()-j.getvelocidad();
			//int nuevoY=imagenlabel.getY();
			
			//imagenlabel.setLocation(nuevoX, nuevoY);
			
			j.getJuego().getGUI().moverhorizontal(imagenlabel, nuevoX);
		}
		
		if (i.getKeyCode()==KeyEvent.VK_SPACE) {
			Proyectil p = j.disparar();
			
			int nuevoX=imagenlabel.getX()+imagenlabel.getWidth()/2;
			int nuevoY=imagenlabel.getY()-p.getalto();
			
			p.getImagen().getJLabel().setLocation(nuevoX, nuevoY);
			j.getJuego().añadir(p);
		}
	}
	//Si moviendose a la derecha su imagen se desborda del mapa por al menos un pixel, retorna falso;
	private boolean permitidoderecha(JLabel icono, Jugador j) { 
		return (icono.getX()+j.getvelocidad())<j.getJuego().getanchomapa()-j.getancho();
	}
	//Si moviendose a la izquierda su imagen se desborda del mapa por al menos un pixel, retorna falso;
	private boolean permitidoizquierda(JLabel icono, Jugador j) {
		return (icono.getX()-j.getvelocidad())>=0;
	}
	
}