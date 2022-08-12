package com.informatorio.news.repository;

import com.informatorio.news.domain.Author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface AuthorRepository  extends JpaRepository<Author,Integer> {

  //List<Author> findByCreateAt(LocalDate createAt);
 //Page<Author> findAllByCreateAt(LocalDate createAt, Pageable pageable) ;
 Page<Author> findAllByCreateAtAfter(LocalDate createdAt, Pageable pageable);

 @Query("SELECT a FROM Author a WHERE " +
         "a.name LIKE CONCAT('%',:query, '%')" +
         "Or a.lastname LIKE CONCAT('%', :query, '%')")
 Page<Author> searchAuthor(String query,Pageable pageable);
}
