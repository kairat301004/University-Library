package kg.megalab.universitylibrary.controller;

import kg.megalab.universitylibrary.model.Book;
import kg.megalab.universitylibrary.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LibraryController {
    private final BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<String> bookTitles = bookRepository.findAll().stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        model.addAttribute("bookTitles", bookTitles);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "query") String query, Model model) {
        List<Book> searchResult = bookRepository.findAll().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        model.addAttribute("books", searchResult);
        return "index";
    }
}
