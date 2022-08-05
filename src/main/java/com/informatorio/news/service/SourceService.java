package com.informatorio.news.service;

import com.informatorio.news.converter.SourceConverter;
import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.source.SourceBaseDTO;
import com.informatorio.news.dto.source.SourceDTO;
import com.informatorio.news.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SourceService {
 
    private SourceRepository sourceRepository;

    private SourceConverter sourceConverter;
    @Autowired
    public SourceService(SourceRepository sourceRepository,SourceConverter sourceConverter) {
        this.sourceRepository = sourceRepository;
        this.sourceConverter = sourceConverter;
    }

    public SourceBaseDTO createSource(Source source){
       Source source1 = sourceRepository.save(source);
        return sourceConverter.toSourceBaseDTO(source1);
    }

    public SourceBaseDTO updateSource( Integer id, Source source){
      Source sourceSelect = sourceRepository.findById(id).orElse(source);
      sourceSelect.setId(id);
      sourceSelect.setName(source.getName());
      sourceSelect.setCode(source.getCode());
      sourceSelect.setCreateAt(source.getCreateAt());
     Source sourceUpdate = sourceRepository.save(sourceSelect);
      return sourceConverter.toSourceBaseDTO(sourceUpdate);
    }

    public String deleteSource(Integer id){
        sourceRepository.deleteById(id);
        return "delete source with id number:" + id;
    }

    public List<SourceBaseDTO> getAllSource(){
        List<Source> sources = sourceRepository.findAll();
        List<SourceBaseDTO> sourceBaseDTOS = sources.stream().map(source -> sourceConverter.toSourceBaseDTO(source)).collect(Collectors.toList());
    return sourceBaseDTOS;
    }
    public List<SourceDTO> getSourceWithArticle(){
        List<Source> sources = sourceRepository.findAll();
        List<SourceDTO> sourceDTOS = sources.stream().map(source -> sourceConverter.toDto(source)).collect(Collectors.toList());
        return sourceDTOS;
    }
    public List<SourceBaseDTO> searchForName(String q){
        List<Source> sources = sourceRepository.findByName(q);
        return sources.stream().map(source -> sourceConverter.toSourceBaseDTO(source)).collect(Collectors.toList());
    }
}
