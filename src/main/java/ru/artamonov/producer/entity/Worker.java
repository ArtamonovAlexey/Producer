package ru.artamonov.producer.entity;

import lombok.Data;

@Data
public class Worker {

    private Long id;

    private String name;

    public Worker(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
