package Bootstrap;

import Domain.Author;
import Domain.Books;
import Domain.Publisher;
import Repository.AuthorRepository;
import Repository.BookRepository;
import Repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private final AuthorRepository authorrepository;
    private final BookRepository bookrepository;
    private final PublisherRepository publisherRepository;


    public BootStrap(AuthorRepository authorrepository, BookRepository bookrepository, PublisherRepository publisherRepository) {
        this.authorrepository = authorrepository;
        this.bookrepository = bookrepository;
        this.publisherRepository = publisherRepository;
    }




    @Override
    public void run(String... args) throws Exception {

        Author naresh=new Author("Naresh" ,"Dewasi");
        Books mathsBook=new Books("Kahi Avghad Nahii","1231");
        //Publisher Nirali=new Publisher("Naresh","Shanipar Chouk","Pune","Maharashtra", 12352L);
       Publisher nirali=new Publisher();
       nirali.setName("Nirali");
       nirali.setCity("Pune");
       nirali.setState("Maharashtra");
       publisherRepository.save(nirali);






        naresh.getBook().add(mathsBook);
        mathsBook.getAuthors().add(naresh);
        mathsBook.setPublisher(nirali);
        nirali.getBook().add(mathsBook);



        authorrepository.save(naresh);
        bookrepository.save(mathsBook);
        publisherRepository.save(nirali);

        System.out.println("NO of Books"+bookrepository.count());
        System.out.println("No of Publisher"+publisherRepository.count());




    }
}
