package com.codingdojo.calculadora;

public class Calculadora {
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double result;
	
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public double getResult() {
		return result;
	}
	
	public void performOperation() {
		switch (operation) {
		case "+":
			result = operandOne + operandTwo;
			break;
		case "-":
			result = operandOne - operandTwo;
			break;
		default:
			System.out.println("La operación ingresada no es Soportada");
		}
	}
}
