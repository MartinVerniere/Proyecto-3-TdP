package Grafica;

import java.util.Timer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Logica.Juego;

public class HiloEntidades extends Thread {
	//Atributos
	private Juego juego;
	private JPanel panel;
	private Timer timer;
	//Constructor
	public HiloEntidades(Juego j, JPanel panel, Timer hiloPuntaje) {
		super();
		this.juego=j;
		this.panel=panel;
		timer=hiloPuntaje;
	}
	//Metodos
	@SuppressWarnings({ "static-access", "deprecation" })
	public void run() {
		while (true) {
			try {
				juego.accionar();
				
				if (juego.gano()) {
					timer.cancel();
					JOptionPane.showMessageDialog(panel, "Usted a ganado");
					this.stop();
				}
				if (juego.perdio()) {
					timer.cancel();
					JOptionPane.showMessageDialog(panel, "Usted a perdido, mala suerte");
					this.stop();
				}
				
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
