package com.informatorio.news.controller;

import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.SourceDTO;
import com.informatorio.news.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @PostMapping
    public SourceDTO createSource(@RequestBody  Source source){
        return sourceService.crearSource(source);
    }
}
