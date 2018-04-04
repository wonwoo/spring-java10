package ml.wonwoo.springjava10.web;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.wonwoo.springjava10.model.Person;
import ml.wonwoo.springjava10.model.PersonRepository;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<String> persons() {
        var persons = personRepository.findAll();
        var personsStream = StreamSupport.stream(persons.spliterator(), false);
        return personsStream.map(Person::getName).collect(toList());
    }

    @GetMapping("/{name}")
    public String person(@PathVariable String name) {
        var person = personRepository.findByName(name);
        return person.orElseThrow(() -> new UsernameNotFoundException(name)).getName();
    }
}
