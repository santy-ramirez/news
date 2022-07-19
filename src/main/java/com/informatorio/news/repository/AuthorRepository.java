package com.informatorio.news.repository;

import com.informatorio.news.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository  extends JpaRepository<Author,Integer> {

}
