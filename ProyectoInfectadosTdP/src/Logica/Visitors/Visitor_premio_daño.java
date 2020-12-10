package Logica.Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.*;
public class Visitor_premio_da�o extends Visitor_premio{
	//Atributos
	//Constructor
	public Visitor_premio_da�o(Premio p) {
		super(p);
	}
	//Metodos

	@Override
	public void visit(Jugador j) { 
		int da�oant=j.getda�o();
		long tini=System.currentTimeMillis();
		j.setda�o(2*j.getda�o());
		
		Timer timeraux=new Timer();
		TimerTask tarea=new TimerTask() {
			
			public void run() {
				long tactual=System.currentTimeMillis();
				if ((tactual-tini)>=5000) {
					j.setda�o(da�oant);
					this.cancel();
				}
			}
		};
		timeraux.schedule(tarea, 0, 1000);
		
		this.miPremio.setEstado(false);
	}
}
