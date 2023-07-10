package com.codingdojo.maestrodeobjetos;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ninja ninja = new Ninja();
		Wizzard mago = new Wizzard();
		Samurai samu = new Samurai();
		
		ninja.attack(mago);
		mago.attack(ninja);
		samu.attack(mago);
		
	}

}
