package com.uptc.frw.periodicoredis.repository;

import com.uptc.frw.periodicoredis.model.Journalist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalistRepository extends JpaRepository<Journalist,Long> {
}
