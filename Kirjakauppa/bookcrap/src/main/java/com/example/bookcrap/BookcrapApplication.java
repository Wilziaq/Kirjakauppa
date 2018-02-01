package com.example.bookcrap;

import com.example.bookcrap.KirjaKontrolleri.Kirja;
import com.example.bookcrap.KirjaKontrolleri.KirjaRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookcrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcrapApplication.class, args);
	}

	@Bean
	public CommandLineRunner kirjaKauppa(KirjaRepo repo){
		return (args) -> {
			repo.save(new Kirja("leka","heka", "123"));
			repo.save(new Kirja("Humisevat Hurjat","MArtti", "34536"));
			repo.save(new Kirja("Juupelis","Toljanteir", "666"));

			for(Kirja book: repo.findAll()){
				System.out.print(book);
			}
		};
	}
}
