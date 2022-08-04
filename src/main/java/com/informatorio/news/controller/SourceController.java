package com.informatorio.news.controller;

import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.source.SourceBaseDTO;
import com.informatorio.news.dto.source.SourceDTO;
import com.informatorio.news.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <SourceBaseDTO> createSource(@RequestBody  Source source){
        return new ResponseEntity<>(sourceService.createSource(source),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity <SourceBaseDTO> updatesSources(@PathVariable Integer id,@RequestBody Source source){
        SourceBaseDTO sourceUpdate = sourceService.updateSource(id,source);
        return new ResponseEntity<>(sourceUpdate,HttpStatus.CREATED) ;
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSources(@PathVariable Integer id){
        sourceService.deleteSource(id);
        return new ResponseEntity<>("deleted source number "+id,HttpStatus.NOT_FOUND) ;
    }
    @GetMapping()
    public ResponseEntity<List<SourceBaseDTO>>  getAllSources(){
        List<SourceBaseDTO> sourceBaseDTOS = sourceService.getAllSource();
        return new ResponseEntity<>( sourceBaseDTOS, HttpStatus.OK);
    }
    @GetMapping("all")
    public ResponseEntity<List<SourceDTO>> getAllSourceWithArticles(){
        List<SourceDTO> sourceDTOS = sourceService.getSourceWithArticle();
        return new ResponseEntity<List<SourceDTO>>(sourceDTOS,HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity <List<SourceBaseDTO>> getForNames(@RequestParam String q){
        List<SourceBaseDTO> sourceBaseDTOS = sourceService.searchForName(q);
        return new ResponseEntity<>(sourceBaseDTOS,HttpStatus.OK) ;
    }
}
