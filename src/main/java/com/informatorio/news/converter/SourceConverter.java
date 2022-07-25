package com.informatorio.news.converter;

import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.SourceDTO;
import org.springframework.stereotype.Component;

@Component
public class SourceConverter {

    public SourceDTO toDto(Source source){
        return new SourceDTO(source.getId(),source.getName(),source.getCode(),source.getCreateAt());
    }
}
