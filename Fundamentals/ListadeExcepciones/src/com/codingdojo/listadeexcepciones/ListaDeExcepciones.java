package com.codingdojo.listadeexcepciones;

import java.util.ArrayList;

public class ListaDeExcepciones {
	public void verlist(ArrayList<Object> lista) {
		for( int i = 0; i < lista.size(); i++) {
			try {
				int castedValue = (int) lista.get(i);
				System.out.println("El valor del indice " + i+  "es: " + castedValue );	
			}
			catch (ClassCastException x ) {
				System.out.println("Hay un error en el índice "+ i + "valor = "+ lista.get(i));
			}
		}
	}
}
