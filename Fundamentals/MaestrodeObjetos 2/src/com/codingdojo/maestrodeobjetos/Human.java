package com.codingdojo.maestrodeobjetos;

public class Human {
	private int strength = 3;
	private int intelligence = 3;
	private int stealth = 3 ;
	private int health = 100;
	
	public Human () {
	}
	
	public Human(int strength, int intelligence, int stealth, int health) {
		this.strength = strength;
		this.intelligence = intelligence;
		this.stealth = stealth;
		this.health = health;
	}
	
	public void attack(Human enemigo) {
		int puntosDeVidaQuitados = this.strength;
        enemigo.health -= puntosDeVidaQuitados;
		System.out.println(this.getClass().getSimpleName() + " quitó "+ puntosDeVidaQuitados + " puntos de vida a " +
                enemigo.getClass().getSimpleName());
		System.out.println("Su vida restante es de : "+ enemigo.health);
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
}
