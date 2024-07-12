package com.demo.spring_boot_demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.spring_boot_demo.model.Author;
import com.demo.spring_boot_demo.model.Book;
import com.demo.spring_boot_demo.repository.AuthorRepository;
import com.demo.spring_boot_demo.repository.BookRepository;

@SpringBootApplication
public class SpringBootDemoApplication {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringBootDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AuthorRepository authorRepository, BookRepository bookRepository) {

		return args -> {
			log.info("Initializing data...Started");
			Author author1 = Author.builder().name("Author 1").email("auth2@gmail.com").build();
			Book book1 = Book.builder().title("Book 1").author(author1).build();
			Book book2 = Book.builder().title("Book 2").author(author1).build();

			author1.setBooks(new ArrayList<>(List.of(book1, book2)));
			authorRepository.save(author1); // saves author1 and its books in the database
			log.info("Initializing data...Completed");

		};
	}

}
