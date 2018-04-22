package nl.paisanrietbroek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ExamCreatorApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExamCreatorApplication.class, args);
	}
}
