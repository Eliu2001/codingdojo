package com.codingdojo.calculadora;

public class CalculadoraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculadora calc = new Calculadora();
		
		calc.setOperandOne(10.5);
		calc.setOperation("+");
		calc.setOperandTwo(5.2);
		calc.performOperation();
		System.out.println("el resultado es : "+ calc.getResult());
	}

}
