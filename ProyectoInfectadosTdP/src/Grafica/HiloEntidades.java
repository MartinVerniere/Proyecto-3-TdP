package Grafica;

import Logica.Juego;

public class HiloEntidades extends Thread {
	//Atributos
	private Juego juego;
	//Constructor
	public HiloEntidades(Juego j) {
		this.juego=j;
	}
	//Metodos
	public void run() {
		juego.accionar();
	}

}
