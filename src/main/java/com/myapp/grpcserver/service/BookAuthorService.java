package com.myapp.grpcserver.service;

import com.myapp.grpc_server.proto.Author;
import com.myapp.grpc_server.proto.Book;
import com.myapp.grpc_server.proto.BookAuthorServiceGrpc;
import com.myapp.grpcserver.setup.TempDB;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookAuthorService extends BookAuthorServiceGrpc.BookAuthorServiceImplBase {

    @Override
    public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
        TempDB.authors.stream()
                .filter(author -> author.getAuthorId() == request.getAuthorId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getBooksByAuthor(Author author, StreamObserver<Book> responseObserver) {
        TempDB.books
                .stream()
                .filter(book -> book.getAuthorId() == author.getAuthorId())
                .forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Book> getExpensiveBook(StreamObserver<Book> responseObserver) {
        return new StreamObserver<Book>() {

            Book expensiveBook = null;
            float price = 0;

            @Override
            public void onNext(Book book) {
                if (book.getBookPrice() > price) {
                    price = book.getBookPrice();
                    expensiveBook = book;
                }
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(expensiveBook);
                responseObserver.onCompleted();
            }
        };
    }
}
