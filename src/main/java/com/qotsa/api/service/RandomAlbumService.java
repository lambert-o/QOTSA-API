package com.qotsa.api.service;

import com.qotsa.api.domain.model.Album;
import com.qotsa.api.dto.AlbumDto;
import com.qotsa.api.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RandomAlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    public Album getRandomAlbum() {
        AlbumDto albumDto = albumRepository.getRandom();
        Album album = modelMapper.map(albumDto, Album.class);
        return album;
    }
}
