package org.example.springtask1.service.dto;

import jakarta.persistence.*;
import org.example.springtask1.persistence.entity.BookLanguage;

import java.util.List;
import java.util.Objects;

public class LanguageDto {

    private Long id;
    private String language;
    private String additional;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageDto that = (LanguageDto) o;
        return Objects.equals(language, that.language) && Objects.equals(additional, that.additional);
    }
}
