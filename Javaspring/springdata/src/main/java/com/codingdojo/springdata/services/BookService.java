package com.codingdojo.springdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.springdata.models.Book;
import com.codingdojo.springdata.repositories.BookRepository;

@Service
public class BookService {
	// Agregando el book al repositorio como una dependencia
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Devolviendo todos los libros.
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// Creando un libro.
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// Obteniendo la información de un libro
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	public Book updateBook(Long id, String title, String description, String language, Integer pages) {
		Optional <Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			Book existingBook = optionalBook.get();
			
			existingBook.setTitle(title);
			existingBook.setDescription(description);
			existingBook.setLanguage(language);
			existingBook.setNumberOfPages(pages);
			
			return bookRepository.save(existingBook);
		}
		else {
			return null;
		}
		
	}
	public void deleteBook(Long id) {
        
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            
            bookRepository.delete(optionalBook.get());
        }
        else {
             
            throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
        }
	}
}