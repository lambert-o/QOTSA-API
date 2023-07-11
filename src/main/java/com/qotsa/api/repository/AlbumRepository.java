package com.qotsa.api.repository;

import com.qotsa.api.dto.AlbumDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumDto, Long> {

  @Query(value = "SELECT * FROM qotsa.albums ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
  AlbumDto getRandom();
}
