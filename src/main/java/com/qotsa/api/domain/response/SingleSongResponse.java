package com.qotsa.api.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

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
