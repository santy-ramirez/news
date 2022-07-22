package com.informatorio.news.repository;

import com.informatorio.news.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ArticleRepository  extends JpaRepository<Article,Integer> {


}
