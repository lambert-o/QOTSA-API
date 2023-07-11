package com.qotsa.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import com.qotsa.api.dto.AlbumDto;
import com.qotsa.api.dto.SongDto;
import com.qotsa.api.repository.AlbumRepository;
import com.qotsa.api.repository.SongRepository;
import java.sql.Date;
import java.sql.Time;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RandomSongServiceTest {

  @Mock
  SongRepository songRepository;

  @Mock
  AlbumRepository albumRepository;

  @InjectMocks
  RandomSongService randomSongService;

  @Test
  void shouldReturnValidResponseWhenRequestValid() {
    // given
    SongDto songDto = createSongDto();
    AlbumDto albumDto = createAlbumDto();
    given(songRepository.getRandom()).willReturn(songDto);
    given(albumRepository.getReferenceById(songDto.getSongId())).willReturn(albumDto);

    // when
    var response = randomSongService.getRandomSong();

    // then
    assertEquals("Regular John", response.getTitle());
  }

  SongDto createSongDto() {
    String[] artists = new String[]{"Josh Homme", "Alfredo Hernandez", "John McBain"};
    SongDto songDto = new SongDto();
    songDto.setSongId(1L);
    songDto.setTitle("Regular John");
    songDto.setAlbum(1);
    songDto.setDuration(Time.valueOf("00:04:35"));
    songDto.setLyrics("Who are you girl?...");
    songDto.setWrittenBy(artists);
    songDto.setSpotifyUrl("https://open.spotify.com/track/0R0m9mTXa81zp1qtcU3dSR?si=3f761edcdc2b4279");
    return songDto;
  }

  AlbumDto createAlbumDto() {
    AlbumDto albumDto = new AlbumDto();
    albumDto.setAlbumId(1L);
    albumDto.setTitle("Queens of the Stone Age");
    albumDto.setNumberOfSongs(11);
    albumDto.setDuration(Time.valueOf("00:46:27"));
    albumDto.setReleaseDate(Date.valueOf("1998-09-22"));
    albumDto.setSpotifyUrl("https://open.spotify.com/album/0PSTqZ8cInMb1Wr68Uqdwp?si=7WqTEOlNTKaCdfhxeAf8Vg");
    return albumDto;
  }
}
