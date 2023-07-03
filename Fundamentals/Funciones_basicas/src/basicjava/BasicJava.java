package basicjava;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {

	// imprimir 1-255
	public int[] print1To255(int numero) {
		int arr[] = new int[numero];
		for (int i = 1; i <= numero; i++) {
			arr[i - 1] = i;
		}
		return arr;
	}

	public int[] print1To255imp(int numero) {
		int arr[] = new int[numero / 2 + 1];
		int contador = 0;
		for (int i = 1; i <= numero; i += 2) {
			arr[contador] = i;
			contador++;
		}
		return arr;
	}

	public void sumParcial(int numero) {
		int acumulador = 0;
		for (int i = 0; i <= numero; i++) {
			acumulador = acumulador + i;
			System.out.println("Nuevo Numero: " + i + " Suma: " + acumulador);
		}
	}

	public void recorrerArray() {
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.addAll(Arrays.asList(1, 2, 3, 4, 5));
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}

	}

	public void foundMax() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(Arrays.asList(1, 2, 3, 4, 5));
		int max = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
			}
		}
		System.out.println(max);
	}

	public void avg() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(Arrays.asList(1, 2, 3, 4, 5));
		int sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		double promedio = (double) sum / arr.size();
		System.out.println(promedio);
	}

	public int[] print1To255arr(int numero) {
		int arr[] = new int[numero / 2 + 1];
		int contador = 0;
		for (int i = 1; i <= numero; i += 2) {
			arr[contador] = i;
			contador++;
		}
		return arr;
	}

	public int mayorQueY(ArrayList<Integer> arr, int y) {
		int contador = 0;
		for (int i : arr) {
			if (i > y) {
				contador++;
			}
		}
		return contador;
	}

	public void alCuadrado(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {

			arr.set(i, arr.get(i) * arr.get(i));
		}
	}

	public void replaceNeg(ArrayList<Integer> arr) {
		for (int i : arr) {
			if (i < 0) {
				arr.set(arr.indexOf(i), 0);
			}
		}
	}

	public double[] maxMinAvg(ArrayList<Integer> arr) {
		int max = arr.get(0);
		int sum = 0;
		int min = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			int num = arr.get(i);
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
			sum += num;
		}
		double promedio = (double) sum / arr.size();
		return new double[] { max, min, promedio };
	}

	public void changeToNext(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size() - 1; i++) {
			arr.set(i, arr.get(i + 1));
		}
		arr.set(arr.size() - 1, 0);
	}
}
