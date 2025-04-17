//package org.example.springtask1.service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.springtask1.persistence.entity.*;
//import org.example.springtask1.persistence.entity.Character;
//import org.example.springtask1.service.additional.BookError;
//import org.example.springtask1.service.additional.BookErrorState;
//import org.example.springtask1.service.additional.Result;
//import org.example.springtask1.service.dto.*;
//import org.example.springtask1.service.manager.CSVManager;
//import org.example.springtask1.persistence.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.*;
//
//@Service
//@RequiredArgsConstructor
////@AllArgsConstructor
//public class CSVUploadService {
//
//    private final BookRepository bookRepository;
//    private final AuthorRepository authorRepository;
//    private final PublisherRepository publisherRepository;
//    private final GenreRepository genreRepository;
//    private final LanguageRepository languageRepository;
//    private final CharacterRepository characterRepository;
//    private final SettingRepository settingRepository;
//    private final AwardRepository awardRepository;
//    private final BookAuthorRepository bookAuthorRepository;
//    private final BookGenreRepository bookGenreRepository;
//    private final BookLanguageRepository bookLanguageRepository;
//    private final BookCharacterRepository bookCharacterRepository;
//    private final BookSettingRepository bookSettingRepository;
//    private final BookAwardRepository bookAwardRepository;
//
//    @Autowired
//    public CSVUploadService(BookRepository bookRepository,
//                            AuthorRepository authorRepository,
//                            PublisherRepository publisherRepository,
//                            GenreRepository genreRepository,
//                            CharacterRepository characterRepository,
//                            SettingRepository settingRepository,
//                            AwardRepository awardRepository,
//                            LanguageRepository languageRepository,
//                            BookLanguageRepository bookLanguageRepository,
//                            BookAuthorRepository bookAuthorRepository,
//                            BookGenreRepository bookGenreRepository,
//                            BookCharacterRepository bookCharacterRepository,
//                            BookSettingRepository bookSettingRepository,
//                            BookAwardRepository bookAwardRepository) {
//        this.bookRepository = bookRepository;
//        this.authorRepository = authorRepository;
//        this.publisherRepository = publisherRepository;
//        this.genreRepository = genreRepository;
//        this.characterRepository = characterRepository;
//        this.settingRepository = settingRepository;
//        this.awardRepository = awardRepository;
//        this.languageRepository = languageRepository;
//        this.bookLanguageRepository = bookLanguageRepository;
//        this.bookGenreRepository = bookGenreRepository;
//        this.bookAuthorRepository = bookAuthorRepository;
//        this.bookCharacterRepository = bookCharacterRepository;
//        this.bookSettingRepository = bookSettingRepository;
//        this.bookAwardRepository = bookAwardRepository;
//    }
//
//    public Result upload(MultipartFile file) {
//
//        List<Author> authorList = authorRepository.findAll();
//        List<Genre> genreList = genreRepository.findAll();
//        List<Setting> settingList = settingRepository.findAll();
//        List<Character> characterList = characterRepository.findAll();
//        List<Award> awardList = awardRepository.findAll();
//        List<Language> languageList = languageRepository.findAll();
//        List<Publisher> publisherList = publisherRepository.findAll();
//        List<Book> bookList = bookRepository.findAll();
//
//        List<Book> bookNewList = new ArrayList<>();
//        List<Author> authorNewList = new ArrayList<>();
//        List<Genre> genreNewList = new ArrayList<>();
//        List<Character> characterNewList = new ArrayList<>();
//        List<Setting> settingNewList = new ArrayList<>();
//        List<Award> awardNewList = new ArrayList<>();
//        List<Language> languageNewList = new ArrayList<>();
//        List<Publisher> publisherNewList = new ArrayList<>();
//        List<BookLanguage> bookLanguageNewList = new ArrayList<>();
//        List<BookAuthor> bookAuthorNewList = new ArrayList<>();
//        List<BookGenre> bookGenreNewList = new ArrayList<>();
//        List<BookCharacter> bookCharacterNewList = new ArrayList<>();
//        List<BookSetting> bookSettingNewList = new ArrayList<>();
//        List<BookAward> bookAwardNewList = new ArrayList<>();
//
//
//        Result result = CSVManager.getBookList(file);
//
//        if(result == null) {
//            return null;
//        }
//
//        List<BookError> bookErrorList = result.getBookErrorList();
//        List<BookDto> bookDtoList = result.getBookDtoList();
//
//        for (BookDto dto : bookDtoList) {
//            Book book = new Book();
//
//            book.setIsbn(dto.getIsbn());
//
//            if(bookList.contains(book)) {
//                BookError bookError = new BookError();
//                bookError.setBookDto(dto);
//                bookError.setBookErrorState(BookErrorState.DUPLICATE_ISBN);
//                bookErrorList.add(bookError);
//                bookDtoList.remove(dto);
//                continue;
//            }
//
//            List<BookAuthor> currentBookAuthorList = new ArrayList<>();
//            List<BookGenre> currentBookGenreList = new ArrayList<>();
//            List<BookCharacter> currentBookCharacterList = new ArrayList<>();
//            List<BookSetting> currentBookSettingList = new ArrayList<>();
//            List<BookAward> currentBookAwardList = new ArrayList<>();
//            List<BookLanguage> currentBookLanguageList = new ArrayList<>();
//
//            for (AuthorDto authorDto : dto.getAuthorList()) {
//                Author author = new Author();
//                author.setName(authorDto.getName());
//                BookAuthor bookAuthor = new BookAuthor();
//                bookAuthor.setBook(book);
//                bookAuthor.setAuthorRole(authorDto.getRole());
//
//                if (!authorList.contains(author)) {
//                    authorNewList.add(author);
//                    authorList.add(author);
//                    bookAuthor.setAuthor(author);
//                }
//                else {
//                    bookAuthor.setAuthor(authorList.get(authorList.indexOf(author)));
//                }
//
//                bookAuthorNewList.add(bookAuthor);
//                currentBookAuthorList.add(bookAuthor);
//
//            }
//
//            for (GenreDto genreDto : dto.getGenreList()) {
//                Genre genre = new Genre();
//                genre.setGenre(genreDto.getGenre());
//                BookGenre bookGenre = new BookGenre();
//                bookGenre.setBook(book);
//
//                if (!genreList.contains(genre)) {
//                    genreNewList.add(genre);
//                    genreList.add(genre);
//                    bookGenre.setGenre(genre);
//                }
//                else {
//                    bookGenre.setGenre(genreList.get(genreList.indexOf(genre)));
//                }
//
//                bookGenreNewList.add(bookGenre);
//                currentBookGenreList.add(bookGenre);
//            }
//
//            for (CharacterDto characterDto : dto.getCharacterList()) {
//                Character character = new Character();
//                character.setName(characterDto.getName());
//                BookCharacter bookCharacter = new BookCharacter();
//                bookCharacter.setBook(book);
//
//                if (!characterList.contains(character)) {
//                    characterNewList.add(character);
//                    characterList.add(character);
//                    bookCharacter.setCharacter(character);
//                }
//                else {
//                    bookCharacter.setCharacter(characterList.get(characterList.indexOf(character)));
//                }
//
//                bookCharacterNewList.add(bookCharacter);
//                currentBookCharacterList.add(bookCharacter);
//            }
//
//            for (SettingDto settingDto : dto.getSettingList()) {
//                Setting setting = new Setting();
//                setting.setSetting(settingDto.getSetting());
//                BookSetting bookSetting = new BookSetting();
//                bookSetting.setBook(book);
//
//                if (!settingList.contains(setting)) {
//                    settingNewList.add(setting);
//                    settingList.add(setting);
//                    bookSetting.setSetting(setting);
//                }
//                else {
//                    bookSetting.setSetting(settingList.get(settingList.indexOf(setting)));
//                }
//
//                bookSettingNewList.add(bookSetting);
//                currentBookSettingList.add(bookSetting);
//            }
//
//            for (AwardDto awardDto : dto.getAwardList()) {
//                Award award = new Award();
//                award.setAward(awardDto.getAward());
//                award.setYear(awardDto.getYear());
//                BookAward bookAward = new BookAward();
//                bookAward.setBook(book);
//
//                if (!awardList.contains(award)) {
//                    awardNewList.add(award);
//                    awardList.add(award);
//                    bookAward.setAward(award);
//                }
//                else {
//                    bookAward.setAward(awardList.get(awardList.indexOf(award)));
//                }
//
//                bookAwardNewList.add(bookAward);
//                currentBookAwardList.add(bookAward);
//            }
//
//            for (LanguageDto languageDto : dto.getLanguageList()) {
//                Language language = new Language();
//                language.setLanguage(languageDto.getLanguage());
//                language.setAdditional(languageDto.getAdditional());
//                BookLanguage bookLanguage = new BookLanguage();
//                bookLanguage.setBook(book);
//
//                if (!languageList.contains(language)) {
//                    languageNewList.add(language);
//                    languageList.add(language);
//                    bookLanguage.setLanguage(language);
//                }
//                else {
//                    bookLanguage.setLanguage(languageList.get(languageList.indexOf(language)));
//                }
//
//                bookLanguageNewList.add(bookLanguage);
//                currentBookLanguageList.add(bookLanguage);
//            }
//
//            Publisher publisher = null;
//
//            if(dto.getPublisher() != null) {
//                publisher = new Publisher();
//                publisher.setName(dto.getPublisher().getName());
//
//                if (!publisherList.contains(publisher)) {
//                    publisherNewList.add(publisher);
//                    publisherList.add(publisher);
//                }
//                else {
//                    publisher = publisherList.get(publisherList.indexOf(publisher));
//                }
//            }
//
//            book.setTitle(dto.getTitle());
//            book.setBookId(dto.getBookId());
//            book.setSeriesName(dto.getSeries());
//            book.setSeriesNumber(dto.getSeriesNumber());
//            book.setBookFormat(dto.getBookFormat());
//            book.setDescription(dto.getDescription());
//            book.setBbeScore(dto.getBbeScore());
//            book.setBbeVotes(dto.getBbeVotes());
//            book.setCoverImg(dto.getCoverImg());
//            book.setEdition(dto.getEdition());
//            book.setFirstPublishDate(dto.getFirstPublishDate());
//            book.setPublishDate(dto.getPublishDate());
//            book.setNumRatings(dto.getNumRatings());
//            book.setRatingsByStars(dto.getRatingsByStars());
//            book.setRating(dto.getRating());
//            book.setLikedPercent(dto.getLikedPercent());
//            book.setPrice(dto.getPrice());
//            book.setPages(dto.getPages());
//            book.setPublisher(publisher);
//            book.setAuthors(currentBookAuthorList);
//            book.setGenres(currentBookGenreList);
//            book.setCharacters(currentBookCharacterList);
//            book.setSetting(currentBookSettingList);
//            book.setAwards(currentBookAwardList);
//            book.setLanguages(currentBookLanguageList);
//
//            bookNewList.add(book);
//            bookList.add(book);
//
//        }
//
//        authorRepository.saveAll(authorNewList);
//        genreRepository.saveAll(genreNewList);
//        characterRepository.saveAll(characterNewList);
//        settingRepository.saveAll(settingNewList);
//        awardRepository.saveAll(awardNewList);
//        languageRepository.saveAll(languageNewList);
//        publisherRepository.saveAll(publisherNewList);
//        bookRepository.saveAll(bookNewList);
//        bookAuthorRepository.saveAll(bookAuthorNewList);
//        bookGenreRepository.saveAll(bookGenreNewList);
//        bookCharacterRepository.saveAll(bookCharacterNewList);
//        bookSettingRepository.saveAll(bookSettingNewList);
//        bookAwardRepository.saveAll(bookAwardNewList);
//        bookLanguageRepository.saveAll(bookLanguageNewList);
//
//        Result returnResult = new Result();
//        returnResult.setBookDtoList(bookDtoList);
//        returnResult.setBookErrorList(bookErrorList);
//
//        return returnResult;
//    }
//}
