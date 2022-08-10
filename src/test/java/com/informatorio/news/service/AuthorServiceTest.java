package com.informatorio.news.service;

import com.informatorio.news.converter.AuthorConverter;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.author.AuthorDTO;
import com.informatorio.news.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {
@Mock
private AuthorRepository authorRepository;
@Mock
private AuthorConverter authorConverter;
@InjectMocks
private AuthorService authorService;


    @Test
    void when_call_method_createAuthor_to_saved_correct_in_dataBase() {
        Author author = new Author();
        author.setId(1);
        author.setName("santi");
        AuthorBaseDTO authorBaseDTO = new AuthorBaseDTO();
        authorBaseDTO.setName("santi");

        when(authorService.createAuthor(author)).thenReturn(new AuthorBaseDTO("santi","Ramirez", LocalDate.now()));


        assertEquals(authorService.createAuthor(author).getName(),authorBaseDTO.getName());

    }


    @Test
    void when_call_metodUpdate_then_result_object_updated() {
        Author author1 = new Author();
                author1.setId(1);
                author1.setName("santi");

        AuthorBaseDTO authorBaseDTO = new AuthorBaseDTO();
        authorBaseDTO.setName("santiupdate");
        authorBaseDTO.setLastname("ramirez");
      when(authorService.updateAuthor(1, author1)).thenReturn( authorBaseDTO);

      AuthorBaseDTO authorTest = authorService.updateAuthor(1,author1);


            assertEquals(authorTest.getName(),authorBaseDTO.getName());


    }
}