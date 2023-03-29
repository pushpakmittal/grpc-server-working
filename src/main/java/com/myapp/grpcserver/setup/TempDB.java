package com.myapp.grpcserver.setup;

import com.myapp.grpc_server.proto.Author;
import com.myapp.grpc_server.proto.Book;

import java.util.Arrays;
import java.util.List;

public class TempDB {

    public static final List<Author> authors = getAuthorsFromTempDB();
    public static final List<Book> books = getBookFromTempDB();

    private static List<Author> getAuthorsFromTempDB() {
        List<Author> authors = Arrays.asList(
                Author.newBuilder().setAuthorId(1).setBookId(1).setFirstName("pushpak").setLastName("mittal").setGender("Male").build(),
                Author.newBuilder().setAuthorId(2).setBookId(2).setFirstName("mayank").setLastName("mittal").setGender("Male").build(),
                Author.newBuilder().setAuthorId(3).setBookId(3).setFirstName("avik").setLastName("mittal").setGender("Male").build(),
                Author.newBuilder().setAuthorId(4).setBookId(4).setFirstName("aditya").setLastName("mittal").setGender("Male").build(),
                Author.newBuilder().setAuthorId(5).setBookId(5).setFirstName("subhav").setLastName("mittal").setGender("Male").build(),
                Author.newBuilder().setAuthorId(6).setBookId(6).setFirstName("vinni").setLastName("mittal").setGender("Female").build(),
                Author.newBuilder().setAuthorId(7).setBookId(7).setFirstName("rana").setLastName("mittal").setGender("Male").build()
        );
        return authors;
    }

    private static List<Book> getBookFromTempDB() {
        List<Book> books = Arrays.asList(
                Book.newBuilder().setAuthorId(1).setBookId(1).setTitle("maths").setBookPrice(100.00f).setPages(200).build(),
                Book.newBuilder().setAuthorId(2).setBookId(2).setTitle("science").setBookPrice(200.00f).setPages(200).build(),
                Book.newBuilder().setAuthorId(1).setBookId(3).setTitle("hindi").setBookPrice(300.00f).setPages(200).build(),
                Book.newBuilder().setAuthorId(4).setBookId(4).setTitle("english").setBookPrice(400.00f).setPages(200).build(),
                Book.newBuilder().setAuthorId(1).setBookId(5).setTitle("GK").setBookPrice(500.00f).setPages(200).build(),
                Book.newBuilder().setAuthorId(6).setBookId(6).setTitle("sanskrit").setBookPrice(600.00f).setPages(200).build(),
                Book.newBuilder().setAuthorId(1).setBookId(7).setTitle("music").setBookPrice(700.00f).setPages(200).build()
                );
        return books;
    }

}
