package com.informatorio.news.service;

import com.informatorio.news.converter.SourceConverter;
import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.source.SourceBaseDTO;
import com.informatorio.news.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceService {
    @Autowired
    private SourceRepository sourceRepository;
    @Autowired
    private SourceConverter sourceConverter;

    public SourceService(SourceRepository sourceRepository,SourceConverter sourceConverter) {
        this.sourceRepository = sourceRepository;
        this.sourceConverter = sourceConverter;
    }

    public SourceBaseDTO crearSource(Source source){
       Source source1 = sourceRepository.save(source);
        return sourceConverter.toDto(source1);
    }
}
