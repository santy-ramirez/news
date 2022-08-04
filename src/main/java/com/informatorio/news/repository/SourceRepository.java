package com.informatorio.news.repository;

import com.informatorio.news.domain.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source,Integer> {

    @Query("SELECT n FROM Source n WHERE " +
            "n.name LIKE CONCAT('%',:q, '%')")
    List<Source> findByName(String q);
}
