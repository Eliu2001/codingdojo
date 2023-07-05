package com.codingdojo.guardiadelzoo;

public class Mamifero {

	private int energia = 100;

	public Mamifero() {
	}

	public Mamifero(int energy) {
		this.energia = energy;
	}

	public int getEnergy() {
		return energia;
	}

	public void setEnergy(int energy) {
		this.energia = energy;
	}
	public void displayEnergy() {
		System.out.println("El nivel de energía es : " + energia);
	}
	
}
