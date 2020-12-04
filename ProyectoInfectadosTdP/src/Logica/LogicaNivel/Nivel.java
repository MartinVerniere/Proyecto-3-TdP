package Logica.LogicaNivel;

import Logica.Juego;
import Logica.Fabrica_Infectados.FabricaInfectado;

public abstract class Nivel {
	//Atributos
	
	protected Tanda miTanda;
	protected Juego juego;
	protected Nivel siguiente;
	protected FabricaInfectado[] misFabricas;
	//Constructor
	
	public Nivel(Juego j) {
		this.juego=j;
	}
	//Metodos

	public Nivel getsiguiente() { return siguiente; }
	
	public FabricaInfectado[] getfabricas() { return this.misFabricas; }
	public void setfabricas(FabricaInfectado[] f) { this.misFabricas=f; }

	public Tanda gettanda() { return this.miTanda; }
	public void settanda(Tanda t) { this.miTanda=t; }
	
	public void eliminarelementos() {
		
		this.gettanda().eliminarelementos();
		
		if (this.gettanda()!=null && this.gettanda().isEmpty()) {
			this.settanda(this.gettanda().getsiguiente());
			if (this.gettanda()!=null) {
				System.out.println("Cargo tanda siguiente");
				this.juego.añadirarreglo(this.gettanda().getarreglo());
			}
		}
	}
}
