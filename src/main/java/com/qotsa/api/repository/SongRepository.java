package com.qotsa.api.repository;

import com.qotsa.api.dto.SongDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongDto, Long> {

    @Query(value = "SELECT * FROM qotsa.songs ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    SongDto getRandom();
}
