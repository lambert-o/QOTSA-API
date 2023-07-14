package com.qotsa.api.controller;

import static com.qotsa.api.controller.SongsController.SONGS_PATH;

import com.qotsa.api.domain.response.SingleSongResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * API specification for song-related endpoints.
 */
@RequestMapping(value = SONGS_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public interface SongsControllerApiSpec {

  @Operation(
      summary = "Gets a random QOTSA song",
      description = "Returns a single random song",
      responses = {
        @ApiResponse(responseCode = "200", description = "Song response", content = {
          @Content(schema = @Schema(implementation = SingleSongResponse.class))
        }),
        @ApiResponse(responseCode = "500",
          description = "Internal Server Error / No message available", content = {
            @Content(examples = @ExampleObject(value = "{\n"
                    + "  \"status\": 500,\n"
                    + "  \"message\": \"Cannot process request\"\n"
                    + "}"))
          })
      }
  )
  @GetMapping("/random")
  ResponseEntity<SingleSongResponse> random();
}
