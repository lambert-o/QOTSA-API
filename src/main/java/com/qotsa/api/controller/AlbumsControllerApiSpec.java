package com.qotsa.api.controller;

import static com.qotsa.api.controller.AlbumsController.ALBUMS_PATH;

import com.qotsa.api.domain.response.SingleAlbumResponse;
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
 * API specification for album-related endpoints.
 */
@RequestMapping(value = ALBUMS_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public interface AlbumsControllerApiSpec {

  @Operation(
      summary = "Gets a random QOTSA album",
      description = "Returns a single random album",
      responses = {
        @ApiResponse(responseCode = "200", description = "Album response", content = {
          @Content(schema = @Schema(implementation = SingleAlbumResponse.class))
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
  ResponseEntity<SingleAlbumResponse> random();
}
