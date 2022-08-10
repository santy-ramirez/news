package com.informatorio.news.controller;

import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.source.SourceBaseDTO;
import com.informatorio.news.dto.source.SourceDTO;
import com.informatorio.news.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
@Validated
@RestController
@RequestMapping("/source")
public class SourceController {


    private SourceService sourceService;
    @Autowired
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
        return new ResponseEntity<>( sourceService.deleteSource(id),HttpStatus.NOT_FOUND) ;
    }
    @GetMapping()
    public ResponseEntity<List<SourceDTO>>  getAllSources(){
        List<SourceDTO> sourceDTOS = sourceService.getAllSource();
        return new ResponseEntity<>( sourceDTOS, HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity <List<SourceDTO>> getForNames(@RequestParam(name = "q") @Valid @Size( min = 3, max=10 ) String q){
        List<SourceDTO> sourceDTOS = sourceService.searchForName(q);
        return new ResponseEntity<>(sourceDTOS,HttpStatus.OK) ;
    }
}
