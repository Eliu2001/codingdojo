package com.codingdojo.listadeexcepciones;

import java.util.ArrayList;

public class ListaDeExcepcionesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add("13");
		myList.add("Hola Mundo");
		myList.add(48);
		myList.add("Adios Mundo");
		
		ListaDeExcepciones ex = new ListaDeExcepciones();
		
		ex.verlist(myList);
	}

}
