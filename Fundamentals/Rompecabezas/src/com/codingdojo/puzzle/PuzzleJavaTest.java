package com.codingdojo.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PuzzleJavaTest {

	public static void main(String[] args) {
		
		PuzzleJava test = new PuzzleJava();
		
		Collection<Integer> arr = new ArrayList<>(Arrays.asList(3,5,1,2,7,9,8,13,25,32));
		System.out.println(test.sumaYMayoresQue10(arr));
		
		ArrayList<String> nombre = new ArrayList<String>();
		nombre.addAll(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
		System.out.println(test.names(nombre));
		
		ArrayList<Character> letricas = new ArrayList<>();
		for(char c = 'A'; c<='Z'; c++) {
			letricas.add(c);
		}
		test.alfabeto(letricas);
		System.out.println(test.random());
		System.out.println(test.randomSort());
		System.out.println(test.stringRand());
		System.out.println(test.arrayString());
	}
}
