package com.qotsa.api.domain.model;

import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a song in the domain model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

  /**
   * The title of the song.
   */
  public String title;

  /**
   * The album to which the song belongs.
   */
  public String album;

  /**
   * The duration of the song.
   */
  public Time duration;

  /**
   * The lyrics of the song.
   */
  public String lyrics;

  /**
   * The list of people who wrote the song.
   */
  public String[] writtenBy;

  /**
   * The URL of the song on Spotify.
   */
  public String spotifyUrl;
}
