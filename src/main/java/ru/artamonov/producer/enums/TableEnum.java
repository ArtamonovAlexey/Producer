package ru.artamonov.producer.enums;

public enum TableEnum {

    WORKERS(100L);

    private Long code;

    TableEnum(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
