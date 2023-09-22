package com.example.artistsservice;

import com.example.artistsservice.model.Artist;
import com.example.artistsservice.repository.ArtistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArtistsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtistsServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ArtistRepository repository) {
		return (args) -> {
			if (!repository.findAll().isEmpty()) {
				return;
			}

			Artist artistA = new Artist("1", "Maddona", "Pop");
			Artist artistB = new Artist("2", "Pearl Jam", "Rock");
			Artist artistC = new Artist("3", "Stone Temple Pilots", "Rock");

			repository.save(artistA);
			repository.save(artistB);
			repository.save(artistC);
		};
	}

}
