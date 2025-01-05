package com.example.k8spublisher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Value("${ENV}")
    private String environment;
    public PersonController() {}

    @GetMapping("products/all")
    public List<Person> list() {
        System.out.println("Desde el environment: " + environment);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Jesus",30));
        persons.add(new Person("David",32));
        persons.add(new Person("Fabrizio",4));
        persons.add(new Person("Fabri",5));

        return persons;
    }
}
