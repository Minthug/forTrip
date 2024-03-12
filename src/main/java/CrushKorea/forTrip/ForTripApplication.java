package CrushKorea.forTrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ForTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForTripApplication.class, args);
	}

}
