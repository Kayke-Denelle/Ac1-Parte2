	package com.example.cinema;

	

	import java.util.List;

	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.context.annotation.Bean;

import com.example.cinema.Models.Diretor;
import com.example.cinema.Models.Filmes;
import com.example.cinema.Repositories.DiretorRepository;
	import com.example.cinema.Repositories.FilmeRepository;

	@SpringBootApplication
	public class CinemaApplication {

		public static void main(String[] args) {
			SpringApplication.run(CinemaApplication.class, args);
		}

		@Bean
		public CommandLineRunner demo(FilmeRepository filmeRepository, DiretorRepository diretorRepository) {
			return (args) -> {

				filmeRepository.deleteAll();
				diretorRepository.deleteAll();

				Diretor nolan = new Diretor("Christopher Nolan");
				Diretor bong = new Diretor("Bong Joon-ho");
				Diretor lasseter = new Diretor("John Lasseter");

				diretorRepository.save(nolan);
				diretorRepository.save(bong);
				diretorRepository.save(lasseter);
				
				// Criando os filmes com seus diretores
				Filmes filme1 = new Filmes("Interestelar", 169, nolan);
				Filmes filme2 = new Filmes("Parasita", 132, bong);
				Filmes filme3 = new Filmes("Toy Story", 81, lasseter);
				
				filmeRepository.save(filme1);
				filmeRepository.save(filme2);
				filmeRepository.save(filme3);

				System.out.println("FILMES INSERIDOS COM SUCESSO");
				System.out.println("1. " + filme1.getTitulo() + " - " + filme1.getDuracao() + " min");
				System.out.println("2. " + filme2.getTitulo() + " - " + filme2.getDuracao() + " min");
				System.out.println("3. " + filme3.getTitulo() + " - " + filme3.getDuracao() + " min");
				System.out.println();

			
				System.out.println("Filmes com duração > 120 minutos");
				List<Filmes> filmesLongos = filmeRepository.findByDuracaoGreaterThan(120);
				filmesLongos.forEach(f -> 
					System.out.println(f.getTitulo() + " - " + f.getDuracao() + " min"));
				System.out.println();

				System.out.println("Filmes com duração <= 120 minutos");
				List<Filmes> filmesCurtoMedio = filmeRepository.findByDuracaoLessThanEqual(120);
				filmesCurtoMedio.forEach(f -> 
					System.out.println(f.getTitulo() + " " + f.getDuracao() + " min"));
				System.out.println();

				System.out.println("Filmes que começam com 'P'");
				List<Filmes> filmesComO = filmeRepository.findByTituloStartingWith("P");
				filmesComO.forEach(f -> 
					System.out.println(f.getTitulo() + " " + f.getDuracao() + " min"));
				System.out.println();

				System.out.println("Diretores que comecem com 'chris'");
        		diretorRepository.findByNomeStartingWith("Chris")
            	.forEach(d -> System.out.println(d.getNome()));
        
				System.out.println("\nDIRETOR COM FILMES (ID 2)");
				Diretor diretorComFilmes = diretorRepository.findByIdWithFilmes(2L);
				System.out.println("Diretor: " + diretorComFilmes.getNome());
				System.out.println("Filmes:");
				diretorComFilmes.getFilmes().forEach(f -> 
					System.out.println(" - " + f.getTitulo() + " (" + f.getDuracao() + " min)"));

			};
		}
	}