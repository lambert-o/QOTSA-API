package com.qotsa.api.repository;

import com.qotsa.api.dto.HelloDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDatabaseRepository extends JpaRepository<HelloDto, Long> {
}
