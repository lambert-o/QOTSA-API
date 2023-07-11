package com.qotsa.api.domain.model;

import java.sql.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
  public String title;
  public int numberOfSongs;
  public Time duration;
  public Date releaseDate;
  public String spotifyUrl;
  public String[] songs;
}
