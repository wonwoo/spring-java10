package ml.wonwoo.springjava10.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameNotFoundException extends RuntimeException {

    private final String name;

    public UsernameNotFoundException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "i`m sorry! " + this.name + " not found";
    }
}
