package com.codingdojo.guardiadelzoo;

public class Bat extends Mamifero{

	public Bat() {
		setEnergy(300);
	}
	public void fly() {
		setEnergy(getEnergy()-50);
		System.out.println("Elseñordelanoche.mp3 " + "Su nivel de energia actual es de :" + getEnergy());
	}
	public void eatHumans() {
		setEnergy(getEnergy()+25);
		System.out.println("bueno, no importa " + "Su nivel de energia actual es de :" + getEnergy());
	}
	public void attackTown() {
		setEnergy(getEnergy()-100);
		System.out.println("Attero_Dominattos.mp3 " + "Su nivel de energia actual es de :" + getEnergy());
	}
}
