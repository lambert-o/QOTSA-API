package com.qotsa.api.controller;

import com.qotsa.api.domain.model.Album;
import com.qotsa.api.domain.response.SingleAlbumResponse;
import com.qotsa.api.service.RandomAlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling album-related endpoints.
 */
@Log4j2
@RestController
@RequiredArgsConstructor
public class AlbumsController implements AlbumsControllerApiSpec {

  /**
   * The base path for album-related endpoints.
   */
  public static final String ALBUMS_PATH = "/v1/albums";

  private final RandomAlbumService randomAlbumService;
  private final ModelMapper modelMapper;

  /**
   * Retrieves a response with a randomly selected album.
   *
   * @return ResponseEntity containing the {@link SingleAlbumResponse}.
   */
  @Override
  public ResponseEntity<SingleAlbumResponse> random() {
    log.info("Calling random album service");
    Album album = randomAlbumService.getRandomAlbum();
    SingleAlbumResponse singleAlbumResponse = modelMapper.map(album, SingleAlbumResponse.class);
    return ResponseEntity.ok(singleAlbumResponse);
  }
}
