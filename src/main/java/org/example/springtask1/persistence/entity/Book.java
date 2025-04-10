package org.example.springtask1.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", nullable = false, unique = true)
    private Long isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "bookid", nullable = false)
    private String bookId;

    @Column(name = "series_name")
    private String seriesName;

    @Column(name = "series_num")
    private String seriesNumber;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "bookFormat")
    private String bookFormat;

    @Column(name = "edition")
    private String edition;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "price")
    private String price;

    @Column(name = "publishDate")
    private String publishDate;

    @Column(name = "firstPublishDate")
    private String firstPublishDate;

    @Column(name = "numRatings")
    private Integer numRatings;

    @Column(name = "ratingsByStars")
    private String ratingsByStars;

    @Column(name = "likedPercent")
    private Integer likedPercent;

    @Column(name = "coverImg")
    private String coverImg;

    @Column(name = "bbeScore")
    private Integer bbeScore;

    @Column(name = "bbeVotes")
    private Integer bbeVotes;

    @OneToMany(mappedBy = "book")
    private List<BookGenre> genres;

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> authors;

    @OneToMany(mappedBy = "book")
    private List<BookLanguage> languages;

    @OneToMany(mappedBy = "book")
    private List<BookCharacter> characters;

    @OneToMany(mappedBy = "book")
    private List<BookSetting> setting;

    @OneToMany(mappedBy = "book")
    private List<BookAward> awards;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(String bookFormat) {
        this.bookFormat = bookFormat;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getFirstPublishDate() {
        return firstPublishDate;
    }

    public void setFirstPublishDate(String firstPublishDate) {
        this.firstPublishDate = firstPublishDate;
    }

    public Integer getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(Integer numRatings) {
        this.numRatings = numRatings;
    }

    public String getRatingsByStars() {
        return ratingsByStars;
    }

    public void setRatingsByStars(String ratingsByStars) {
        this.ratingsByStars = ratingsByStars;
    }

    public Integer getLikedPercent() {
        return likedPercent;
    }

    public void setLikedPercent(Integer likedPercent) {
        this.likedPercent = likedPercent;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getBbeScore() {
        return bbeScore;
    }

    public void setBbeScore(Integer bbeScore) {
        this.bbeScore = bbeScore;
    }

    public Integer getBbeVotes() {
        return bbeVotes;
    }

    public void setBbeVotes(Integer bbeVotes) {
        this.bbeVotes = bbeVotes;
    }

    public List<BookGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<BookGenre> genres) {
        this.genres = genres;
    }

    public List<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<BookAuthor> authors) {
        this.authors = authors;
    }

    public List<BookLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<BookLanguage> languages) {
        this.languages = languages;
    }

    public List<BookCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<BookCharacter> characters) {
        this.characters = characters;
    }

    public List<BookSetting> getSetting() {
        return setting;
    }

    public void setSetting(List<BookSetting> setting) {
        this.setting = setting;
    }

    public List<BookAward> getAwards() {
        return awards;
    }

    public void setAwards(List<BookAward> awards) {
        this.awards = awards;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }


}
