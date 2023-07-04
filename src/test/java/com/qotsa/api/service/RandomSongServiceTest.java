package com.qotsa.api.service;

import com.qotsa.api.dto.SongDto;
import com.qotsa.api.repository.SongRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RandomSongServiceTest {

    @Mock
    SongRepository songRepository;

    @Spy
    ModelMapper modelMapper;

    @InjectMocks
    RandomSongService randomSongService;

    @Test
    void shouldReturnValidResponseWhenRequestValid() {
        // given
        String[] artists = new String[]{"Josh Homme", "Alfredo Hernandez", "John McBain"};
        SongDto songDto = new SongDto();
        songDto.setSong_id(1L);
        songDto.setTitle("Regular John");
        songDto.setAlbum(1);
        songDto.setDuration(Time.valueOf("00:04:35"));
        songDto.setLyrics("Who are you girl?...");
        songDto.setWrittenBy(artists);
        songDto.setSpotifyUrl("https://open.spotify.com/track/0R0m9mTXa81zp1qtcU3dSR?si=3f761edcdc2b4279");
        given(songRepository.getRandom()).willReturn(songDto);

        // when
        var response = randomSongService.getRandomSong();

        // then
        assertEquals("Regular John", response.getTitle());
    }
}
