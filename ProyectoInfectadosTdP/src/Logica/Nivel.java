package Logica;

import Logica.Entidades.Entidad;
import Logica.Fabrica_Infectados.FabricaInfectado;

public abstract class Nivel {
	//Atributos
	protected Juego juego;
	protected Nivel siguiente;
	protected int[] cant; // Representa un arreglo de la cantidad de veces que uso la fabrica i para crear() infectados
	protected FabricaInfectado[] misFabricas;
	protected Entidad[][] misInfectados;
	//Constructor
	public Nivel(Juego j) {
		this.juego=j;
	}
	//Metodos
	public Nivel getsiguiente() { return siguiente; }
	public Entidad[][] getmisinfectados() { return this.misInfectados; }
	public void setmisinfectados(Entidad[][] i) { this.misInfectados=i; }
}
