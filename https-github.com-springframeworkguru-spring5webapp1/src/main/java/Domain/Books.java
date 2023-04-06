package Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Title;
    private String Isbn;

    @ManyToMany
    @JoinTable(name ="autor_book",joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors =new HashSet<>();

@ManyToOne
    private Publisher publisher;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    private long id ;

    public Books() {
    }

    public Books(String title, String isbn) {
        Title = title;
        Isbn = isbn;

    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return Title;
    }

    public String getIsbn() {
        return Isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Title='" + Title + '\'' +
                ", Isbn='" + Isbn + '\'' +
                ", authors=" + authors +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        return id == books.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
