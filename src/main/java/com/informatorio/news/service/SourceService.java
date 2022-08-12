package com.informatorio.news.service;

import com.informatorio.news.converter.SourceConverter;
import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.source.SourceBaseDTO;
import com.informatorio.news.dto.source.SourceDTO;
import com.informatorio.news.repository.SourceRepository;
import com.informatorio.news.util.PageCustumerSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


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

    public PageCustumerSource getAllSource(int page,String q){
        Pageable pageable = PageRequest.of(page,3);
      PageCustumerSource pageCustumerSource = new PageCustumerSource();
        if(q != null){
            Page<Source> sources = sourceRepository.findByName(q,pageable);
            pageCustumerSource.setStatus(HttpStatus.OK);
            pageCustumerSource.setPage(sources.getTotalPages());
            pageCustumerSource.setSize(sources.getSize());
            pageCustumerSource.setTotalResult(sources.getTotalElements());
            pageCustumerSource.setContent(sources.getContent().stream().map(source -> sourceConverter.toDto(source)).collect(Collectors.toList()));
        }else{
            Page<Source> sources = sourceRepository.findAll(pageable);
            pageCustumerSource.setStatus(HttpStatus.OK);
            pageCustumerSource.setPage(sources.getTotalPages());
            pageCustumerSource.setSize(sources.getSize());
            pageCustumerSource.setTotalResult(sources.getTotalElements());
            pageCustumerSource.setContent(sources.getContent().stream().map(source -> sourceConverter.toDto(source)).collect(Collectors.toList()));
        }


    return pageCustumerSource;
    }


}
