package com.qotsa.api.service;

import com.qotsa.api.domain.model.Song;
import com.qotsa.api.dto.SongDto;
import com.qotsa.api.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RandomSongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    public Song getRandomSong() {
        SongDto songDto = songRepository.getRandom();
        Song song = modelMapper.map(songDto, Song.class);
        return song;
    }
}
