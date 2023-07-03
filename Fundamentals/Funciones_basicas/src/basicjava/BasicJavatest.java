package basicjava;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicJavatest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicJava func1 = new BasicJava();

		System.out.println(Arrays.toString(func1.print1To255(255)));
		System.out.println(Arrays.toString(func1.print1To255imp(255)));
		func1.sumParcial(255);
		func1.recorrerArray();
		func1.foundMax();
		func1.avg();
		System.out.println(Arrays.toString(func1.print1To255imp(255)));
		
		ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(1, 2, 3, 4, 5));
        int y = 3;
        int contador = func1.mayorQueY(arr, y);
        System.out.println("El número de valores mayores a " + y + " es: " + contador);
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.addAll(Arrays.asList(1,2,3,4,5,6));
        func1.alCuadrado(arr1);
        System.out.println("Array al cuadrado = " + arr1);
        
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.addAll(Arrays.asList(1,-2,3,-4,-5,6));
        func1.replaceNeg(arr2);
        System.out.println("El Array final es "+ arr2);
        
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.addAll(Arrays.asList(1,2,3,4,5));

        double[] resultado = func1.maxMinAvg(arr3);
        System.out.println("Número máximo: " + resultado[0]);
        System.out.println("Número mínimo: " + resultado[1]);
        System.out.println("Valor promedio: " + resultado[2]);
        
        ArrayList<Integer> arr4 = new ArrayList<>();
        arr4.addAll(Arrays.asList(1,2,3,4,5));
        func1.changeToNext(arr4);
        System.out.println(arr4);
	}
}
