package test1;

public class Pitagoras {

	public static void main(String[] args) {
		System.out.println(calcularHipotenusa(5,6));
	}
	public static double calcularHipotenusa(int catetoA, int CatetoB) {
		return
				Math.sqrt(Math.pow(catetoA,2) + Math.pow(CatetoB, 2));
	}
}
