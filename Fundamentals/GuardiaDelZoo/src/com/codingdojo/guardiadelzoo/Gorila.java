package com.codingdojo.guardiadelzoo;

public class Gorila extends Mamifero{
	
	public Gorila() {
	}
	public void arrojarCosas() {
		setEnergy(getEnergy()-5);
		System.out.println("El gorila te ha arrojado fecas. "+ "El nivel de energía actual del Gorila es : "+ super.getEnergy());
	}
	public void comerbananas() {
		setEnergy(getEnergy()+10);
		System.out.println("El Gorila se ha comido una banana. " + "El nivel de energía actual del Gorila es : "+ super.getEnergy());
	}
	public void escalar() {
		setEnergy(getEnergy()-10);
		System.out.println("El gorila ha escalado. " + "El nivel de energía actual del Gorila es : "+ super.getEnergy());
		

	}
}
