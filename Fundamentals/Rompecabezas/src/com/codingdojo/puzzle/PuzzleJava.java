package com.codingdojo.puzzle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {

	public Collection<Integer> sumaYMayoresQue10(Collection<Integer> arr) {
		int suma = 0;
		Collection<Integer> mayores = new ArrayList<>();

		for (int i : arr) {
			suma += i;
			if (i > 10) {
				mayores.add(i);
			}
		}
		System.out.println("La suma es " + suma);
		return mayores;
	}
	public Collection<String> names(ArrayList<String> nombres){
		Collections.shuffle(nombres);
		Collection<String> nombresGrandes = new ArrayList<>();
		
		for(String name : nombres) {
			if(name.length()> 5) {
				nombresGrandes.add(name);
			}
			System.out.println(name);
		}
		
		return nombresGrandes;
	}

	public void alfabeto(ArrayList<Character> arr) {
		Collections.shuffle(arr);
		System.out.println(arr.get(0));
		System.out.println(arr.get(arr.size() - 1));
		char primerElemento = arr.get(0);
		if (primerElemento == 'A' || primerElemento == 'E' || primerElemento == 'I' || primerElemento == 'O'
				|| primerElemento == 'U') {
			System.out.println("¡El primer elemento es una vocal!");
		}
	}

	public ArrayList<Integer> random() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random numeros = new Random();
		for(int i = 0; i <= 10; i++) {
			arr.add(numeros.nextInt(55)+ 45);
		}
		return arr;
	}
	
	public ArrayList<Integer> randomSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random numeros = new Random();
		for(int i = 0; i <= 10; i++) {
			arr.add(numeros.nextInt(55)+ 45);	
		}
		Collections.sort(arr);
		return arr;
	}
	public String stringRand() {
		String caracteres =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder cadenarandom = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i <= 10; i++) {
			rand.nextInt(caracteres.length());
			caracteres.charAt(rand.nextInt(caracteres.length()));
			cadenarandom.append(caracteres.charAt(rand.nextInt(caracteres.length())));
		}
		return cadenarandom.toString();
	}
	public ArrayList<String> arrayString() {
		ArrayList<String> arrayStrings = new ArrayList<String>();
		String caracteres =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random rand = new Random();
		for (int i = 0; i<10; i++) {
			String cadena = "";
			for (int j = 0; j<5; j++) {
			int indice = rand.nextInt(caracteres.length());
	        char caracterAleatorio = caracteres.charAt(indice);
	       cadena += caracterAleatorio;
	        }
			arrayStrings.add(cadena);
		}
		return arrayStrings;
	}
	
}
