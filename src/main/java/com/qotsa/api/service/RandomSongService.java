package com.qotsa.api.service;

import com.qotsa.api.domain.model.Song;
import com.qotsa.api.dto.AlbumDto;
import com.qotsa.api.dto.SongDto;
import com.qotsa.api.repository.AlbumRepository;
import com.qotsa.api.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RandomSongService {

  private final SongRepository songRepository;
  private final AlbumRepository albumRepository;

  public Song getRandomSong() {
    SongDto songDto = songRepository.getRandom();
    AlbumDto albumDto = albumRepository.getReferenceById(Long.valueOf(songDto.getAlbum()));
    Song song = new Song(songDto.getTitle(), albumDto.getTitle(), songDto.getDuration(),
            songDto.getLyrics(), songDto.getWrittenBy(), songDto.getSpotifyUrl());
    return song;
  }
}
