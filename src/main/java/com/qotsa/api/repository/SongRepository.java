package com.qotsa.api.repository;

import com.qotsa.api.dto.SongDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing song data.
 */
@Repository
public interface SongRepository extends JpaRepository<SongDto, Long> {

  /**
   * Retrieves a random song from the repository.
   *
   * @return A random {@link SongDto} object.
   */
  @Query(value = "SELECT s FROM SongDto s ORDER BY RANDOM() LIMIT 1")
  SongDto getRandom();

  /**
   * Retrieves all songs from the repository that belong to the specified album.
   *
   * @param albumId The ID of the album.
   * @return An array of {@link SongDto} objects belonging to the album.
   */
  @Query(value = "SELECT s FROM SongDto s WHERE s.album = :albumId")
  SongDto[] getAllFromAlbum(@Param("albumId") Long albumId);
}
