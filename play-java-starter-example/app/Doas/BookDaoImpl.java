package Doas;

import module.Book;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class BookDaoImpl implements BookDao{

    final JPAApi jpaApi;

    @Inject
    public BookDaoImpl(JPAApi jpaApi) {

        this.jpaApi = jpaApi;

    }


    public Book create(Book book) {

        if(null == book) {
            throw new IllegalArgumentException("Book must be provided");
        }

        jpaApi.em().persist(book);

        return book;

    }


    public Book update(Book book) {

        if(null == book) {
            throw new IllegalArgumentException("Book must be provided");
        }

        if(null == book.getId()) {
            throw new IllegalArgumentException("ID must be provided");
        }

        final Book existingbook=jpaApi.em().find(Book.class , book.getId());

        if(null == existingbook) {
            return  null;
        }
        existingbook.setTitle(book.getTitle());
        return  existingbook;

    }


    public Book delete(Integer id) {

        if(null == id) {
            throw new IllegalArgumentException("ID must be provided");
        }

        final Book existingbook = jpaApi.em().find(Book.class, id);
        if (null == existingbook) {
            return null;
        }


        jpaApi.em().remove(existingbook);

        return existingbook;

    }


    public Optional<Book> read(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("ID must be provided");
        }

        final Book book=jpaApi.em().find(Book.class , id);

        return book!=null ? Optional.of(book) : Optional.empty() ;

    }


    public Collection<Book> all() {

        TypedQuery<Book> query = jpaApi.em().createQuery("SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();

        return books;

    }
}
