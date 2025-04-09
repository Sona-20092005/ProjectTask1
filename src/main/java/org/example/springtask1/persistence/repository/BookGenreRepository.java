package org.example.springtask1.persistence.repository;

import org.example.springtask1.persistence.entity.Author;
import org.example.springtask1.persistence.entity.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre, Long> {


}

