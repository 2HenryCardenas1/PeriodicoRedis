package com.uptc.frw.periodicoredis.repository;

import com.uptc.frw.periodicoredis.model.New;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<New, Long> {
}
