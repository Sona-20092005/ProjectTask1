//package org.example.springtask1.persistence.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name = "book_info")
////@Setter
////@Getter
//public class BookInfo {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
////    @OneToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "book_id")
////    private Book book;
//
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
////    public Book getBook() {
////        return book;
////    }
////
////    public void setBook(Book book) {
////        this.book = book;
////    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Float getRating() {
//        return rating;
//    }
//
//    public void setRating(Float rating) {
//        this.rating = rating;
//    }
//
//    public String getCharacters() {
//        return characters;
//    }
//
//    public void setCharacters(String characters) {
//        this.characters = characters;
//    }
//
//    public String getBookFormat() {
//        return bookFormat;
//    }
//
//    public void setBookFormat(String bookFormat) {
//        this.bookFormat = bookFormat;
//    }
//
//    public String getEdition() {
//        return edition;
//    }
//
//    public void setEdition(String edition) {
//        this.edition = edition;
//    }
//
//    public Integer getPages() {
//        return pages;
//    }
//
//    public void setPages(Integer pages) {
//        this.pages = pages;
//    }
//
//    public Float getPrice() {
//        return price;
//    }
//
//    public void setPrice(Float price) {
//        this.price = price;
//    }
//
//    public String getPublishDate() {
//        return publishDate;
//    }
//
//    public void setPublishDate(String publishDate) {
//        this.publishDate = publishDate;
//    }
//
//    public String getFirstPublishDate() {
//        return firstPublishDate;
//    }
//
//    public void setFirstPublishDate(String firstPublishDate) {
//        this.firstPublishDate = firstPublishDate;
//    }
//
//    public String getAwards() {
//        return awards;
//    }
//
//    public void setAwards(String awards) {
//        this.awards = awards;
//    }
//
//    public Integer getNumRatings() {
//        return numRatings;
//    }
//
//    public void setNumRatings(Integer numRatings) {
//        this.numRatings = numRatings;
//    }
//
//    public String getRatingsByStars() {
//        return ratingsByStars;
//    }
//
//    public void setRatingsByStars(String ratingsByStars) {
//        this.ratingsByStars = ratingsByStars;
//    }
//
//    public Integer getLikedPercent() {
//        return likedPercent;
//    }
//
//    public void setLikedPercent(Integer likedPercent) {
//        this.likedPercent = likedPercent;
//    }
//
//    public String getSetting() {
//        return setting;
//    }
//
//    public void setSetting(String setting) {
//        this.setting = setting;
//    }
//
//    public String getCoverImg() {
//        return coverImg;
//    }
//
//    public void setCoverImg(String coverImg) {
//        this.coverImg = coverImg;
//    }
//
//    public Integer getBbeScore() {
//        return bbeScore;
//    }
//
//    public void setBbeScore(Integer bbeScore) {
//        this.bbeScore = bbeScore;
//    }
//
//    public Integer getBbeVotes() {
//        return bbeVotes;
//    }
//
//    public void setBbeVotes(Integer bbeVotes) {
//        this.bbeVotes = bbeVotes;
//    }
//}
