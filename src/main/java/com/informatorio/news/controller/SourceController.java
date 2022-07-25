package com.informatorio.news.controller;

import com.informatorio.news.domain.Source;
import com.informatorio.news.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public class SourceController {
    @Autowired
    private SourceRepository sourceRepository;

    @PostMapping
    public Source createSource(@RequestBody  Source source){
        return sourceRepository.save(source);
    }
}
