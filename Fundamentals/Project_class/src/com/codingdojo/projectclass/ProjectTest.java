package com.codingdojo.projectclass;

public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project project1 = new Project();
		System.out.println("Elevator Pitch: "+ project1.elevatorPitch());
		
		Project project2 = new Project("Marcela");
		System.out.println("Elevator Pitch: " + project2.elevatorPitch());
		
		Project project3 = new Project ("Juan", "Un señor que se llama Juan");
		System.out.println("Elevator Pitch: " + project3.elevatorPitch());
	}

}
