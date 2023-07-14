package com.qotsa.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import com.qotsa.api.domain.model.Song;
import com.qotsa.api.service.RandomSongService;
import java.sql.Time;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class SongsControllerTest {

  @Mock
  RandomSongService randomSongService;

  @Spy
  ModelMapper modelMapper;

  @InjectMocks
  SongsController songsController;

  @Test
  void shouldReturnValidResponseWhenRequestValid() {
    // given
    String[] artists = new String[]{"Josh Homme", "Alfredo Hernandez", "John McBain"};
    Song song = new Song("Regular John", "Queens of the Stone Age", Time.valueOf("00:04:35"), "Who are you girl?...",
            artists, "https://open.spotify.com/track/0R0m9mTXa81zp1qtcU3dSR?si=3f761edcdc2b4279");
    given(randomSongService.getRandomSong()).willReturn(song);

    // when
    var response = songsController.random();

    // then
    assertEquals("Regular John", response.getBody().getTitle());
  }
}
