package module;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.Collection;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer Id;

    @Basic
    @JsonProperty("title")
    private String Title;

    //private Collection<Author> author;

    public Book(Integer id, String title) {
        Id = id;
        Title = title;
    }

    public Book() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
