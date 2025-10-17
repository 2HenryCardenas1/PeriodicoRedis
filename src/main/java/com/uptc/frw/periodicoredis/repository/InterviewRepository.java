package com.uptc.frw.periodicoredis.repository;

import com.uptc.frw.periodicoredis.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
