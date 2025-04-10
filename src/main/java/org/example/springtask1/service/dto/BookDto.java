package org.example.springtask1.service.dto;

import org.example.springtask1.persistence.entity.Award;

import java.util.List;
import java.util.Objects;
import java.util.Set;

//@Getter
//@Setter
//@ToString
public class BookDto {
    private Long id;

    private Long isbn;
    private String title;
    private String bookId;
//    private List<String> genres;
//    private List<String> authors;
//    private List<String> language;
//    private String publisher;
    private String series;
    private String seriesNumber;
    private String description;
    private Float rating;
    private String bookFormat;
    private String edition;
    private Integer pages;
    private String price;
    private String publishDate;
    private String firstPublishDate;
    private Integer numRatings;
    private String ratingsByStars;
    private Integer likedPercent;
    private String coverImg;
    private Integer bbeScore;
    private Integer bbeVotes;

    private List<AuthorDto> authorList;
    private List<GenreDto> genreList;
    private List<LanguageDto> languageList;
    private List<CharacterDto> characterList;
    private List<SettingDto> settingList;
    private List<AwardDto> awardList;

    private PublisherDto publisher;

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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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

    public List<AuthorDto> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorDto> authorList) {
        this.authorList = authorList;
    }

    public List<GenreDto> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<GenreDto> genreList) {
        this.genreList = genreList;
    }

    public List<LanguageDto> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<LanguageDto> languageList) {
        this.languageList = languageList;
    }

    public List<CharacterDto> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<CharacterDto> characterList) {
        this.characterList = characterList;
    }

    public List<SettingDto> getSettingList() {
        return settingList;
    }

    public void setSettingList(List<SettingDto> settingList) {
        this.settingList = settingList;
    }

    public List<AwardDto> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<AwardDto> awardList) {
        this.awardList = awardList;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDto publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(isbn, bookDto.isbn);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", bookId='" + bookId + '\'' +
                ", authorList=" + authorList +
                '}';
    }
}