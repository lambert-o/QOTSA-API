package com.qotsa.api.controller;

import com.qotsa.api.domain.model.Album;
import com.qotsa.api.service.RandomAlbumService;
import java.sql.Date;
import java.sql.Time;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AlbumsControllerTest {

  @Mock
  RandomAlbumService randomAlbumService;

  @Spy
  ModelMapper modelMapper;

  @InjectMocks
  AlbumsController albumsController;

  @Test
  void shouldReturnValidResponseWhenRequestValid() {
    // given
    Album album = new Album("Queens of the Stone Age", 11, Time.valueOf("00:46:27"), Date.valueOf("1998-09-22"),
            "https://open.spotify.com/album/0PSTqZ8cInMb1Wr68Uqdwp?si=7WqTEOlNTKaCdfhxeAf8Vg", new String[]{"Regular John"});
    given(randomAlbumService.getRandomAlbum()).willReturn(album);

    // when
    var response = albumsController.random();

    // then
    assertEquals("Queens of the Stone Age", response.getBody().getTitle());
  }
}
