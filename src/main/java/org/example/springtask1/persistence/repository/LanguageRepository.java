package org.example.springtask1.persistence.repository;

import org.example.springtask1.persistence.entity.Author;
import org.example.springtask1.persistence.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByLanguage(String name);

    @Override
    List<Language> findAll();
}

