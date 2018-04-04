## this sample java10 and spring-boot 


java10 local Variable `var`

```java
@GetMapping
public List<String> persons() {
    var persons = personRepository.findAll();
    var personsStream = StreamSupport.stream(persons.spliterator(), false);
    return personsStream.map(Person::getName).collect(toList());
}
```

> the github does not highlight `var`  :( 

