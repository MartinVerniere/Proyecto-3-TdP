package Logica;

import Logica.Entidades.Entidad;
import Logica.Fabrica_Infectados.FabricaInfectado;
import Logica.Fabrica_Infectados.Fabricaalfa;
import Logica.Fabrica_Infectados.Fabricabeta;

public class Nivel_1 extends Nivel {
	//Atributos
	//Constructor
	public Nivel_1(Juego j) {
		super(j);
		siguiente=new Nivel_2(juego);
		
		cant=new int[2];
		cant[0]=10;
		cant[1]=10;
		
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
				j1=0;
				i++;
			}
		}
	}
	//Metodos
}
