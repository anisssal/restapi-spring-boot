package id.co.anis.crudrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudrestapiApplication.class, args);
	}

}
