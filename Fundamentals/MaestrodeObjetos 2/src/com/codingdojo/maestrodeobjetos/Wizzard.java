package com.codingdojo.maestrodeobjetos;

public class Wizzard extends Human {

	public Wizzard () {
		super();
		this.setHealth(50);
		this.setIntelligence(8);
	}
	public void fireball(Human enemy) {
		int daño = this.getIntelligence()*3;
		enemy.setHealth(getHealth()-daño);
		System.out.println("El mago a lanzado una bola de fuego, has recibido "+ daño + " puntos de salud");
	}
}