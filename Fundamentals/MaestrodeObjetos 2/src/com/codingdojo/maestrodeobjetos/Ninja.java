package com.codingdojo.maestrodeobjetos;

public class Ninja extends Human {
	public Ninja () {
		super();
		this.setHealth(100);
		this.setStealth(10);
	}
	public void steal (Human enemy) {
		int saludrobada = this.getStealth();
		enemy.setHealth(getHealth()-saludrobada);
		this.setHealth(getHealth()+ saludrobada);
		System.out.println("El ninja te ha robado y te ha quitado " + saludrobada + " puntos de salud, tambien se ha curado " + saludrobada + " puntos de salud");
	}
	public void huir () {
		this.setHealth(getHealth()-10);
		System.out.println("El ninja ha lanzado una bomba de humo y ha huido pero ha recibido heridas y ha perdido 10 pts de salud. ");
	}
}
