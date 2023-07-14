package com.qotsa.api.domain.model;

import java.sql.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an album in the domain model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

  /**
   * The title of the album.
   */
  public String title;

  /**
   * The number of songs in the album.
   */
  public int numberOfSongs;

  /**
   * The total duration of the album.
   */
  public Time duration;

  /**
   * The release date of the album.
   */
  public Date releaseDate;

  /**
   * The URL of the album on Spotify.
   */
  public String spotifyUrl;

  /**
   * The array of songs included in the album.
   */
  public String[] songs;
}
