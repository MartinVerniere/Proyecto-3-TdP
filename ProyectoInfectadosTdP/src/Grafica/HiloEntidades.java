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
	@SuppressWarnings({ "static-access" })
	public void run() {
		while (true) {
			try {
				juego.accionar();
				
				if (juego.gano()) { cerrar(panel,"Usted a ganado", timer); }
				if (juego.perdio()) { cerrar(panel, "Usted a perdido, mala suerte", timer);	}
				
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@SuppressWarnings("deprecation")
	private void cerrar(JPanel panel2, String mensaje, Timer t) {
		// TODO Auto-generated method stub
		t.cancel();
		JOptionPane.showMessageDialog(panel, mensaje);
		this.stop();
	}
}
