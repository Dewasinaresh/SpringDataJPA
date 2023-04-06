package Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id

    @GeneratedValue(strategy =GenerationType.AUTO)

    private Long id;

    private String Name;
    private String AddressLine1;
    private String City;
    private String State;
     private Long zip;


    private Set<Books> book=new HashSet<>();

    public Publisher() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToMany
    @JoinColumn(name = "publisher_id")

    public Set<Books> getBook() {
        return book;
    }

    public void setBook(Set<Books> book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Publisher(String name, String addressLine1, String city, String state, Long zip) {
        Name = name;
        AddressLine1 = addressLine1;
        City = city;
        State = state;
        this.zip = zip;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setState(String state) {
        State = state;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public String getName() {
        return Name;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public Long getZip() {
        return zip;
    }


    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", AddressLine1='" + AddressLine1 + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", zip=" + zip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }



}
