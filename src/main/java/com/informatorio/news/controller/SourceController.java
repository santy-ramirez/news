package com.informatorio.news.controller;

import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.source.SourceBaseDTO;
import com.informatorio.news.dto.source.SourceDTO;
import com.informatorio.news.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @PostMapping
    public SourceBaseDTO createSource(@RequestBody  Source source){
        return sourceService.createSource(source);
    }

    @PutMapping("{id}")
    public  SourceBaseDTO updatesSources(@PathVariable Integer id,@RequestBody Source source){
        SourceBaseDTO sourceUpdate = sourceService.updateSource(id,source);
        return sourceUpdate;
    }


    @DeleteMapping("{id}")
    public String deleteSources(@PathVariable Integer id){
        sourceService.deleteSource(id);
        return "deleted source number "+id;
    }
    @GetMapping()
    public List<SourceBaseDTO> getAllSources(){
        List<SourceBaseDTO> sourceBaseDTOS = sourceService.getAllSource();
        return sourceBaseDTOS;
    }
    @GetMapping("all")
    public List<SourceDTO> getAllSourceWithArticles(){
        List<SourceDTO> sourceDTOS = sourceService.getSourceWithArticle();
        return  sourceDTOS;
    }

}
