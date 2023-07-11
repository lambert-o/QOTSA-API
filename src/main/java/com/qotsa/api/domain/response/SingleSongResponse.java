package com.qotsa.api.domain.response;

import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleSongResponse {
  public String title;
  public String album;
  public Time duration;
  public String lyrics;
  public String[] writtenBy;
  public String spotifyUrl;
}
