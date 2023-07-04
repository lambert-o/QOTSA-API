package com.qotsa.api.controller;

import com.qotsa.api.domain.model.Song;
import com.qotsa.api.domain.response.SingleSongResponse;
import com.qotsa.api.service.RandomSongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class SongsController implements SongsControllerApiSpec {

    public static final String SONGS_PATH = "/v1/songs";

    private final RandomSongService randomSongService;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<SingleSongResponse> random() {
        log.info("Calling random song service");
        Song song = randomSongService.getRandomSong();
        SingleSongResponse singleSongResponse = modelMapper.map(song, SingleSongResponse.class);
        return ResponseEntity.ok(singleSongResponse);
    }
}
