package Grafica;

import java.awt.event.KeyEvent;

import Logica.Juego;

public class HiloTeclado extends Thread {
	private Juego juego;
	
	public HiloTeclado(Juego j) {
		this.juego=j;
	}
	
	public void Keypressed(KeyEvent k) {
		this.juego.input(this.juego.getJugador(), k);
	}

}
