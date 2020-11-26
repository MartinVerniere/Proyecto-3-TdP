package Logica;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import Logica.Entidades.*;

public class Movimiento {
	public void input(Jugador j, KeyEvent i)  {
		JLabel Icono = j.getImagen().getIcon();
		if (i.getKeyCode()==KeyEvent.VK_RIGHT) {
			Icono.setLocation(Icono.getX()+j.getvelocidad(), Icono.getY());;
		}
		if (i.getKeyCode()==KeyEvent.VK_LEFT) {
			Icono.setLocation(Icono.getX()-j.getvelocidad(), Icono.getY());;
		}
		if (i.getKeyCode()==KeyEvent.VK_SPACE) {
			Proyectil p = j.disparar();
			p.getImagen().getIcon().setLocation(Icono.getLocation());
			j.getJuego().añadir(p);
		}
	}
}