package com.qotsa.api.service;

import com.qotsa.api.domain.model.Album;
import com.qotsa.api.dto.AlbumDto;
import com.qotsa.api.dto.SongDto;
import com.qotsa.api.repository.AlbumRepository;
import com.qotsa.api.repository.SongRepository;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for retrieving a random album from the repository.
 *
 * <p>This class provides a service for fetching a random album from the {@link AlbumRepository}.
 * It utilizes the {@link SongRepository} to retrieve the associated songs for the album.
 * The retrieved album data is used to create an {@link Album} object, which is then returned.</p>
 *
 * @see AlbumRepository
 * @see SongRepository
 * @see AlbumDto
 * @see SongDto
 * @see Album
 */
@Service
@RequiredArgsConstructor
public final class RandomAlbumService {

  private final AlbumRepository albumRepository;
  private final SongRepository songRepository;

  /**
   * Retrieves a random album from the repository.
   *
   * @return A random {@link Album} object.
   */
  public Album getRandomAlbum() {
    AlbumDto albumDto = albumRepository.getRandom();
    SongDto[] songDtos = songRepository.getAllFromAlbum(albumDto.getAlbumId());
    String[] songTitles = Arrays.stream(songDtos)
            .map(SongDto::getTitle)
            .toArray(String[]::new);
    Album album = new Album(albumDto.getTitle(), albumDto.getNumberOfSongs(),
            albumDto.getDuration(), albumDto.getReleaseDate(), albumDto.getSpotifyUrl(),
            songTitles);
    return album;
  }
}
