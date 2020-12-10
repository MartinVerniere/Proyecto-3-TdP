package Logica.Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.Infectado_alpha;
import Logica.Entidades.Infectado_beta;

public class Visitor_congelar extends Visitor {
	
	
	public Visitor_congelar() {}
	
	
	public void visit(Infectado_alpha i) {
		long tini=System.currentTimeMillis();
		int velant=i.getvelocidad();
		i.setvelocidad(0);
		
		Timer timeraux=new Timer();
		TimerTask tarea=new TimerTask() {
			
			public void run() {
				long tactual=System.currentTimeMillis();
				if ((tactual-tini)>=5000) {
					i.setvelocidad(velant);
					this.cancel();
				}
			}
		};
		timeraux.schedule(tarea, 0, 1000);
	}
	
	public void visit(Infectado_beta i) {
		long tini=System.currentTimeMillis();
		int velant=i.getvelocidad();
		i.setvelocidad(0);
		
		Timer timeraux=new Timer();
		TimerTask tarea=new TimerTask() {
			
			public void run() {
				long tactual=System.currentTimeMillis();
				if ((tactual-tini)>=5000) {
					i.setvelocidad(velant);
					this.cancel();
				}
			}
		};
		timeraux.schedule(tarea, 0, 1000);
	}
}
