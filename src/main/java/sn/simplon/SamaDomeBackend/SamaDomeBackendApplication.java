package sn.simplon.SamaDomeBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.simplon.SamaDomeBackend.entity.Maladies;
import sn.simplon.SamaDomeBackend.entity.Vaccins;
import sn.simplon.SamaDomeBackend.repository.MaladiesRepository;
import sn.simplon.SamaDomeBackend.repository.VaccinationRepository;
import sn.simplon.SamaDomeBackend.repository.VaccinsRepository;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SamaDomeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamaDomeBackendApplication.class, args);
	}
@Bean
	CommandLineRunner  start (MaladiesRepository maladiesRepository,
							  VaccinsRepository vaccinsRepository) {
		return args -> {
			Stream.of("fievre jaune","diffeterie","tetanos").forEach(name->{
				Vaccins vaccins=new Vaccins();
				vaccins.setId(1);
				vaccins.setNomVaccin(name);
				vaccins.setEffetSecondaire("maux de tete");
				vaccins.setAge("12mois");
				vaccinsRepository.save(vaccins);

			});

		};

	}
}
