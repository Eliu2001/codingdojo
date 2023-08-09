package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Student;
import com.codingdojo.mvc.repositories.StudentRepository;

@Service
public class StudentService {
	// Agregando el persona al repositorio como una dependencia
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// Devolviendo todos los personas.
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}
	public Optional<Student> encontrarStudentPorId(Long id) {
		return studentRepository.findById(id);
	}

	// Creando un persona.
	public Student createStuden(Student b) {
		return studentRepository.save(b);
	}
	
	public List<Student> obtenerStudentSinContact() {
		return studentRepository.findByContactIsNull();
	}

}
