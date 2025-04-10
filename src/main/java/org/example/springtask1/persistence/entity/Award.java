package org.example.springtask1.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "award")
//@Setter
//@Getter
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "award", nullable = false)
    private String award;

    @Column(name = "year")
    private Integer year;

    @OneToMany(mappedBy = "award")
    private List<BookAward> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public List<BookAward> getBooks() {
        return books;
    }

    public void setBooks(List<BookAward> books) {
        this.books = books;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award1 = (Award) o;
        return Objects.equals(award, award1.award) && Objects.equals(year, award1.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(award, year);
    }
}
