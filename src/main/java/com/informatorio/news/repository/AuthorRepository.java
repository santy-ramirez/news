package com.informatorio.news.repository;

import com.informatorio.news.domain.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface AuthorRepository  extends JpaRepository<Author,Integer> {



  Author findByName(String name);
  List<Author> findByCreateAt(LocalDate createAt);

}
