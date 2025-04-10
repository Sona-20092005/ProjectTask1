package org.example.springtask1.service.managers;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.example.springtask1.persistence.entity.Publisher;
import org.example.springtask1.service.additional.BookError;
import org.example.springtask1.service.additional.BookErrorState;
import org.example.springtask1.service.additional.Result;
import org.example.springtask1.service.dto.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVManager {

    public static Result getBookList(MultipartFile file){

        CSVReader reader;
        try {
            reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        }
        catch (IOException e) {
            return null;
        }

        List<BookDto> bookDtoList = new ArrayList<>();
        List<AuthorDto> authorDtoList = new ArrayList<>();
        List<GenreDto> genreDtoList = new ArrayList<>();
        List<LanguageDto> languageDtoList = new ArrayList<>();
        List<PublisherDto> publisherDtoList = new ArrayList<>();

        String[] row;
        String[] headers;

        List<BookError> bookErrorsList = new ArrayList<>();

        try {
            headers = reader.readNext();

            if (headers == null) {
                return null;
            }

            while ((row = reader.readNext()) != null) {
                BookDto bookDto = new BookDto();
                String value;


                //isbn
                value = value(headers, row, "isbn");
                if (NumberUtils.isCreatable(value)) {
                    bookDto.setIsbn(Long.valueOf(value));
                }

                //title
                value = value(headers, row, "title");
                if (value != null && !value.isBlank()) {
                    bookDto.setTitle(value.trim());
                }

                //bookId
                value = value(headers, row, "bookId");
                if (value != null && !value.isBlank()) {
                    bookDto.setBookId(value.trim());
                }

                //author
                List<AuthorDto> currentAuthorDtoList = new ArrayList<>();

                value = value(headers, row, "author");
                if (value != null && !value.isBlank()) {

                    String[] authors = value.split(",");
                    for (String author : authors) {
                        AuthorDto authorDto = new AuthorDto();

                        int open = author.indexOf('(');
                        int close = author.indexOf(')');

                        if (open != -1 && close != -1 && open < close) {
                            authorDto.setName(author.substring(0, open).trim());
                            authorDto.setRole(author.substring(open + 1, close).trim());
                        }
                        else {
                            authorDto.setName(author.trim());
                        }

                        if (!authorDto.getName().isBlank()) {
                            if (!authorDtoList.contains(authorDto)) {
                                authorDtoList.add(authorDto);
                            }
                            else {
                                authorDto = authorDtoList.get(authorDtoList.indexOf(authorDto));
                            }

                            currentAuthorDtoList.add(authorDto);
                        }
                    }

                    if (!currentAuthorDtoList.isEmpty()) {
                        bookDto.setAuthorList(currentAuthorDtoList);
                    }
                }

                //genre
                List<GenreDto> currentGenreDtoList = new ArrayList<>();

                value = value(headers, row, "genres");
                if (value != null && !value.isBlank()) {

                    int open = value.indexOf('[');
                    int close = value.indexOf(']');

                    if (open != -1 && close != -1 && open < close) {
                        value = value.substring(1, value.length() - 1);
                    }
                    value = value.replace("'", "");

                    String[] genres = value.split(",");

                    for (String genre : genres) {
                        GenreDto genreDto = new GenreDto();
                        genreDto.setGenre(genre.trim());

                        if (!genreDto.getGenre().isEmpty()) {

                            if (!genreDtoList.contains(genreDto)) {
                                genreDtoList.add(genreDto);
                            }
                            else {
                                genreDto = genreDtoList.get(genreDtoList.indexOf(genreDto));
                            }

                            currentGenreDtoList.add(genreDto);
                        }
                    }

                    bookDto.setGenreList(currentGenreDtoList);
                }

                //language
                List<LanguageDto> currentLanguageDtoList = new ArrayList<>();

                value = value(headers, row, "language");
                if (value != null && !value.isBlank()) {

                    String[] languages = value.split(";");
                    for (String language : languages) {
                        LanguageDto languageDto = new LanguageDto();

                        String[] languageSplitted = language.split(",");

                        languageDto.setLanguage(languageSplitted[0].trim());
                        if (languageSplitted.length != 1) {
                            languageDto.setAdditional(languageSplitted[1].trim());
                        }

                        if (!languageDto.getLanguage().isBlank()) {
                            if (!languageDtoList.contains(languageDto)) {
                                languageDtoList.add(languageDto);
                            }
                            else {
                                languageDto = languageDtoList.get(languageDtoList.indexOf(languageDto));
                            }

                            currentLanguageDtoList.add(languageDto);
                        }
                    }
                    bookDto.setLanguageList(currentLanguageDtoList);

                }

                //publisher
                value = value(headers, row, "publisher");
                if (value != null && !value.isBlank()) {
                    PublisherDto publisherDto = new PublisherDto();
                    publisherDto.setName(value.trim());

                    if (!publisherDtoList.contains(publisherDto)) {
                        publisherDtoList.add(publisherDto);
                    }
                    else {
                        publisherDto = publisherDtoList.get(publisherDtoList.indexOf(publisherDto));
                    }

                    bookDto.setPublisher(publisherDto);
                }

                //series
                value = value(headers, row, "series");
                if(value != null && !value.isBlank()) {
                    String[] input = value.split("#");

                    bookDto.setSeries(input[0].trim());

                    if (input.length != 1) {
                        bookDto.setSeriesNumber(input[1].trim());
                    }
                }

                //description
                value = value(headers, row, "description");
                if (value != null && !value.isBlank()) {
                    bookDto.setDescription(value.trim());
                }

                //rating
                value = value(headers, row, "rating");
                if (NumberUtils.isCreatable(value)) {
                    bookDto.setRating(Float.valueOf(value));
                }

                //numRatings
                value = value(headers, row, "numRatings");
                if (NumberUtils.isCreatable(value)) {
                    bookDto.setNumRatings(Integer.valueOf(value));
                }

                //characters
                value = value(headers, row, "characters");
                if (value != null && !value.isBlank()) {
                    bookDto.setCharacters(value.trim());
                }

                //bookFormat
                value = value(headers, row, "bookFormat");
                if (value != null && !value.isBlank()) {
                    bookDto.setBookFormat(value.trim());
                }

                //edition
                value = value(headers, row, "edition");
                if (value != null && !value.isBlank()) {
                    bookDto.setEdition(value.trim());
                }

                //pages
                value = value(headers, row, "pages");
                if (NumberUtils.isCreatable(value)) {
                    bookDto.setPages(Integer.valueOf(value));
                }

                //price
                value = value(headers, row, "price");
                if (value != null && !value.isBlank()) {
                    bookDto.setPrice(value.trim());
                }

                //publishDate
                value = value(headers, row, "price");
                if (value != null && !value.isBlank()) {
                    bookDto.setPublishDate(value.trim());
                }

                //firstPublishDate
                value = value(headers, row, "firstPublishDate");
                if (value != null && !value.isBlank()) {
                    bookDto.setFirstPublishDate(value.trim());
                }

                //awards
                value = value(headers, row, "awards");
                if (value != null && !value.isBlank()) {
                    bookDto.setAwards(value.trim());
                }

                //ratingsByStars
                value = value(headers, row, "ratingsByStars");
                if (value != null && !value.isBlank()) {
                    bookDto.setRatingsByStars(value.trim());
                }

                //likedPercent
                value = value(headers, row, "likedPercent");
                if (NumberUtils.isCreatable(value)) {
                    bookDto.setLikedPercent(Integer.valueOf(value));
                }

                //setting
                value = value(headers, row, "setting");
                if (value != null && !value.isBlank()) {
                    bookDto.setSetting(value.trim());
                }

                //coverImg
                value = value(headers, row, "coverImg");
                if (value != null && !value.isBlank()) {
                    bookDto.setCoverImg(value.trim());
                }

                //bbeScore
                value = value(headers, row, "bbeScore");
                if (NumberUtils.isCreatable(value)) {
                    bookDto.setBbeScore(Integer.valueOf(value));
                }

                //bbeVotes
                value = value(headers, row, "bbeVotes");
                if (NumberUtils.isCreatable(value)) {
                    bookDto.setBbeVotes(Integer.valueOf(value));
                }


                //Validating Dto
                BookError currentBookError = new BookError();

                if(bookDto.getIsbn() == null) {
                    currentBookError.setBookDto(bookDto);
                    currentBookError.setBookErrorState(BookErrorState.NO_OR_INCORRECT_ISBN);
                    bookErrorsList.add(currentBookError);
                    continue;
                }

                if(bookDto.getTitle() == null) {
                    currentBookError.setBookDto(bookDto);
                    currentBookError.setBookErrorState(BookErrorState.NO_TITLE);
                    bookErrorsList.add(currentBookError);
                    continue;
                }

                if(bookDto.getBookId() == null) {
                    currentBookError.setBookDto(bookDto);
                    currentBookError.setBookErrorState(BookErrorState.NO_BOOKID);
                    bookErrorsList.add(currentBookError);
                    continue;
                }

                if(bookDto.getAuthorList() == null) {
                    currentBookError.setBookDto(bookDto);
                    currentBookError.setBookErrorState(BookErrorState.NO_OR_INCORRECT_AUTHORS);
                    bookErrorsList.add(currentBookError);
                    continue;
                }

                if(bookDtoList.contains(bookDto)) {
                    currentBookError.setBookDto(bookDto);
                    currentBookError.setBookErrorState(BookErrorState.DUPLICATE_ISBN);
                    bookErrorsList.add(currentBookError);
                    continue;
                }

                bookDtoList.add(bookDto);
            }
        }
        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return null;
        }

        Result result = new Result();
        result.setBookDtoList(bookDtoList);
        result.setBookErrorList(bookErrorsList);
        return result;
    }


    private static String value(String[] header,  String[] row, String target) {
        if(!Arrays.asList(header).contains(target)) {
            return null;
        }
        else {
            System.out.println(Arrays.asList(header));
            System.out.println(Arrays.asList(row));
            System.out.println(target);
            System.out.println(Arrays.asList(header).indexOf(target));
            return row[Arrays.asList(header).indexOf(target)];
        }
    }

}
