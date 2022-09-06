package sn.simplon.SamaDomeBackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SamaDomeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamaDomeBackendApplication.class, args);
	}
//@Bean
//	CommandLineRunner  start (MaladiesRepository maladiesRepository,
//							  VaccinsRepository vaccinsRepository) {
//		return args -> {
//			Stream.of("fievre jaune","diffeterie","tetanos").forEach(name->{
//				Vaccins vaccins=new Vaccins();
//				vaccins.setNomVaccin(name);
//				vaccins.setEffetSecondaire("maux de tete");
//				vaccins.setAge("12mois");
//				vaccinsRepository.save(vaccins);
//
//			});
//
//		};
//
//	}
}
