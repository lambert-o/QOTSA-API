package com.qotsa.api.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleAlbumResponse {
    public String title;
    public int numberOfSongs;
    public Time duration;
    public Date releaseDate;
    public String spotifyUrl;
    public String[] songs;
}
