package Logica;

import Logica.Entidades.Entidad;
import Logica.Fabrica_Infectados.FabricaInfectado;
import Logica.Fabrica_Infectados.Fabricaalfa;
import Logica.Fabrica_Infectados.Fabricabeta;

public class Nivel_2 extends Nivel{
	//Atributos
	int total;
	//Constructor
	public Nivel_2(Juego j) {
		super(j);
		siguiente = null;
		
		cant=new int[2];
		cant[0] = 5;
		cant[1] = 15;
		
		misFabricas=new FabricaInfectado[2];
		misFabricas[0]=new Fabricaalfa(juego);
		misFabricas[1]=new Fabricabeta(juego);
		
		misInfectados=new Entidad[2][10];
		int c = 0; int x = 0;
		int i = 0; int j1 = 0;
		while (x == cant.length || i == misInfectados.length) {
			misInfectados[i][j1]=misFabricas[x].crear();
			c++;
			j1++;
			if (c == cant[x]) {
				c=0;
				x++;
			}
			if (j1 == misInfectados[i].length) {
				i++;
				j1=0;
			}
		}
	}
	//Metodos
}
