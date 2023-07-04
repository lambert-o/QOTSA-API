package com.qotsa.api.service;

import com.qotsa.api.dto.AlbumDto;
import com.qotsa.api.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RandomAlbumServiceTest {

    @Mock
    AlbumRepository albumRepository;

    @Spy
    ModelMapper modelMapper;

    @InjectMocks
    RandomAlbumService randomAlbumService;

    @Test
    void shouldReturnValidResponseWhenRequestValid() {
        // given
        AlbumDto albumDto = new AlbumDto();
        albumDto.setAlbum_id(1L);
        albumDto.setTitle("Queens of the Stone Age");
        albumDto.setNumberOfSongs(11);
        albumDto.setDuration(Time.valueOf("00:46:27"));
        albumDto.setReleaseDate(Date.valueOf("1998-09-22"));
        albumDto.setSpotifyUrl("https://open.spotify.com/album/0PSTqZ8cInMb1Wr68Uqdwp?si=7WqTEOlNTKaCdfhxeAf8Vg");
        given(albumRepository.getRandom()).willReturn(albumDto);

        // when
        var response = randomAlbumService.getRandomAlbum();

        // then
        assertEquals("Queens of the Stone Age", response.getTitle());
    }
}
