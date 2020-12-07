package Logica.Visitors;

import Logica.Entidades.Premio;

public abstract class Visitor_premio extends Visitor {
	//Atributos
	Premio miPremio;
	//Constructor
	Visitor_premio(Premio p){
		this.miPremio=p;
	}
}
