package com.qotsa.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    public String title;
    public int numberOfSongs;
    public Time duration;
    public Date releaseDate;
    public String spotifyUrl;
}
