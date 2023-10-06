package com.example.demo10.repository;

import com.example.demo10.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

/* pobieranie wszystkich książek autora*/
    @Query("SELECT a FROM BookModel a WHERE a.author = :author")
    List<BookModel> findAllBooksByAuthor(@Param("author") String author);

    /*Pobieranie książek wydanych w danym roku*/
    @Query("SELECT y FROM BookModel y WHERE y.yearOfIssue = :yearOfIssue")
    List<BookModel> findBooksByYearOfIssue(@Param("yearOfIssue")Integer yearOfIssue);
//    List<BookModel> findByYearOfIssueGreaterThan(Integer year);
    /*Pobieranie książek po określonym tytule*/
    @Query("SELECT t FROM BookModel t WHERE t.title = :title ")
    List<BookModel> findBooksByTitle(@Param("title")String title);

    /*Pobieranie wszystkich książek, których autor rozpoczyna się od danej litery*/
    List<BookModel> findByAuthorStartingWith(String letter);
/*Pobieranie książek wydanych przed określonym rokiem*/
    List<BookModel> findByYearOfIssueBefore(Integer year);
}
