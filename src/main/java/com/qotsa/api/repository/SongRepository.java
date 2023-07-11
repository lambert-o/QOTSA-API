package com.qotsa.api.repository;

import com.qotsa.api.dto.SongDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongDto, Long> {

  @Query(value = "SELECT s FROM SongDto s ORDER BY RANDOM() LIMIT 1")
  SongDto getRandom();

  @Query(value = "SELECT s FROM SongDto s WHERE s.album = :albumId")
  SongDto[] getAllFromAlbum(@Param("albumId") Long albumId);
}
