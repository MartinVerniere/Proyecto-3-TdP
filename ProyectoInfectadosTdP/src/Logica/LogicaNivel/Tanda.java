package Logica.LogicaNivel;

import Logica.Entidades.Entidad;
import Logica.Fabrica_Infectados.FabricaInfectado;

public abstract class Tanda {
	//Atributos
	
	protected Nivel miNivel;
	protected int cant;
	protected Entidad[] miArreglo;
	protected Tanda siguiente;
	//Constructor
	
	public Tanda(Nivel nivel, int n) {
		this.miNivel=nivel;
		this.cant=0;
		this.miArreglo=new Entidad[n];
	}
	//Metodos
	
	public boolean isEmpty() { return this.cant==0; }
	
	public int getcantinfectados() { return this.cant; }
	public void setcantinfectados(int cant) { this.cant=cant; }
	
	public void setsiguiente(Tanda t) { this.siguiente=t; }
	public Tanda getsiguiente() { return this.siguiente; }
	
	public void setarreglo(Entidad[] e) { this.miArreglo=e; }
	public Entidad[] getarreglo() {	return this.miArreglo; }
	
	
	public void inicializarelementos(FabricaInfectado[] fabricas, int contfabricas) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.miArreglo.length;i++) {
			this.miArreglo[i]=fabricas[contfabricas].crear();
			this.cant++;
		}
		if (this.siguiente!=null) {
			if (contfabricas+1<fabricas.length) {
				this.siguiente.inicializarelementos(fabricas, contfabricas+1);
			}
			else {
				this.siguiente.inicializarelementos(fabricas, contfabricas);
			}
		}
	}
	public void eliminarelementos() {
		for (Entidad e: this.miArreglo) {
			if (e.getEstado()==false) {
				e=null;
				this.cant--;
			}
		}
		comprimir();
	}
	private void comprimir() {
		int cont=0;
		int contaux=0;
		boolean termino=false;
		boolean encontro=false;
		for (cont=0; cont<this.miArreglo.length && !termino;cont++) {
			if (this.miArreglo[cont]==null) {
				contaux=cont+1;
				encontro=false;
				while (contaux<this.miArreglo.length && !encontro) {
					if (this.miArreglo[contaux]!=null) {
						this.miArreglo[cont]=this.miArreglo[contaux];
						this.miArreglo[contaux]=null;
						encontro=true;
					}
					contaux++;
				}
				termino=!encontro;
			}
		}
	}
}
