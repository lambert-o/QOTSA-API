package com.qotsa.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import lombok.Data;

@Entity
@Data
@Table(name = "albums", schema = "qotsa")
public class AlbumDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long albumId;

  @Schema(description = "The title of an album", example = "Queens of the Stone Age")
  public String title;

  @Schema(description = "The number of songs in the album", example = "11")
  public int numberOfSongs;

  @Schema(description = "The duration of an album", example = "00:46:27")
  public Time duration;

  @Schema(description = "The album release date", example = "1998-09-22")
  public Date releaseDate;

  @Schema(description = "The url to an album on Spotify", example = "https://open.spotify.com/album/0PSTqZ8cInMb1Wr68Uqdwp?si=7WqTEOlNTKaCdfhxeAf8Vg")
  public String spotifyUrl;
}
