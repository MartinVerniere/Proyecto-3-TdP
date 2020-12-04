package Logica.LogicaNivel;

public class Tanda_1 extends Tanda {
	//Atributos
	//Consutrctor
	public Tanda_1(Nivel nivel, int n) {
		super(nivel,n);
		this.siguiente=new Tanda_2(nivel,n);
		
		inicializarelementos(nivel.getfabricas(),0);
	}
	//Metodos
}
