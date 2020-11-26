package Logica;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Random;

import Logica.Entidades.*;
import Logica.Fabrica_Premios.FabricaPremio;
import Logica.Fabrica_Premios.Fabrica_Premio_congelar;
import Logica.Fabrica_Premios.Fabrica_Premio_daño;
import Logica.Fabrica_Premios.Fabrica_Premio_vida;
import Logica.Imagenes.Imagen;
import Logica.Imagenes.Imagen_mapa;

public class Juego {
	//Atributos
	protected int cantentidades;
	protected int puntaje;
	protected long tiempo;
	protected Jugador miJugador;
	protected Imagen miMapa;
	protected Nivel miNivel;
	protected Movimiento misMovimientos;
	protected Dimension dimension;
	protected FabricaPremio[] misFabricapremio;
	protected Entidad[] misEntidades;	

	//Constructor
	public Juego() {
		cantentidades=0;
		puntaje=0;
		tiempo=System.currentTimeMillis();
		dimension=new Dimension(400,500);
		miMapa=new Imagen_mapa();
		
		miJugador=new Jugador(this);
		miJugador.getImagen().getIcon().setLocation(this.miMapa.getIcon().getWidth()/2,this.miMapa.getIcon().getHeight()/2);
		
		misFabricapremio=new FabricaPremio[3];
		misFabricapremio[0]=new Fabrica_Premio_vida(this);
		misFabricapremio[1]=new Fabrica_Premio_congelar(this);
		misFabricapremio[2]=new Fabrica_Premio_daño(this);
		
		miNivel=new Nivel_1(this);
		
		misMovimientos=new Movimiento();
		
		misEntidades=new Entidad[100];
		this.añadir(miJugador);
	}
	//Metodos
	public void input(Jugador e1, KeyEvent i) {
		misMovimientos.input(e1,i);
	}
	
	public Imagen getMapa() { return this.miMapa; }
	public void setMapa(Imagen m) { this.miMapa=m; }
	
	public Nivel getNivel() { return this.miNivel; }
	public Entidad[][] getinfectados() { return this.miNivel.getmisinfectados(); }
	
	public Dimension getDimension() { return this.dimension; }
	public void setDimension(Dimension d) { this.dimension=d; }
	
	public Jugador getJugador() {
		return  miJugador;
	}
	
	public void añadir(Entidad e) {
		if (cantentidades<this.misEntidades.length) {
			this.misEntidades[cantentidades]=e;
			cantentidades++;
		}
	}
	
	public void eliminar(Entidad e) {
		int cont=0;
		boolean encontre=false;
		while (!encontre) {
			if (this.misEntidades[cont]!=null && this.misEntidades[cont]==e) {
				encontre=true;
				this.misEntidades[cont].setEstado(false);
				this.misEntidades[cont]=null;
				cantentidades--;
			}
		}
	}
	
	public Entidad[] getlistaentidades() { 
		return this.misEntidades;
	}
	
	public Premio crearpremio(Point p) {
		Random rnd=new Random();
		int i=rnd.nextInt(2);
		Premio aRetornar = this.misFabricapremio[i].crear(p);
		this.misEntidades[cantentidades++]=aRetornar;
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
		for (Entidad e:this.misEntidades) {
			if (e instanceof Jugador) {
				return false;
			}
		}
		return true;
	}
	/*
	public boolean gano() {
		return (termino nivel actual && this.miNivel.getsiguiente()==null);
	}
	*/
	public void accionar() {
		eliminarelementos();
		colision();
		mover();
	}
	
	private void eliminarelementos() {
		for(int i=0; i<cantentidades;i++) {
			Entidad e1 = this.misEntidades[i];
			if (e1.getEstado()==false) {
				e1=null;
				cantentidades--;
			}
			comprimir();
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
		for (Entidad e1:this.misEntidades) {
			for (Entidad e2:this.misEntidades) {
				if (e1!=e2) {
					if (e1.getImagen().getIcon().getBounds().intersects(e2.getImagen().getIcon().getBounds())) {
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
		for (Entidad e1:this.misEntidades) {
			e1.accionar();
		}
	}
}
