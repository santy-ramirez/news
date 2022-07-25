package com.informatorio.news.repository;

import com.informatorio.news.domain.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface AuthorRepository  extends JpaRepository<Author,Integer> {

  List<Author> findByCreateAt(LocalDate createAt);

 @Query("SELECT p FROM Author p WHERE " +
         "p.name LIKE CONCAT('%',:query, '%')" +
         "Or p.lastname LIKE CONCAT('%', :query, '%')")
 List<Author> searchAuthor(String query);
}
