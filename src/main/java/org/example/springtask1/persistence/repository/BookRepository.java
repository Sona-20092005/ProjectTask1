package org.example.springtask1.persistence.repository;

import org.example.springtask1.persistence.entity.Book;
import org.example.springtask1.service.additional.BookCoverView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(Long isbn);

    @Query("SELECT b.coverImg FROM Book b")
    List<String> findAllCoverImg();

    List<BookCoverView> findAllBy();

    Optional<Book> findById(Long id);
    List<Book> findByTitle(String title);

    @Override
    List<Book> findAll();

    @Query("SELECT b.isbn FROM Book b")
    Set<Long> findAllIsbn();
}
