package Logica.Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.*;
public class Visitor_premio_daño extends Visitor_premio{
	//Atributos
	//Constructor
	public Visitor_premio_daño(Premio p) {
		super(p);
	}
	//Metodos

	@Override
	public void visit(Jugador j) { 
		int dañoant=j.getdaño();
		long tini=System.currentTimeMillis();
		j.setdaño(2*j.getdaño());
		
		Timer timeraux=new Timer();
		TimerTask tarea=new TimerTask() {
			
			public void run() {
				long tactual=System.currentTimeMillis();
				if ((tactual-tini)>=5000) {
					j.setdaño(dañoant);
					this.cancel();
				}
			}
		};
		timeraux.schedule(tarea, 0, 1000);
		
		this.miPremio.setEstado(false);
	}
}
