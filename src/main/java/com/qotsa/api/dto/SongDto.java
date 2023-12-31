package com.qotsa.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;
import lombok.Data;

/**
 * DTO (Data Transfer Object) class for a song.
 */
@Entity
@Data
@Table(name = "songs", schema = "qotsa")
public class SongDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long songId;

  @Schema(description = "The title of a song", example = "Regular John")
  public String title;

  @Schema(description = "The title of an album", example = "Queens of the Stone Age")
  public int album;

  @Schema(description = "The duration of a song", example = "00:04:35")
  public Time duration;

  @Schema(description = "The lyrics of a song", example = "Who are you girl?...")
  public String[] lyrics;

  @Schema(description = "A String array of artists who wrote the song", example = "['Josh Homme']")
  public String[] writtenBy;

  @Schema(description = "The url to a song on Spotify", example = "https://open.spotify.com/track/0R0m9mTXa81zp1qtcU3dSR?si=3f761edcdc2b4279")
  public String spotifyUrl;
}
