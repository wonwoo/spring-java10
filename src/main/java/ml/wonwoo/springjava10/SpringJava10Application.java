package ml.wonwoo.springjava10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ml.wonwoo.springjava10.model.Person;
import ml.wonwoo.springjava10.model.PersonRepository;

@SpringBootApplication
public class SpringJava10Application {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringJava10Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository) {
        return args -> {
            var wonwoo = personRepository.save(new Person("wonwoo"));
            var kevin = personRepository.save(new Person("kevin"));
            logger.info("wonwoo : {}", wonwoo);
            logger.info("kevin : {} ", kevin);
            var persons = personRepository.findAll();
            logger.info("persons : {}", persons);
        };
    }
}
