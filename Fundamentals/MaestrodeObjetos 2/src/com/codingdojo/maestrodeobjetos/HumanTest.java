package com.codingdojo.maestrodeobjetos;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ninja ninja = new Ninja();
		Wizzard mago = new Wizzard();
		Samurai samu = new Samurai();
		
		ninja.steal(samu);
		ninja.huir();
		samu.meditate();
		samu.deathBlow(ninja);
		samu.howMany();
		mago.fireball(samu);
		System.out.println(ninja.getHealth());
		System.out.println(samu.getHealth());
		System.out.println(mago.getHealth());
		
		
		
		
		
	}

}
