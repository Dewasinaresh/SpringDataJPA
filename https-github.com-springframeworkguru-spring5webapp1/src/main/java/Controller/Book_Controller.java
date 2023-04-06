package Controller;

import Repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Book_Controller {
    private final BookRepository bookRepository;

    public Book_Controller(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/Book")
    public String getBook(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "Books/list";

    }

}
