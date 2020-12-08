package Logica;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Grafica.GUI;
import Logica.Entidades.*;
import Logica.Fabrica_Premios.FabricaPremio;
import Logica.Fabrica_Premios.Fabrica_Premio_congelar;
import Logica.Fabrica_Premios.Fabrica_Premio_daño;
import Logica.Fabrica_Premios.Fabrica_Premio_vida;
import Logica.LogicaNivel.Nivel;
import Logica.LogicaNivel.Nivel_1;
import Logica.LogicaNivel.Tanda;

public class Juego {
	//Atributos
	
	protected int cantentidades;
	protected int puntaje;
	protected long tiempo;
	protected GUI miGUI;
	protected Jugador miJugador;
	protected Nivel miNivel;
	protected Movimiento misMovimientos;
	protected FabricaPremio[] misFabricapremio;
	protected Entidad[] misEntidades;	

	//Constructor
	
	public Juego(GUI g) {
		cantentidades=0;
		puntaje=0;
		tiempo=System.currentTimeMillis();
		this.miGUI=g;
		
		misFabricapremio=new FabricaPremio[3];
		misFabricapremio[0]=new Fabrica_Premio_vida(this);
		misFabricapremio[1]=new Fabrica_Premio_congelar(this);
		misFabricapremio[2]=new Fabrica_Premio_daño(this);
		
		miJugador=new Jugador(this);
		miNivel=new Nivel_1(this);
		misMovimientos=new Movimiento();
		
		misEntidades=new Entidad[100];
		
	}
	//Metodos
	
	public void Inicializar() {
		// TODO Auto-generated method stub
		this.añadir(miJugador);
		System.out.println("Cargo tanda inicial");
		this.añadirtanda(this.miNivel.gettanda());
	}

	public void añadirtanda(Tanda tanda) {
		// TODO Auto-generated method stub
		Timer timeraux=new Timer();
		TimerTask tarea=new TimerTask() {
			int cont=0;
			public void run() {
				if (cont<tanda.getcantinfectados()) {
					añadir(tanda.getarreglo()[cont]);
					cont++;
				}
				else {
					this.cancel();
				}
			}
		};
		timeraux.schedule(tarea, 2000, 2000);
	}

	public void input(Jugador e1, KeyEvent i) {
		misMovimientos.input(e1,i);
	}
	
	public void setNivel(Nivel n) { this.miNivel=n; }
	public Nivel getNivel() { return this.miNivel; }
	
	public void setGUI(GUI g) { this.miGUI=g; }
	public GUI getGUI() { return this.miGUI; }
	
	public void setJugador(Jugador j) { this.miJugador=j; }
	public Jugador getJugador() { return  miJugador; }
	
	public Entidad[] getlistaentidades() { return this.misEntidades; }
	
	public void añadir(Entidad e) {
		
		if (cantentidades<this.misEntidades.length) {
			this.misEntidades[cantentidades]=e;
			cantentidades++;
			this.miGUI.agregarlabel(e.getImagen().getJLabel());
		}
	}
	
	public Premio crearpremio(Point p) {
		Random rnd=new Random();
		int i=rnd.nextInt(2);
		Premio aRetornar = this.misFabricapremio[i].crear(p);
		
		return aRetornar;
	}
	
	public void reiniciarTiempo() { tiempo=System.currentTimeMillis(); }
	public String getTiempo() {
		long TiempoPaso = System.currentTimeMillis() - tiempo;
		
		long SegundosPaso = TiempoPaso / 1000;
		long SegundosMostrar = SegundosPaso % 60;
		
		long MinutosPaso= SegundosPaso / 60;
		long MinutosMostrar = MinutosPaso % 60;
		
		long HorasMostrar= MinutosPaso / 60;
		
		String hms=String.format("%02d:%02d:%02d",HorasMostrar,MinutosMostrar,SegundosMostrar);
		return hms;
	}
	
	public int getpuntaje() { return this.puntaje; }
	
	public boolean perdio() {
		for (int i=0; i<this.cantentidades;i++) {
			if (this.misEntidades[i] instanceof Jugador) {
				return false;
			}
			/* 
			 * boolean estado=false;
			 * for (int i=0;i<this.cantentidades;i++){
			 * 	 estado=( estado || this.misEntidades[i].visitar_estado());
			 * }
			 * return estado;
			 */
		}
		return true;
	}
	
	public boolean gano() {	return  (this.miNivel==null); }
	
	public void accionar() {
		mover();
		colision();
		eliminarelementos();
	}

	private void eliminarelementos() {
		for(int i=0; i<cantentidades;i++) {
			Entidad e1 = this.misEntidades[i];
			if (e1!=null && e1.getEstado()==false) {
				this.miGUI.eliminarlabel(e1.getImagen().getJLabel());
				//e1.eliminar();
				e1=null;
				cantentidades--;
			}
		}
		comprimir();
		this.miNivel.eliminarelementos();
		
		
		if (this.miNivel!=null && this.miNivel.gettanda()==null) {
			this.miNivel=this.miNivel.getsiguiente();
			if (this.miNivel!=null) {
				System.out.println("Cargo nivel siguiente");
				this.miGUI.cambiarmapa();
				this.añadirtanda(this.miNivel.gettanda());
			}
		}
	}
	
	private void comprimir() {
		int cont=0;
		int contaux=0;
		boolean termino=false;
		boolean encontro=false;
		for (cont=0; cont<this.misEntidades.length && !termino;cont++) {
			if (this.misEntidades[cont]==null) {
				contaux=cont+1;
				encontro=false;
				while (contaux<this.misEntidades.length && !encontro) {
					if (this.misEntidades[contaux]!=null) {
						this.misEntidades[cont]=this.misEntidades[contaux];
						this.misEntidades[contaux]=null;
						encontro=true;
					}
					contaux++;
				}
				termino=!encontro;
			}
		}
	}
	
	private boolean colision() {
		Entidad e1,e2;
		for (int i=0;i<this.cantentidades;i++) {
			e1=this.misEntidades[i];
			for (int j=0;j<this.cantentidades;j++) {
				if (e1!=this.misEntidades[j]){
					e2=this.misEntidades[j];
					if (e1.getImagen().getJLabel().getBounds().intersects(e2.getImagen().getJLabel().getBounds())) {
						e1.colision(e2);
						e2.colision(e1);
						return true;
					}
				}
			}
		}
		return false;
	}
	private void mover() {
		for (int i=0;i<this.cantentidades;i++) {
			this.misEntidades[i].accionar();
		}
	}
	
	public void addpuntaje(int i) { this.puntaje+=i; }
}
