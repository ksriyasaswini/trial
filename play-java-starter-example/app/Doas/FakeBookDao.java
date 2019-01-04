package Doas;

import module.Book;

import javax.inject.Inject;
import java.util.Collection;
import java.util.*;
import java.util.Optional;

public class FakeBookDao implements BookDao{

     Book fakeBook = new Book(1, "Fake book");

    @Inject
    public FakeBookDao(Book fakeBook) {
        this.fakeBook = fakeBook;
    }

    public Book create(Book book) {

        return fakeBook;
    }


    public Book update(Book book) {

        return  fakeBook;

    }


    public Book delete(Integer id) {

        return fakeBook;

    }


    public Optional<Book> read(Integer id) {

        return Optional.of(fakeBook);

    }

    public Collection<Book> all() {
        return Arrays.asList(fakeBook);
    }

}
