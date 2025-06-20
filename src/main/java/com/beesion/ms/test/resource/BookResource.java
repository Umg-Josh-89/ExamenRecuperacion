package com.beesion.ms.test.resource;

import java.util.List;

import com.beesion.ms.model.Book;
import com.beesion.ms.test.repository.BookRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/libros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository repository;

    @GET
    public List<Book> getAllBooks() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Libro no encontrado"));
    }

    @POST
    @Transactional
    public Response createBook(Book book) {
        repository.persist(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Book updateBook(@PathParam("id") Long id, Book updated) {
        Book book = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Libro no encontrado"));

        book.setTitle(updated.getTitle());
        book.setAuthor(updated.getAuthor());
        book.setNumPages(updated.getNumPages());
        book.setPubDate(updated.getPubDate());
        book.setDescription(updated.getDescription());

        return book;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteBook(@PathParam("id") Long id) {
        boolean deleted = repository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Libro no encontrado");
        }
        return Response.noContent().build();
    }
}
