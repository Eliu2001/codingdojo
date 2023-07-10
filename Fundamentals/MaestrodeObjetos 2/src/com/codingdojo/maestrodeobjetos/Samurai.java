package com.codingdojo.maestrodeobjetos;

public class Samurai extends Human{
	private static int samuraicount = 0;
	public Samurai () {
		super ();
		this.setHealth(200);
		samuraicount++;
	}
	public void deathBlow(Human enemy) {
		enemy.setHealth(0);
		this.setHealth(getHealth()/2);
		System.out.println("El samurai a usado su espada y te ha cortado por la mitad, has muerto. El samurai pierde la mitad de los puntos de vida por el esfuerzo");
	}
	public void meditate() {
		int saludrecuperada = this.getHealth()/2;
		this.setHealth(getHealth()+ saludrecuperada);
		System.out.println("La paz interior ha curado al samurai "+ saludrecuperada + " puntos de vida");
	}
	public int howMany() {
		return samuraicount;
	}
}
