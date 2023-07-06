package com.qotsa.api.service;

import com.qotsa.api.domain.model.Album;
import com.qotsa.api.dto.AlbumDto;
import com.qotsa.api.dto.SongDto;
import com.qotsa.api.repository.AlbumRepository;
import com.qotsa.api.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class RandomAlbumService {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    public Album getRandomAlbum() {
        AlbumDto albumDto = albumRepository.getRandom();
        SongDto[] songDtos = songRepository.getAllFromAlbum(albumDto.getAlbum_id());
        String[] songTitles = Arrays.stream(songDtos)
                .map(SongDto::getTitle)
                .toArray(String[]::new);
        Album album = new Album(albumDto.getTitle(), albumDto.getNumberOfSongs(), albumDto.getDuration(), albumDto.getReleaseDate(),
                albumDto.getSpotifyUrl(), songTitles);
        return album;
    }
}
