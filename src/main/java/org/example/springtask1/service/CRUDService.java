//package org.example.springtask1.service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.springtask1.persistence.entity.*;
//import org.example.springtask1.persistence.entity.Character;
//import org.example.springtask1.persistence.repository.*;
//import org.example.springtask1.service.dto.csvreader.*;
//import org.example.springtask1.service.mapper.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//@RequiredArgsConstructor
////@AllArgsConstructor
//public class CRUDService {
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
//    private final BookMapper bookMapper;
//    private final GenreMapper genreMapper;
//    private final AuthorMapper authorMapper;
//    private final CharacterMapper characterMapper;
//    private final SettingMapper settingMapper;
//    private final AwardMapper awardMapper;
//    private final LanguageMapper languageMapper;
//    private final PublisherMapper publisherMapper;
//
//
//
//    @Autowired
//    public FilterService(BookRepository bookRepository,
//                         AuthorRepository authorRepository,
//                         PublisherRepository publisherRepository,
//                         GenreRepository genreRepository,
//                         CharacterRepository characterRepository,
//                         SettingRepository settingRepository,
//                         AwardRepository awardRepository,
//                         LanguageRepository languageRepository,
//                         BookLanguageRepository bookLanguageRepository,
//                         BookAuthorRepository bookAuthorRepository,
//                         BookGenreRepository bookGenreRepository,
//                         BookCharacterRepository bookCharacterRepository,
//                         BookSettingRepository bookSettingRepository,
//                         BookAwardRepository bookAwardRepository,
//                         GenreMapper genreMapper,
//                         AuthorMapper authorMapper,
//                         LanguageMapper languageMapper,
//                         CharacterMapper characterMapper,
//                         SettingMapper settingMapper,
//                         PublisherMapper publisherMapper,
//                         AwardMapper awardMapper,
//                         BookMapper bookMapper) {
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
//        this.bookMapper = bookMapper;
//        this.genreMapper = genreMapper;
//        this.authorMapper = authorMapper;
//        this.languageMapper = languageMapper;
//        this.characterMapper = characterMapper;
//        this.settingMapper = settingMapper;
//        this.awardMapper = awardMapper;
//        this.publisherMapper = publisherMapper;
//    }
//
//    public List<BookDto> getBooksByGenre(String genre) {
//        //method 1
////        List<BookGenre> bookGenreList = bookGenreRepository.findAll();
////        List<BookDto> result = new ArrayList<>();
////
////        for (BookGenre bg: bookGenreList) {
////            if (bg.getGenre().getGenre().equals(genre)) {
////                result.add(bookMapper.mapToDto(bg.getBook()));
////            }
////        }
////
////        return result;
//
//        //method 2
////        List<Book> bookList = bookGenreRepository.findBooksByGenreName(genre);
////
////        return bookMapper.mapToDtos(bookList);
//
//        List<BookDto> result = new ArrayList<>();
//        Genre genreFound = genreRepository.findByGenre(genre);
//
//        if(genreFound == null) {
//            return result;
//        }
//
//        List<BookGenre> bookList = genreFound.getBooks();
//        for (BookGenre bookGenre : bookList) {
//            result.add(bookMapper.mapToDto(bookGenre.getBook()));
//        }
//        return result;
//    }
//    public List<BookDto> getBooksByCharacter(String character) {
//
//        List<BookDto> result = new ArrayList<>();
//        Character characterFound = characterRepository.findByName(character);
//
//        if(characterFound == null) {
//            return result;
//        }
//
//        List<BookCharacter> bookList = characterFound.getBooks();
//        for (BookCharacter bookCharacter : bookList) {
//            result.add(bookMapper.mapToDto(bookCharacter.getBook()));
//        }
//        return result;
//    }
//    public List<BookDto> getBooksBySetting(String setting) {
//
//        List<BookDto> result = new ArrayList<>();
//        Setting settingFound = settingRepository.findBySetting(setting);
//
//        if(settingFound == null) {
//            return result;
//        }
//
//        List<BookSetting> bookList = settingFound.getBooks();
//        for (BookSetting bookSetting : bookList) {
//            result.add(bookMapper.mapToDto(bookSetting.getBook()));
//        }
//        return result;
//    }
//
//    public List<BookDto> getBooksByLanguage(String language, String additional) {
//
//        List<BookDto> result = new ArrayList<>();
//        List<Language> languageFound;
//        if(additional != null) {
//            languageFound = languageRepository.findByLanguageAndAdditional(language, additional);
//        }
//        else {
//            languageFound = languageRepository.findByLanguage(language);
//
//        }
//
//        if(languageFound == null) {
//            return result;
//        }
//
//        List<BookLanguage> bookList = new ArrayList<>();
//
//        for (Language language1 : languageFound) {
//            bookList.addAll(language1.getBooks());
//        }
//
//        for (BookLanguage bookLanguage: bookList) {
//            result.add(bookMapper.mapToDto(bookLanguage.getBook()));
//        }
//        return result;
//    }
//
//    public List<BookDto> getBooksByAuthor(String author) {
//        List<BookDto> result = new ArrayList<>();
//        Author authorFound = authorRepository.findByName(author);
//
//        if(authorFound == null) {
//            return result;
//        }
//
//        List<BookAuthor> bookList = authorFound.getBooks();
//
//        for (BookAuthor bookAuthor : bookList) {
//            result.add(bookMapper.mapToDto(bookAuthor.getBook()));
//        }
//        return result;
//    }
//
//    public List<BookDto> getBooksByPublisher(String publisher) {
//        List<BookDto> result = new ArrayList<>();
//        Publisher publisherFound = publisherRepository.findByName(publisher);
//
//        if(publisherFound == null) {
//            return result;
//        }
//
//        List<Book> bookList = publisherFound.getBooks();
//
//        return bookMapper.mapToDtos(bookList);
//    }
//
//    public List<BookDto> getBooksByAward(String award, Integer year) {
//        List<BookDto> result = new ArrayList<>();
//        List<Award> awardsFound;
////        if(year != null) {
////            awardsFound = awardRepository.findByAwardAndYear(award, year);
////        }
////        else {
//        awardsFound = awardRepository.findByAward(award);
//
////        }
//
//        if(awardsFound == null) {
//            return result;
//        }
//
//        List<BookAward> bookList = new ArrayList<>();
//
//        for (Award award1 : awardsFound) {
//            bookList.addAll(award1.getBooks());
//        }
//
//        for (BookAward bookAward : bookList) {
//            result.add(bookMapper.mapToDto(bookAward.getBook()));
//        }
//        return result;
//    }
//
//    public BookDto getBookByIsbn(Long isbn) {
//        Book book = bookRepository.findByIsbn(isbn);
//        return bookMapper.mapToDto(book);
//    }
//
//    public List<BookDto> getBookByTitle(String title) {
//        List<Book> books = bookRepository.findByTitle(title);
//
//        return bookMapper.mapToDtos(books);
//    }
//
//    public BookDto getBook(Long id) {
//        Optional<Book> book = bookRepository.findById(id);
//
//        if(book.isPresent()) {
//            return bookMapper.mapToDto(book.get());
//        }
//        else {
//            return null;
//        }
//    }
//
//    public GenreDto getGenre(Long id) {
//        Optional<Genre> genre = genreRepository.findById(id);
//
//        if(genre.isPresent()) {
//            return genreMapper.mapToDto(genre.get());
//        }
//        else {
//            return null;
//        }
//    }
//
//    public LanguageDto getLanguage(Long id) {
//        Optional<Language> language = languageRepository.findById(id);
//
//        if(language.isPresent()) {
//            return languageMapper.mapToDto(language.get());
//        }
//        else {
//            return null;
//        }
//    }
//
//    public AuthorDto getAuthor(Long id) {
//        Optional<Author> author = authorRepository.findById(id);
//
//        if(author.isPresent()) {
//            return authorMapper.mapToDto(author.get());
//        }
//        else {
//            return null;
//        }
//    }
//
//    public PublisherDto getPublisher(Long id) {
//        Optional<Publisher> publisher = publisherRepository.findById(id);
//
//        if(publisher.isPresent()) {
//            return publisherMapper.mapToDto(publisher.get());
//        }
//        else {
//            return null;
//        }
//    }
//
//    public SettingDto getSetting(Long id) {
//        Optional<Setting> setting = settingRepository.findById(id);
//
//        if(setting.isPresent()) {
//            return settingMapper.mapToDto(setting.get());
//        }
//        else {
//            return null;
//        }
//    }
//    public AwardDto getAward(Long id) {
//        Optional<Award> award = awardRepository.findById(id);
//
//        if(award.isPresent()) {
//            return awardMapper.mapToDto(award.get());
//        }
//        else {
//            return null;
//        }
//    }
//    public CharacterDto getCharacter(Long id) {
//        Optional<Character> character = characterRepository.findById(id);
//
//        if(character.isPresent()) {
//            return characterMapper.mapToDto(character.get());
//        }
//        else {
//            return null;
//        }
//    }
//
//    public AuthorDto createAuthor(Long id) {
//        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
//        return authorMapper.mapToDto(author);
//    }
//
////    public AuthorDto updateAuthor(Long id) {
////    }
////
////    public AuthorDto deleteAuthor(Long id) {
////    }
//
//
//    public BookDto createBook(BookDto bookDto) {
//        Book book = bookMapper.mapFromDto(bookDto);
//        bookRepository.save(book);
//
//        return bookMapper.mapToDto(book);
//    }
//
//    public BookDto updateBook(Long id, BookDto bookDto) {
//    }
//
//    public BookDto deleteBook(Long id) {
//    }
//
//
//}
