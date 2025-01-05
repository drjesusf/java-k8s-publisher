package com.example.k8spublisher;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
