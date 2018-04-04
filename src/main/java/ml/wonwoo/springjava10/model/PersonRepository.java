package ml.wonwoo.springjava10.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByName(String name);
}
