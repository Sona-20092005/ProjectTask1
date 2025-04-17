//package org.example.springtask1.service.dto.jackson;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.example.springtask1.persistence.entity.*;
//import org.example.springtask1.persistence.entity.Character;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class BookDto {
//
//    @JsonIgnore
//    private Long id;
//    @JsonProperty("isbn")
//    private Long isbn;
//    @JsonProperty("title")
//    private String title;
//    @JsonProperty("bookId")
//    private String bookId;
//    @JsonProperty("description")
//
//    private String description;
//    @JsonProperty("rating")
//
//    private Float rating;
//    @JsonProperty("edition")
//
//    private String edition;
//    @JsonProperty("pages")
//
//    private Integer pages;
//    @JsonProperty("price")
//
//    private String price;
//    @JsonProperty("publishDate")
//
//    private String publishDate;
//    @JsonProperty("firstPublishDate")
//
//    private String firstPublishDate;
//    @JsonProperty("numRatings")
//
//    private Integer numRatings;
//    @JsonProperty("ratingsByStars")
//
//    private String ratingsByStars;
//    @JsonProperty("likedPercent")
//
//    private Integer likedPercent;
//    @JsonProperty("coverImg")
//
//    private String coverImg;
//    @JsonProperty("bbeScore")
//    private Integer bbeScore;
//    @JsonProperty("bbeVotes")
//    private Integer bbeVotes;
//    @JsonProperty("author")
//    private List<AuthorDto> authorList;
//    @JsonProperty("genres")
//    private List<GenreDto> genreList;
//    @JsonProperty("language")
//    private List<LanguageDto> languageList;
//    @JsonProperty("characters")
//    private List<CharacterDto> characterList;
//    @JsonProperty("setting")
//    private List<SettingDto> settingList;
//    @JsonProperty("awards")
//    private List<AwardDto> awardList;
//    @JsonProperty("series")
//    private List<SeriesDto> seriesList;
//    @JsonProperty("bookFormat")
//    private List<FormatDto> formatList;
//    @JsonProperty("publisher")
//    private PublisherDto publisher;
//
//    @JsonProperty("isbn")
//    public void setCheckIsbn(String isbnStr) {
//        if (checkIfNumber(isbnStr)) {
//            this.setIsbn(Long.valueOf(isbnStr));
//        }
//    }
//
//    @JsonProperty("title")
//    public void setCheckTitle(String titleStr) {
//        if (check(titleStr)) {
//            this.setTitle(titleStr.trim());
//        }
//    }
//
//    @JsonProperty("bookId")
//    public void setCheckBookId(String bookIdStr) {
//        if (check(bookIdStr)) {
//            this.setBookId(bookIdStr.trim());
//        }
//    }
//
//    @JsonProperty("rating")
//    public void setCheckRating(String ratingStr) {
//        if (checkIfNumber(ratingStr)) {
//            this.setRating(Float.valueOf(ratingStr));
//        }
//    }
//
//    @JsonProperty("numRatings")
//    public void setCheckNumRating(String numRatingStr) {
//        if (checkIfNumber(numRatingStr)) {
//            this.setNumRatings(Integer.valueOf(numRatingStr));
//        }
//    }
//
//    @JsonProperty("description")
//    public void setCheckDescription(String descriptionStr) {
//        if (check(descriptionStr)) {
//            this.setDescription(descriptionStr.trim());
//        }
//    }
//
//    @JsonProperty("edition")
//    public void setCheckEdition(String editionStr) {
//        if (check(editionStr)) {
//            this.setEdition(editionStr.trim());
//        }
//    }
//
//    @JsonProperty("pages")
//    public void setCheckPages(String pagesStr) {
//        if (checkIfNumber(pagesStr)) {
//            this.setPages(Integer.valueOf(pagesStr));
//        }
//    }
//
//    @JsonProperty("price")
//    public void setCheckPrice(String priceStr) {
//        if (check(priceStr)) {
//            this.setPrice(priceStr.trim());
//        }
//    }
//
//    @JsonProperty("publishDate")
//    public void setCheckPublishDate(String publishDateStr) {
//        if (check(publishDateStr)) {
//            this.setPublishDate(publishDateStr.trim());
//        }
//    }
//
//    @JsonProperty("firstPublishDate")
//    public void setCheckFirstPublishDate(String firstPublishDateStr) {
//        if (check(firstPublishDateStr)) {
//            this.setFirstPublishDate(firstPublishDateStr.trim());
//        }
//    }
//
//    @JsonProperty("ratingsByStars")
//    public void setCheckRatingsByStars(String ratingsByStarsStr) {
//        if (check(ratingsByStarsStr)) {
//            this.setRatingsByStars(ratingsByStarsStr.trim());
//        }
//    }
//
//    @JsonProperty("likedPercent")
//    public void setCheckLikedPercent(String likedPercentStr) {
//        if (checkIfNumber(likedPercentStr)) {
//            this.setLikedPercent(Integer.valueOf(likedPercentStr));
//        }
//    }
//
//    @JsonProperty("coverImg")
//    public void setCheckCoverImg(String coverImgStr) {
//        if (check(coverImgStr)) {
//            this.setCoverImg(coverImgStr.trim());
//        }
//    }
//
//    @JsonProperty("bbeScore")
//    public void setCheckBbeScore(String bbeScoreStr) {
//        if (checkIfNumber(bbeScoreStr)) {
//            this.setBbeScore(Integer.valueOf(bbeScoreStr));
//        }
//    }
//
//    @JsonProperty("bbeVotes")
//    public void setCheckBbeVotes(String bbeVotesStr) {
//        if (checkIfNumber(bbeVotesStr)) {
//            this.setBbeVotes(Integer.valueOf(bbeVotesStr));
//        }
//    }
//
//    @JsonProperty("author")
//    public void setAuthors(String authorsStr) {
//        List<AuthorDto> currentAuthorDtoList = new ArrayList<>();
//        if (check(authorsStr)) {
//
//            String[] authors = authorsStr.split(",");
//            for (String author : authors) {
//                AuthorDto authorDto = new AuthorDto();
//
//                int open = author.indexOf('(');
//                int close = author.indexOf(')');
//
//                if (open != -1 && close != -1 && open < close) {
//                    authorDto.setName(author.substring(0, open).trim());
//                    authorDto.setRole(author.substring(open + 1, close).trim());
//                }
//                else {
//                    authorDto.setName(author.trim());
//                }
//
//                if (!authorDto.getName().isBlank()) {
//                    currentAuthorDtoList.add(authorDto);
//                }
//            }
//
//            if (!currentAuthorDtoList.isEmpty()) {
//                this.setAuthorList(currentAuthorDtoList);
//            }
//        }
//    }
//
//    @JsonProperty("genres")
//    public void setGenres(String genreStr) {
//        List<GenreDto> currentGenreDtoList = new ArrayList<>();
//
//        if (check(genreStr)) {
//
//            String[] genres = divideStringSquare(genreStr);
//
//            for (String genre : genres) {
//                GenreDto genreDto = new GenreDto();
//                genreDto.setGenre(genre.trim());
//
//                if (!genreDto.getGenre().isEmpty()) {
//                    currentGenreDtoList.add(genreDto);
//                }
//            }
//        }
//
//        this.setGenreList(currentGenreDtoList);
//    }
//
//
//    @JsonProperty("language")
//    public void setLanguages(String languageStr) {
//        List<LanguageDto> currentLanguageDtoList = new ArrayList<>();
//
//        if (check(languageStr)) {
//
//            String[] languages = languageStr.split(";");
//            for (String language : languages) {
//                LanguageDto languageDto = new LanguageDto();
//
//                String[] languageSplitted = language.split(",");
//
//                languageDto.setLanguage(languageSplitted[0].trim());
//                if (languageSplitted.length != 1) {
//                    languageDto.setAdditional(languageSplitted[1].trim());
//                }
//
//                if (!languageDto.getLanguage().isBlank()) {
//                    currentLanguageDtoList.add(languageDto);
//                }
//            }
//
//        }
//        this.setLanguageList(currentLanguageDtoList);
//    }
//
//    @JsonProperty("characters")
//    public void setCharacters(String characterStr) {
//        List<CharacterDto> currentCharacterDtoList = new ArrayList<>();
//
//        if (check(characterStr)) {
//
//            String[] characters = divideStringSquare(characterStr);
//
//            for (String character : characters) {
//                CharacterDto characterDto = new CharacterDto();
//                characterDto.setName(character.trim());
//
//                if (!characterDto.getName().isEmpty()) {
//                    currentCharacterDtoList.add(characterDto);
//                }
//            }
//
//        }
//        this.setCharacterList(currentCharacterDtoList);
//    }
//
//    @JsonProperty("setting")
//    public void setSettings(String settingStr) {
//        List<SettingDto> currentSettingDtoList = new ArrayList<>();
//
//        if (check(settingStr)) {
//
//            String[] settings = divideStringSquare(settingStr);
//
//            for (String setting : settings) {
//                SettingDto settingDto = new SettingDto();
//                settingDto.setSetting(setting.trim());
//
//                if (!settingDto.getSetting().isEmpty()) {
//                    currentSettingDtoList.add(settingDto);
//                }
//            }
//
//        }
//        this.setSettingList(currentSettingDtoList);
//    }
//
//    @JsonProperty("awards")
//    public void setAwards(String awardStr) {
//        List<AwardDto> currentAwardDtoList = new ArrayList<>();
//
//        if (check(awardStr)) {
//
//            String[] awards = divideStringSquare(awardStr);
//
//            for (String award : awards) {
//                AwardDto awardDto = new AwardDto();
//                award = award.trim();
//
//                int openInner = award.lastIndexOf('(');
//                int closeInner = award.lastIndexOf(')');
//
//                if (openInner < closeInner && closeInner == award.length() - 1) {
//                    String yearString = award.substring(openInner + 1, closeInner).trim();
//                    if (NumberUtils.isCreatable(yearString)) {
//                        awardDto.setAward(award.substring(0, openInner).trim());
//                        awardDto.setYear(Integer.valueOf(yearString));
//                    }
//                    else {
//                        awardDto.setAward(award);
//                    }
//                }
//                else {
//                    awardDto.setAward(award);
//                }
//
//                if (!awardDto.getAward().isEmpty()) {
//                    currentAwardDtoList.add(awardDto);
//                }
//            }
//        }
//        this.setAwardList(currentAwardDtoList);
//    }
//
//    @JsonProperty("bookFormat")
//    public void setFormats(String formatStr) {
//        List<FormatDto> currentFormatDtoList = new ArrayList<>();
//
//        if (check(formatStr)) {
//            String[] formats = formatStr.split(",");
//
//            for (String format : formats) {
//                FormatDto formatDto = new FormatDto();
//                formatDto.setFormat(format.trim());
//
//                if (!formatDto.getFormat().isEmpty()) {
//                    currentFormatDtoList.add(formatDto);
//                }
//            }
//        }
//        this.setFormatList(currentFormatDtoList);
//    }
//
//    @JsonProperty("series")
//    public void setSeries(String seriesStr) {
//        List<SeriesDto> currentSeriesDtoList = new ArrayList<>();
//
//        if (check(seriesStr)) {
//            String[] seriesSplitted = seriesStr.split(",");
//
//            for (String series1 : seriesSplitted) {
//                SeriesDto seriesDto = new SeriesDto();
//
//                String[] input = series1.split("#");
//
//                seriesDto.setSeries(input[0].trim());
//
//                if (input.length != 1) {
//                    seriesDto.setSeriesNumber(input[1].trim());
//                }
//
//                if (!seriesDto.getSeries().isEmpty()) {
//                    currentSeriesDtoList.add(seriesDto);
//                }
//            }
//        }
//        this.setSeriesList(currentSeriesDtoList);
//    }
//
//    @JsonProperty("publisher")
//    public void setPublisher(String publisherStr) {
//        if (check(publisherStr)) {
//            PublisherDto publisherDto = new PublisherDto();
//            publisherDto.setName(publisherStr.trim());
//
//            this.setPublisher(publisherDto);
//        }
//    }
//
//
//    private static String[] divideStringSquare(String str) {
//        int open = str.indexOf('[');
//        int close = str.indexOf(']');
//
//        if (open != -1 && close != -1 && open < close) {
//            str = str.substring(1, str.length() - 1);
//        }
//        str = str.replace("'", "");
//        str = str.replace("\"", "");
//
//        return str.split(",");
//    }
//
//    private static boolean checkIfNumber(String string) {
//        return NumberUtils.isCreatable(string);
//    }
//
//    private static boolean check(String string) {
//        return string != null && !string.isBlank();
//    }
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
//    public Long getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(Long isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(String bookId) {
//        this.bookId = bookId;
//    }
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
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
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
//
//    public List<AuthorDto> getAuthorList() {
//        return authorList;
//    }
//
//    public void setAuthorList(List<AuthorDto> authorList) {
//        this.authorList = authorList;
//    }
//
//    public List<GenreDto> getGenreList() {
//        return genreList;
//    }
//
//    public void setGenreList(List<GenreDto> genreList) {
//        this.genreList = genreList;
//    }
//
//    public List<LanguageDto> getLanguageList() {
//        return languageList;
//    }
//
//    public void setLanguageList(List<LanguageDto> languageList) {
//        this.languageList = languageList;
//    }
//
//    public List<CharacterDto> getCharacterList() {
//        return characterList;
//    }
//
//    public void setCharacterList(List<CharacterDto> characterList) {
//        this.characterList = characterList;
//    }
//
//    public List<SettingDto> getSettingList() {
//        return settingList;
//    }
//
//    public void setSettingList(List<SettingDto> settingList) {
//        this.settingList = settingList;
//    }
//
//    public List<AwardDto> getAwardList() {
//        return awardList;
//    }
//
//    public void setAwardList(List<AwardDto> awardList) {
//        this.awardList = awardList;
//    }
//
//    public List<SeriesDto> getSeriesList() {
//        return seriesList;
//    }
//
//    public void setSeriesList(List<SeriesDto> seriesList) {
//        this.seriesList = seriesList;
//    }
//
//    public List<FormatDto> getFormatList() {
//        return formatList;
//    }
//
//    public void setFormatList(List<FormatDto> formatList) {
//        this.formatList = formatList;
//    }
//
//    public PublisherDto getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(PublisherDto publisher) {
//        this.publisher = publisher;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BookDto bookDto = (BookDto) o;
//        return Objects.equals(isbn, bookDto.isbn);
//    }
//
//    @Override
//    public String toString() {
//        return "BookDto{" +
//                "id=" + id +
//                ", isbn=" + isbn +
//                ", title='" + title + '\'' +
//                ", bookId='" + bookId + '\'' +
//                ", description='" + description + '\'' +
//                ", rating=" + rating +
//                ", edition='" + edition + '\'' +
//                ", pages=" + pages +
//                ", price='" + price + '\'' +
//                ", publishDate='" + publishDate + '\'' +
//                ", firstPublishDate='" + firstPublishDate + '\'' +
//                ", numRatings=" + numRatings +
//                ", ratingsByStars='" + ratingsByStars + '\'' +
//                ", likedPercent=" + likedPercent +
//                ", coverImg='" + coverImg + '\'' +
//                ", bbeScore=" + bbeScore +
//                ", bbeVotes=" + bbeVotes +
//                ", authorList=" + authorList +
//                ", genreList=" + genreList +
//                ", languageList=" + languageList +
//                ", characterList=" + characterList +
//                ", settingList=" + settingList +
//                ", awardList=" + awardList +
//                ", seriesList=" + seriesList +
//                ", formatList=" + formatList +
//                ", publisher=" + publisher +
//                '}';
//    }
//}