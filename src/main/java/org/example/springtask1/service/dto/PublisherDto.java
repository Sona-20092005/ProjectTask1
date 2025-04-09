package org.example.springtask1.service.dto;

import jakarta.persistence.Column;

import java.util.Objects;

public class PublisherDto {

    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublisherDto that = (PublisherDto) o;
        return Objects.equals(name, that.name);
    }
}
