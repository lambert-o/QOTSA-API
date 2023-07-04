package com.qotsa.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    public String title;
    public int album;
    public Time duration;
    public String lyrics;
    public String[] writtenBy;
    public String spotifyUrl;
}
